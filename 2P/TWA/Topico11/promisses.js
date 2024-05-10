const rua = new Promise(function (resolve, reject) {
    let condicao = true;
    let endereco;

    setTimeout(() => {
        endereco = "Rua Z";
        if (condicao) {
            resolve(endereco);
        } else {
            reject(Error("Não foi possível carregar um endereço!"));
        }

    }, 2500);
});

rua.then((resolve) => {
    document.body.innerText = resolve;
}).catch(reject => {
    document.body.innerText = reject;
}).finally(() => {
    document.body.innerHTML += `<br> Processamento finalizado`;
});

//
const cidade = new Promise(function (resolve, reject) {
    let condicao;

    setTimeout(() => {
        condicao = true;
        if (condicao) {
            resolve("Juiz de Fora");
        } else {
            reject(Error("Não foi possível carregar um endereço!"));
        }
    }, 3000);
});

const endereco = Promise.all([rua, cidade]);

document.body.innerText = "Carregando...";