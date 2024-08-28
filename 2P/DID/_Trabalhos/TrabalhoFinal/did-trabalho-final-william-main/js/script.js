/*
const pokemonSearchInput = document.getElementById("pokemon-search");
const btnSearchPokemon = document.getElementById("btn-search");

let pokeCards = document.querySelectorAll(".card");

const pokemonName = document.getElementById("poke-name");
const pokemonId = document.getElementById("poke-id");
const pokemonSprite = document.getElementById("poke-sprite");
const pokemonTypes = document.getElementById("poke-types");

const btnPrevious = document.getElementById("btn-previous");
const btnNext = document.getElementById("btn-next");

let currentId = 1;
btnPrevious.style.display = "none";

async function getPokemonData(id) {
    const response = await fetch(`https://pokeapi.co/api/v2/pokemon/${id}`);
    if (response.status != 200) {
        return null;
    }
    const data = await response.json();

    // Criação do objeto.
    return {
        pokeId: data.id,
        pokeName: data.name,
        pokeSprite: data.sprites.front_default,
        pokeTypes: data.types
    }
}

async function updateData(info) {
    const pokemonData = await getPokemonData(info);
    pokemonId.innerText = pokemonData.pokeId;
    pokemonName.innerText = pokemonData.pokeName;
    pokemonSprite.setAttribute("src", pokemonData.pokeSprite);
    let types = "";
    pokemonData.pokeTypes.forEach(type => {
        types += `<li>${type.type.name}</li>`;
    });
    pokemonTypes.innerHTML = types;
}

//updateData();

// BOTÕES DE NAVEGAÇÃO
btnPrevious.addEventListener("click", ()=> {
    currentId--;
    updateData();
    if (currentId <= 1) {
        btnPrevious.style.display = "none";
    }
});

btnNext.addEventListener("click",()=> {
    currentId++;
    updateData();
    if (currentId > 0) {
        btnPrevious.style.display = "inline";
    }
});

// BUSCAR POKÉMON
btnSearchPokemon.addEventListener("click", event => {
    event.preventDefault();
    let searchSubject = pokemonSearchInput.value.trim().toLowerCase();
    updateData(searchSubject);
});


// CARREGAMENTO DA PÁGINA
document.addEventListener("DOMContentLoaded", ()=> {
    loadPokemons();
});

// PREENCHENDO OS CARD INICIAIS COM POKÉMONS
async function loadPokemons() {
    const cardContainer = document.getElementById("card");
    cardContainer.innerHTML = "";
    for (let i = 1; i <= 4; i++) {
        const pokemon = await getPokemonData(i);
        cardContainer.appendChild(createPokemonCard(pokemon));
    }
}

function createPokemonCard(pokemon) {
    const card= document.createElement("div");
    card.classList.add("card");

    const pokeName = document.createElement("h2");
    pokeName.innerText = pokemon.name;

    const pokeId = document.createElement("p");
    pokeId.innerText = `#${pokemon.id}`;

    const pokeSprite = document.createElement("img");
    pokeSprite.src = pokemon.sprites.front_default;
    pokeSprite.alt = pokemon.name;
    pokeSprite.width = 230;
    pokeSprite.height = 230;

    const pokeType = document.createElement("li");
    pokeType.innerHTML += `<li>${type.type.name}</li>`;

    card.appendChild(pokeName);
    card.appendChild(pokeId);
    card.appendChild(pokeSprite);
    card.appendChild(pokeType);

    return card;
}

async function searchPokemon() {
    const searchInput = pokemonSearchInput.value.trim().toLowerCase();
    if (searchInput) {
        const cardContainer = document.getElementById("poke-card");
        cardContainer.innerHTML = "";
        try {
            const pokemon = getPokemonData(searchInput);
            cardContainer.appendChild(createPokemonCard(pokemon));
        } catch (error) {
            cardContainer.innerHTML = "<p>Pokémon não encontrado! </p>";
        }
    }
}
*/
import { Pokemon } from "./pokemon.js";

