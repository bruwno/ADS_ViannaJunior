const dotenv = require("dotenv");
const jsonwebtoken = require("jsonwebtoken");

dotenv.config();

const PRIVATE_KEY = process.env.PRIVATE_KEY;
const user = {
    name: "William Silva",
    email: "william.silva@viannasempre.com.br"
};

function tokenValidado(req, res, next) {
    const [, token] = req.headers.authorization?.split(" ") || ["", ""];

    if (!token) return res.status(401).send("Acesso negado. Nenhum token fornecido.");

    try {
        const payload = jsonwebtoken.verify(token, PRIVATE_KEY);
        const userIdFromToken = typeof payload !== "string" && payload.user;

        if (!user && !userIdFromToken) {
            return res.status(401).json({ message: "Token inválido" });
        }

        req.headers["user"] = payload.user;

        return next();
    } catch (error) {
        console.log(error);
        return res.status(401).json({ message: "Token inválido" });
    }
}

module.exports = { PRIVATE_KEY, user, tokenValidado };