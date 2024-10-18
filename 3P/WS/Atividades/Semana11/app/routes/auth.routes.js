const express = require('express');
const jsonwebtoken = require('jsonwebtoken');
const { user, PRIVATE_KEY } = require("../../auth.js");

const router = express.Router();


router.post("/login", (req, res) => {
  const { email, password } = req.body;

  try {
    const correctPassword = (email === process.env.EMAIL) && (password === process.env.PASSWORD);

    if (!correctPassword) {
      return res.status(401).send("Senha ou e-mail inválido!");
    }

    const token = jsonwebtoken.sign(
      { user: JSON.stringify(user) }, PRIVATE_KEY, { expiresIn: `${process.env.TOKEN_EXPIRATION}m` }
    );

    return res.status(200).json({
      data: { user, token, tokenDuration: process.env.TOKEN_EXPIRATION }
    });
  } catch (error) {
    console.log(error);
    return res.status(500).send(error);
  }
});

module.exports = router;