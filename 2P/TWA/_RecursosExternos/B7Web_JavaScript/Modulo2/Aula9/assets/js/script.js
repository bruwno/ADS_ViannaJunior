/*
 Crie uma função que valide usuário e senha.
 Usuário correto: William
 Senha correta: 123
 */

let usuario = "William";
let senha = 123;

function validaLogin(usuario, senha) {
    return (usuario === "William" && senha === 123);
}

let validacao = validaLogin(usuario, senha);

if (validacao) {
    console.log("Acesso concedido.");
} else {
    console.log("Acesso negado.");
}