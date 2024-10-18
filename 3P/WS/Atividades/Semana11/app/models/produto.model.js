module.exports = (sequelize, Sequelize) => {
    const Produto = sequelize.define("produto", {
        id: {
            type: Sequelize.INTEGER,
            autoIncrement: true,
            primaryKey: true,
        },
        nomeProduto: {
            type: Sequelize.STRING,
            allowNull: false,
        },
        precoUnitario: {
            type: Sequelize.DOUBLE,
            allowNull: false,
        },
        quantidade: {
            type: Sequelize.INTEGER,
            allowNull: false,
        },
        categoria: {
            type: Sequelize.STRING,
            allowNull: false,
        },
        fabricanteNome: {
            type: Sequelize.STRING,
            allowNull: false,
        },
        fabricanteLogradouro: {
            type: Sequelize.STRING,
        },
        fabricanteNumero: {
            type: Sequelize.STRING,
        },
        fabricanteBairro: {
            type: Sequelize.STRING,
        },
        fabricanteCidade: {
            type: Sequelize.STRING,
        },
        fabricanteCep: {
            type: Sequelize.STRING,
        },
        fabricanteUf: {
            type: Sequelize.STRING,
        },
        fabricanteTelefone: {
            type: Sequelize.STRING,
        }
    }, {
        tableName: 'produtos',
    });

    return Produto;
};