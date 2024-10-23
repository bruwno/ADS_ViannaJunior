import qs from "query-string";
import axios from "axios";

// Pedido de autorização que devolve o "code"
function redirectToGithub() {
  const GITHUB_AUTH_URL = 'https://github.com/login/oauth/authorize';
  const params = {
    response_type: 'code',
    scope: 'user',
    client_id: process.env.CLIENT_ID,
    redirect_uri: process.env.REDIRECT_URL,
  }

  const queryStrings = qs.stringify(params);
  const authorizationUrl = `${GITHUB_AUTH_URL}?${queryStrings}`;
  window.location.href = authorizationUrl; // Redireciona (altera a página atual) o navegador para ao authorization url.
}

window.onload = async () => { // Garante que só irá executar depois de carregar a página.
  document.querySelector(".login").addEventListener("click", redirectToGithub);

  // Pega o "code" que volta do GitHub
  const { code } = qs.parseUrl(window.location.href).query; // Dese(struct)
  if(code) {
    try {
    // O axios é uma lib que substitui o fetch, com mais recursos.
      const response = await axios.post(`${process.env.BACK_END_URL}/login`, { code }); // Passagem do "code" para o servidor.
      const user = response.data; // Com o "code" o servidor devolve as informações do usuário.
      alert("você está logado! Verifique o console");
      console.log(user);
    } catch (err) {
      alert("Ops, deu erro! Verifique o console");
      console.log("err", err);
    }
  }
}