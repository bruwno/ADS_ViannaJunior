const clientID = "fdo5fms87kgx3rqs7bi7nj9jwuhy4r";
const clientSecret = "orijkl7ish6rx2lgr97wxdh85wun4x";

const getToken = async () => {
  try {
    const result = await fetch("https://id.twitch.tv/oauth2/token", {
      method: "POST",
      headers: {
        "Content-Type": "application/x-www-form-urlencoded",
      },
      body: new URLSearchParams({
        client_id: clientID,
        client_secret: clientSecret,
        grant_type: "client_credentials",
      }),
    });

    if (!result.ok) {
      throw new Error(
        `Ocorreu um erro ao tentar obter o Token: [STATUS] ${result.status} - ${result.statusText}`
      );
    }

    const data = await result.json();
    return data.access_token;

  } catch (error) {
    console.error(`Ocorreu um erro ao requisitar o Token: ${error.message}`);
  }
};

const getEndpointData = async (endpoint, fields, limit = 10, offset = 0) => {
  try {
    const token = await getToken();

    const response = await fetch(`https://api.igdb.com/v4/${endpoint}`, {
      method: "POST",
      headers: {
        "Client-ID": clientID,
        Authorization: `Bearer ${token}`,
        "Content-Type": "application/json",
      },
      body: `fields ${fields}; limit ${limit}; offset ${offset};`,
    });

    if (!response.ok) {
      throw new Error(
        `Ocorreu um erro ao tentar obter os dados do endpoint ${endpoint}: [STATUS] ${response.status} - ${response.statusText}`
      );
    }

    const data = await response.json();
    console.log(`Dados de ${endpoint}:`, data);

  } catch (error) {
    console.error(`Ocorreu um erro ao tentar consultar o endpoint ${endpoint}.\nErro: ${error.message}`
    );
  }
};

getEndpointData("games", "id, name", 5, 10);
getEndpointData("genres", "id, name");
getEndpointData("characters", "id, name", 5, 10);
