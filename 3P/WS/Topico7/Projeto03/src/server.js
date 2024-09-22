import express from "express";
import jsonwebtoken from "jsonwebtoken";
//import { user, PRIVATE_KEY, tokenValidated } from "./auth.js"

const PORTA = 45678;

const api = express();
api.use(express.json());

api.get("/", (_, res) => {
    res.status(200).json({
        message: "Esta é a rota pública!"
    });
});

api.listen(45678, () => {
    console.log(`Aplicação escutando na porta ${PORTA}`);
});