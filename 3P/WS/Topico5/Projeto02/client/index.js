const clientID = "73383683dbf548c0ba29c1f6da32527a";
const clientSecret = "711fc85ad7e9417f826cd232b79b9db9";

const getToken = async () => {
  const result = await fetch("https://accounts.spotify.com/api/token", {
    method: "POST",
    headers: {
      "Content-Type": "application/x-www-form-urlencoded",
      Authorization: "Basic " + btoa(clientID + ":" + clientSecret),
    },
    body: "grant_type=client_credentials",
  });

  const data = await result.json();
  return data.access_token;
};

const getGenres = async (token) => {
  const result = await fetch(
    `https://api.spotify.com/v1/browse/categories?locale=pt_BR`, {
      method: "GET", // Quando o método é o GET, ele pode ser omitido.
      headers: { Authorization: "Bearer " + token },
    }
  );

  const data = await result.json();
  return data.categories.items;
};

(async () => {
  const token = await getToken();
  const genres = await getGenres(token);
  console.log(genres);
})();
