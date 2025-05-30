import express from "express";
import jsonwebtoken from "jsonwebtoken";
import { user, PRIVATE_KEY, tokenValidated } from "./auth.js"

const PORTA = 45678;

const api = express();
api.use(express.json());

api.get("/", (_, res) => {
  res.status(200).json({
    message: "Esta é a rota pública!",
  });
});

api.get("/login", (req, res) => {
  const [, hash] = req.headers.authorization?.split(" ") || [" ", " "];
  const [email, password] = Buffer.from(hash, "base64").toString().split(":");

  try {
    const correctPassword = (email === "zezinho@example.com") && (password === "123456");

    if (!correctPassword) {
      return res.status(401).send("Senha ou e-mail inválido!"); // 401 - Unauthorized
    }

    const token = jsonwebtoken.sign(
      { user: JSON.stringify(user) }, PRIVATE_KEY, { expiresIn: "60m" }
    );

    return res.status(200).json({ data: { user, token } });
  } catch (error) {
    console.log(error);
    return res.send(error);
  }
});

api.use("*", tokenValidated); // O * indica que todos os endpoints que vierem abaixo irão utilizar o middleware tokenValidated.
                              // Logo, o token já foi validado e o endpoint private não precisa realizar esta validação.

api.get("/private", (req, res) => {
  const { user } = req.headers;
  const currentUser = JSON.parse(user);
  return res.status(200).json({
    message: "Esta é uma rota privada",
    data: {
      userLogged: currentUser,
    },
  });
});

api.listen(45678, () => {
  console.log(`Aplicação escutando na porta ${PORTA}`);
});