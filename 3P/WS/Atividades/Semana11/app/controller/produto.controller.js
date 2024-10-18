const db = require("../models");
const Produto = db.produtos;

const Op = db.Sequelize.Op;

exports.create = (req, res) => {
    const produto = {
        nomeProduto: req.body.nomeProduto,
        precoUnitario: req.body.precoUnitario,
        quantidade: req.body.quantidade,
        categoria: req.body.categoria,
        fabricanteNome: req.body.fabricanteNome,
        fabricanteLogradouro: req.body.fabricanteEndereco.logradouro,
        fabricanteNumero: req.body.fabricanteEndereco.numero,
        fabricanteBairro: req.body.fabricanteEndereco.bairro,
        fabricanteCidade: req.body.fabricanteEndereco.cidade,
        fabricanteCep: req.body.fabricanteEndereco.cep,
        fabricanteUf: req.body.fabricanteEndereco.uf,
        fabricanteTelefone: req.body.fabricanteTelefone
    };
    Produto.create(produto)
    .then(data => {
        res.send(data);
    })
    .catch(err => {
        res.status(500).send({
            message: err.message || "Ocorreu um erro ao criar o produto."
        });
    });
};

exports.findAll = (req, res) => {
    const nomeProduto = req.query.nomeProduto;
    var condition = nomeProduto ? { nomeProduto: { [Op.like]: `%${nomeProduto}%` } } : null;
    
    Produto.findAll({ where: condition })
    .then(data => {
        res.send(data);
    })
    .catch(error => {
        res.status(500).send({
            message:
            error.message || "Ocorreu um erro ao recuperar os produtos."
        });
    }
)};

exports.findOne = (req, res) => {
    const id = req.params.id;
    
    Produto.findByPk(id)
    .then(data => {
        if (data) {
            res.send(data);
        } else {
            res.status(404).send({
                message: `Produto com id = ${id} não encontrado.`
            });
        }
    })
    .catch(error => {
        console.error(error);
        res.status(500).send({
            message: `Erro ao recuperar o produto com id = ${id}.`
        });
    });
};


exports.update = (req, res) => {
    const id = req.params.id;
    
    Produto.update(req.body, {
        where: { id: id }
    })
    .then(num => {
        if (num == 1) {
            res.send({
                message: "O produto foi atualizado com sucesso."
            });
        } else {
            res.status(400).send({
                message: `Não é possível atualizar o produto com id = ${id}.`
            });
        }
    })
    .catch(error => {
        res.status(500).send({
            message: `Erro ao atualizar o produto com id = ${id}\nErro: ${error}`
        });
    });
};

exports.delete = (req, res) => {
    const id = req.params.id;
    
    Produto.destroy({
        where: { id: id }
    })
    .then(num => {
        if (num == 1) {
            res.send({
                message: "O produto foi excluído com sucesso!"
            });
        } else {
            res.status(400).send({
                message: `Não é possível excluir o produto com id = ${id}.`
            });
        }
    })
    .catch(error => {
        res.status(500).send({
            message: `Erro ao excluir o produto com id = ${id}\nErro: ${error}`
        });
    });
};

exports.deleteAll = (req, res) => {
    Produto.destroy({
        where: {},
        truncate: true
    })
    .then(qtdProdutos => {
        if (qtdProdutos <= 0) {
            res.send({ message: "Não há produtos para serem excluídos." });
        } else {
            res.send({ message: `${qtdProdutos} produtos foram excluídos com sucesso!` });
        }
    })
    .catch(error => {
        res.status(500).send({
            message: `Ocorreu um erro ao excluir os produtos. \nErro: ${error}`
        });
    });
};