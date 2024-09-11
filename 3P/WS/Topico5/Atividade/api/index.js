const express = require("express");
var cors = require("cors");

const app = express();
app.use(express.json());
app.use(cors());

const porta = 40100;

var DB = {
  produtos: [
    {
      id: 1,
      fabricante: {
        nomeFabricante: "Samsung",
        endereco: {
          logradouro: "Av. Dr. Chucri Zaidan",
          numero: "1240",
          bairro: "Vila Cordeiro",
          cidade: "São Paulo",
          cep: "04576-020",
          uf: "SP",
        },
        telefone: "(11)5644-2800",
      },
      nomeProduto: "Galaxy A15",
      precoUnitario: 1000,
      quantidade: 100,
      categoria: "Celulares",
    },
    {
      id: 2,
      fabricante: {
        nomeFabricante: "AMD",
        endereco: {
          logradouro: "Rua George Ohm",
          numero: "230",
          bairro: "Cidade Monções",
          cidade: "São Paulo",
          cep: "04576-020",
          uf: "SP",
        },
        telefone: "(11)3478-2150",
      },
      nomeProduto: "Radeon RX 7900 XTX",
      precoUnitario: 6900,
      quantidade: 20,
      categoria: "Placas de Vídeo",
    },
    {
      id: 3,
      fabricante: {
        nomeFabricante: "AMD",
        endereco: {
          logradouro: "Rua George Ohm",
          numero: "230",
          bairro: "Cidade Monções",
          cidade: "São Paulo",
          cep: "04576-020",
          uf: "SP",
        },
        telefone: "(11)3478-2150",
      },
      nomeProduto: "Ryzen 7 5800X",
      precoUnitario: 1400,
      quantidade: 50,
      categoria: "Processadores",
    },
  ],
};

app.listen(porta, () => {
  console.log(`Escutando na porta ${porta}...`);
});

// Retorna todos os produtos.
app.get("/produto", (req, res) => {
  res.statusCode = 200;
  res.json(DB.produtos);
});

// Retorna produto por id.
app.get("/produto/:id", (req, res) => {
  if (isNaN(req.params.id)) {
    res.sendStatus(400); // Bad Request
  } else {
    var id = parseInt(req.params.id);
    const produto = DB.produtos.find((p) => p.id === id);

    if (produto != undefined) {
      res.statusCode = 200;
      res.json(produto);
    } else {
      res.sendStatus(404); // Not Found
    }
  }
});

// Adiciona um produto.
let idProd = DB.produtos.length;
app.post("/produto", (req, res) => {
  id = ++idProd;

  let { fabricante, nomeProduto, precoUnitario, quantidade, categoria } = req.body;

  const novoProduto = {
    id: idProd,
    fabricante: {
      nomeFabricante: fabricante.nomeFabricante,
      endereco: fabricante.endereco,
      telefone: fabricante.telefone,
    },
    nomeProduto,
    precoUnitario,
    quantidade,
    categoria,
  };

  DB.produtos.push(novoProduto);

  return res.status(201).json({ // Created
    message: "Produto adicionado com sucesso!",
    produto: novoProduto,
  });
});

// Altera os dados de um produto.
app.put("/produto/:id", (req, res) => {
    const id = parseInt(req.params.id);
    const produto = DB.produtos.find(p => p.id === id);

    if (isNaN(id)) {
        res.sendStatus(400); // Bad Request
    } else {
        if (produto) {
            const { fabricante, nomeProduto, precoUnitario, quantidade, categoria } = req.body;
    
            if (fabricante) {
                produto.fabricante.nomeFabricante = fabricante.nomeFabricante || produto.fabricante.nomeFabricante;
                produto.fabricante.endereco = fabricante.endereco || produto.fabricante.endereco;
                produto.fabricante.telefone = fabricante.telefone || produto.fabricante.telefone;
            }
    
            produto.nomeProduto = nomeProduto || produto.nomeProduto;
            produto.precoUnitario = precoUnitario || produto.precoUnitario;
            produto.quantidade = quantidade || produto.quantidade;
            produto.categoria = categoria || produto.categoria;
    
            return res.status(200).json({ // Success
                message: "Produto alterado com sucesso!",
                produto
            });
        } else {
            return res.status(404).json({ // Not Found
                message: `Nenhum produto encontrado com o id ${id}!`
            });
        }
    }
});
