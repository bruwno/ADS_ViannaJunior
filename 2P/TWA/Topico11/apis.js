
/*
fetch('./teste.txt').then(response => { // 1ª etapa, busca das informação.
    return response.text(); // 2ª etapa, leitura do arquivo como TEXTO.
}).then(response => {
    console.log(response); // 3ª etapa, exibição.
})
*/

fetch('./caderneta.json').then(response => { // 1ª etapa, busca das informação.
    return response.json(); // 2ª etapa, leitura do arquivo como TEXTO.
}).then(data => {
    return data.Enderecos
}).then(caderneta => {
    let codigo = '<ul> \n';
    caderneta.forEach(contato => {
        codigo += `<li> ${contato.nome}</li>`;
    });
    codigo += `</ul>`;
    document.body.innerText += codigo;
});