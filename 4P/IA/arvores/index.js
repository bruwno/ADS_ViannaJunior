import Arvore from "./Arvore";
import No from "./No";

const noA = new No("A");
const noB = new No("B");
const noC = new No("C");
const noD = new No("D");
const noE = new No("E");
const noF = new No("F");
const noG = new No("G");
const noH = new No("H");
const noI = new No("I");

const arvore = new Arvore(noA);

noA.adicionarFilho(noB);
noA.adicionarFilho(noC);
noC.adicionarFilho(noB);
noC.adicionarFilho(noD);
noC.adicionarFilho(noE);
noC.adicionarFilho(noF);
noD.adicionarFilho(noG);
noD.adicionarFilho(noH);
noF.adicionarFilho(noI);

console.log(arvore);