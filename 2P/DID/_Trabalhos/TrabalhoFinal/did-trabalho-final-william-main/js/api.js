import { Pokemon } from "./pokemon.js";

export async function getPokemonData(id) {
    const response = await fetch(`https://pokeapi.co/api/v2/pokemon/${id}`);
    if (response.status != 200) {
        return null;
    }
    const data = await response.json();

    return new Pokemon(
        data.id,
        data.name,
        data.sprites.front_default,
        data.types.map(typeData => typeData.type.name)
    );
}