import dotenv from "dotenv";
import express from "express";
import jsonwebtoken from "jsonwebtoken";
import { user, PRIVATE_KEY, tokenValidado } from "./auth.js"
import { carregarProdutos, salvarProdutos } from "./fileManager.js";

dotenv.config();

const PORT = process.env.PORT;
const EMAIL = process.env.EMAIL;
const PASSWORD = process.env.PASSWORD;
const TOKEN_EXPIRATION = process.env.TOKEN_EXPIRATION;

const api = express();
api.use(express.json());

api.get("/login", (req, res) => {
    const [, hash] = req.headers.authorization?.split(" ") || ["", ""];
    const [email, password] = Buffer.from(hash, "base64").toString().split(":");

    try {
        const correctPassword = (email === EMAIL) && (password === PASSWORD);

        if (!correctPassword) {
            return res.status(401).send("Senha ou e-mail inválido!");
        }

        const token = jsonwebtoken.sign(
            { user: JSON.stringify(user) }, PRIVATE_KEY, { expiresIn: `${TOKEN_EXPIRATION}m` }
        );

        return res.status(200).json({
            data:
            {
                user,
                token,
                tokenDuration: TOKEN_EXPIRATION
            }
        });
    } catch (error) {
        console.log(error);
        return res.send(error);
    }
});

api.get("/produtos", (_, res) => {
    const produtos = carregarProdutos();
    const nomesProd = produtos.map(produto => produto.nomeProduto);
    res.status(200).json(nomesProd);
});

api.use("*", tokenValidado);

api.get("/produtos/:id", (req, res) => {
    const produtos = carregarProdutos();
    const id = parseInt(req.params.id);
    const produto = produtos[id - 1];

    if (produto) {
        res.status(200).json(produto);
    } else {
        res.status(404).json({ message: "Produto não encontrado!" });
    }
});

api.post("/produtos", (req, res) => {
    let produtos = carregarProdutos();
    const novoProduto = {
        id: produtos.length + 1,
        fabricante: req.body.fabricante,
        nomeProduto: req.body.nomeProduto,
        precoUnitario: req.body.precoUnitario,
        quantidade: req.body.quantidade,
        categoria: req.body.categoria,
    };
    produtos.push(novoProduto);
    salvarProdutos(produtos);
    res.status(201).json({ message: "Produto adicionado com sucesso!" });
});

api.put("/produtos/:id", (req, res) => {
    let produtos = carregarProdutos();
    const id = parseInt(req.params.id);
    const produtoId = id - 1;

    if (produtos[produtoId]) {
        produtos[produtoId] = {
            id: id,
            fabricante: req.body.fabricante,
            nomeProduto: req.body.nomeProduto,
            precoUnitario: req.body.precoUnitario,
            quantidade: req.body.quantidade,
            categoria: req.body.categoria,
        };
        salvarProdutos(produtos);
        res.status(200).json({ message: "Produto atualizado com sucesso!" });
    } else {
        res.status(404).json({ message: "Produto não encontrado!" });
    }
});

api.listen(PORT, () => {
    console.log(`Aplicação escutando na porta ${PORT}`);
});