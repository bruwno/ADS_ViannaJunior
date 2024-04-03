let professions = [
    "Policial",
    "Bombeiro",
    "Fiscal"
];

let profession = professions[2];

switch (profession) {
    case "Policial":
        console.log("Policial - Uniforme Azul");
        break;
    case "Bombeiro":
        console.log("Bombeiro - Uniforme Vermelho");
        break;
    case "Fiscal":
        console.log("Fiscal de florestas - Uniforme Verde");
        break;
    default:
        console.log("Sem profissão");
}