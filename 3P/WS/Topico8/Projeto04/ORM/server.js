const express = require("express");
const cors = require("cors");

const app = express();

var corsOptions = {
  origin: "http://localhost:8081"
};

app.use(cors(corsOptions));

app.use(express.json());

app.use(express.urlencoded({ extended: true })); // Aceita requisições vindas da URL.

const db = require("./app/models");
db.sequelize.sync({ force: true }).then(() => { // force TRUE vai impedir que a base seja recriada a cada execução.
  console.log("Drop and re-sync db.");
});

app.get("/", (_, res) => {
  res.json({ message: "Welcome!" });
});

require("./app/routes/tutorial.routes")(app);
const PORT = process.env.PORT || 8082;

app.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}.`);
});