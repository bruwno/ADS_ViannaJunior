import fs from "fs";
import path from "path";
import { fileURLToPath } from "url";

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

export const carregarProdutos = () => {
    const data = fs.readFileSync(path.join(__dirname, "../produtos.json"));
    const jsonData = JSON.parse(data);
    return jsonData.produtos;
};

export const salvarProdutos = (produtos) => {
    const jsonData = { produtos };
    fs.writeFileSync(path.join(__dirname, "../produtos.json"), JSON.stringify(jsonData, null, 2));
};