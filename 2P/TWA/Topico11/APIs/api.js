// ViaCep     
// Melhor forma
const formulario = document.forms[0];
const cep = formulario.elements['cep'];
const logradouro = document.getElementById('logradouro');

formulario.addEventListener('submit', e => {
    e.preventDefault();

    buscaCep(cep.value);
});

async function buscaCep(cep) {
    const response = await fetch(`https://viacep.com.br/ws/${cep}/json/`);
    const data = await response.json();
    logradouro.innerText = data.logradouro;
}

// Pokemon
const pokeForm = document.forms[1];
const pokemon = document.getElementById('pokemon');
const pokeResult = document.getElementById('pokeResult');

pokeForm.addEventListener('submit', p => {
    p.preventDefault();
    pokeResult.innerText = 'Buscando...';
    buscaPokemon(pokemon.value);
})

async function buscaPokemon(pokemon) {
    const response = await fetch(`https://pokeapi.co/api/v2/pokemon/${pokemon}`);
    if (response.status === 404) {
        pokeResult.innerText = 'Pokémon não encontrado!';
    } else {
        const data = await response.json();
        pokeResult.innerHTML = `<img src=${data.sprites.front_default}>`;
    }
}