const promessa = new Promise(function(resolve, reject) {
    let condicao = true;

    if (condicao) {
        resolve("Estou pronto!");
    } else {
        reject(Error("Erro na leitura dos dados!"));
    }
});

promessa.then((resolve) => {
    document.body.innerText = resolve;
});