import qs from "query-string";
import axios from "axios";

function redirectToGithub() {
  const GITHUB_AUTH_URL = "https://github.com/login/oauth/authorize";

  const params = {
    response_type: 'code',
    scope: 'user',
    client_id: process.env.CLIENT_ID,
    redirect_uri: process.env.REDIRECT_URL,
  }

  const queryStrings = qs.stringify(params);
  const authorizationUrl = `${GITHUB_AUTH_URL}?${queryStrings}`;
  window.location.href = authorizationUrl;//Redireciona o endereço para a página do github
}

window.onload = async () => {//Vai exercutar quando carregar a página

  //botão
  document.querySelector(".login").addEventListener("click", redirectToGithub);

  //Valida se o user estar vericado pelo github
  const { code } = qs.parseUrl(window.location.href).query; //Desescrut - verifica se retornou o code corretamente do github

  if(code) {
    try {

      const response = await axios.post(`${process.env.// axios é igual fetch, porem com mais recursos
        BACK_END_URL}/login`, { code });// Passa o code para o servidor 
        const user = response.data;// Com o code o servidor devolve as informações do usuario
        alert("Você está logado! Verifique o console");
        console.log(user);

    } catch (err) {

      alert("Ops, deu erro! Verifique o console");
      console.log("err", err);
    }

  }
}