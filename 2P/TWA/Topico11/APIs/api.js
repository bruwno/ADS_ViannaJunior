// ViaCep
const formulario = document.forms[0];
const cep = formulario.elements['cep'];
const logradouro = document.getElementById('logradouro');

formulario.addEventListener('submit', e => {
    e.preventDefault();
    buscaCep(cep.value);
//     fetch(`https://viacep.com.br/ws/${cep.value}/json/`)
//     .then(response => {
//         return response.json();
//     }).then(data => {
//         logradouro.innerText = data.logradouro;
//     });
});

// Pokémon
const pokeForm = document.forms[1];
const pokemon = document.getElementById('pokemon');
const pokeResult = pokeForm.elements['pokemon-name'];

pokeForm.addEventListener('submit', e => {
    pokeResult.innerText = 'Buscando...';
    e.preventDefault();

    fetch(`https://pokeapi.co/api/v2/pokemon/${pokemon.value}`)
    .then(response => {
       if(response.status === 404) {
        pokeResult.innerText = 'Pokémon não encontrado!';
       } else {
        return response.json();
       }
    }).then(data => {
        pokeResult.innerHTML = `<img src=${data.sprites.front_default}>`
    });
});

// Função assíncrona
async function buscaCep(cep) {
    const response = await fetch(`https://viacep.com.br/ws/${cep}/json/`);
    const data = await response.json();

    logradouro.innerText = data.logradouro;
}