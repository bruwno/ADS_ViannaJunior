const express = require("express");
const app = express();

var DB = {
  produtos: [
    {
      fabricante: {
        nome: "Samsung",
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
      fabricante: {
        nome: "AMD",
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
      fabricante: {
        nome: "AMD",
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

app.listen(40100,() => {
    console.log("Escutando na porta 40100...");
    
})

app.get("/produtos",(req, res) => {
    res.statusCode = 200;
    res.json(DB.produtos);
});