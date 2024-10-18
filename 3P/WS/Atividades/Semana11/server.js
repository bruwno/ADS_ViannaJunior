const dotenv = require("dotenv");
const express = require("express");
const cors = require("cors");

dotenv.config();

const PORT = process.env.PORT || 3000;
const app = express();

const corsOptions = {
  origin: `http://localhost:${PORT}`
};

app.use(cors(corsOptions));

app.use(express.json());
app.use(express.urlencoded({ extended: true }));

const db = require("./app/models");
db.sequelize.sync({ force: true }).then(() => {
  console.log("A base de dados foi criada...");
});

const authRoutes = require("./app/routes/auth.routes");
app.use("/api/auth", authRoutes);

const { tokenValidado } = require("./auth.js");
app.use(tokenValidado);

require("./app/routes/produto.routes")(app);

app.listen(PORT, () => {
  console.log(`Aplicação escutando na porta ${PORT}`);
});