const pokemonSearchInput = document.getElementById("pokemon-search");
const btnSearchPokemon = document.getElementById("btn-search");
const btnPrevious = document.getElementById("btn-previous");
const btnNext = document.getElementById("btn-next");

const pokemonName1 = document.getElementById("poke-name-1");
const pokemonId1 = document.getElementById("poke-id-1");
const pokemonSprite1 = document.getElementById("poke-sprite-1");
const pokemonTypes1 = document.getElementById("poke-types-1");

const pokemonName2 = document.getElementById("poke-name-2");
const pokemonId2 = document.getElementById("poke-id-2");
const pokemonSprite2 = document.getElementById("poke-sprite-2");
const pokemonTypes2 = document.getElementById("poke-types-2");

// Craregamento da página.
document.addEventListener("DOMContentLoaded", () => {
  loadInitialPokemon();
  btnSearchPokemon.addEventListener("click", searchPokemon);
  btnPrevious.addEventListener("click", () => navigatePokemon(-2));
  btnNext.addEventListener("click", () => navigatePokemon(2));
  pokemonSearchInput.addEventListener("keypress", event=> {
    if (event.key === "Enter") {
        searchPokemon();
    }
  });
});

let currentPokemonId = 1;

async function loadInitialPokemon() {
  await loadPokemon(currentPokemonId, currentPokemonId + 1);
}

async function loadPokemon(startId, endId) {
  const cards = [];

  for (let id = startId; id <= endId; id++) {
    try {
      const pokemon = await getPokemonData(id);
      cards.push(pokemon);
    } catch (error) {
      console.error(`Erro ao buscar Pokémon com ID ${id}:`, error);
    }
  }
  displayPokemon(cards);
}

async function getPokemonData(id) {
  const response = await fetch(`https://pokeapi.co/api/v2/pokemon/${id}`);

  if (response.status != 200) {
    return null;
  }

  const data = await response.json();

  return new Pokemon(
    data.id,
    data.name,
    data.sprites.other.dream_world.front_default,
    //data.sprites.other.home.front_default,
    data.types
  );
}

function displayPokemon(pokemonList) {
  const pokemons = [
    {
      name: pokemonName1,
      id: pokemonId1,
      sprite: pokemonSprite1,
      types: pokemonTypes1,
    },
    {
      name: pokemonName2,
      id: pokemonId2,
      sprite: pokemonSprite2,
      types: pokemonTypes2,
    },
  ];

  for (let i = 0; i < 2; i++) {
    const pokemon = pokemonList[i];
    const elements = pokemons[i];
    const cardId = `card-${i + 1}`;

    if (pokemon) {
      elements.name.innerText = pokemon.name;
      elements.id.innerText = pokemon.id.toString().padStart(4, "0");
      elements.sprite.src = pokemon.sprite;
      elements.sprite.alt = pokemon.name;
      elements.types.innerHTML = "";
      pokemon.types.forEach((type) => {
        elements.types.innerHTML += `<li>${type.type.name}</li>`;
      });
      document.getElementById(cardId).style.display = "block";
    } else {
      document.getElementById(cardId).style.display = "none";
    }
  }
}

async function searchPokemon() {
  const searchInput = pokemonSearchInput.value.trim().toLowerCase();
  if (searchInput === "" || searchInput === "0") {
    return;
  }

  if (searchInput) {
    try {
      const pokemon = await getPokemonData(searchInput);
      displayPokemon([pokemon]);
      currentPokemonId = pokemon.id;
    } catch (error) {
      alert("Pokémon não encontrado. Tente novamente.");
    }
  }
}

async function navigatePokemon(idIncrement) {
  currentPokemonId += idIncrement;
  if (currentPokemonId < 1) {
    currentPokemonId = 1;
  }

  try {
    await loadPokemon(currentPokemonId, currentPokemonId + 1);
  } catch (error) {
    currentPokemonId -= idIncrement;
    alert("Não foi possível carregar o próximo Pokémon.");
  }
}
