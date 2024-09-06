async function getAllGames() {
  const response = await fetch(`http://localhost:45678/game`);
  const data = await response.json();
  console.log(data);
}

getAllGames();

async function getGameById(id) {
  const response = await fetch(`http://localhost:45678/game/${id}`);
  const data = await response.json();
  console.log(data);
}

getGameById(23);