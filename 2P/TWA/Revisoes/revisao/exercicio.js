// Utilize o exercício da Mariana, agora o usuário irá informar a quantidade através do formulário e o resultado deve ser inserido após o musica Música
// No segundo formulário o usuário ira fornecer a url de uma imagem, esse imagem deve ser inserida após o musica Galeria. Insira a tag img  dentro de uma div com a classe col-4 
// Modifique o exercício anterior: Insira um botão com as classes btn btn-secondary btn-sm btn-remove e o escrito X abaixo da imagem inserida. Ao clicar no botão toda a div deve ser removida
/*
Exercício 1: Criando um jogo da velha

Objetivo: criar um jogo da velha usando JavaScript e manipulação do DOM. Não precisa verificar vencedores.

<div>
  <table>
    <tr>
      <td id="0"></td>
      <td id="1"></td>
      <td id="2"></td>
    </tr>
    <tr>
      <td id="3"></td>
      <td id="4"></td>
      <td id="5"></td>
    </tr>
    <tr>
      <td id="6"></td>
      <td id="7"></td>
      <td id="8"></td>
    </tr>
  </table>
  <p id="status"></p>
  <a id="reset">Reiniciar jogo</a>
</div>


Exercício 2: Criando um contador de cliques
Objetivo: criar um contador de cliques usando JavaScript e manipulação do DOM.

<div>
  <button id="click-me">Clique aqui</button>
  <p>Você clicou <span id="counter">0</span> vezes</p>
</div>


Exercício 3: Criando uma lista de tarefas
Objetivo: criar uma lista de tarefas usando JavaScript e manipulação do DOM. Para pegar os valores dos inputs use a propriedade value

<div>
  <input type="text" id="new-task" placeholder="Digite uma nova tarefa">
  <button id="add-task">Adicionar tarefa</button>
  <ul id="task-list"></ul>
</div>



Exercício 4: Criando um jogo de memória
Objetivo: criar um jogo de memória usando JavaScript e manipulação do DOM.

<div>
  <div class="card" data-card="0"></div>
  <div class="card" data-card="1"></div>
  <div class="card" data-card="2"></div>
  <div class="card" data-card="3"></div>
  <div class="card" data-card="0"></div>
  <div class="card" data-card="1"></div>
  <div class="card" data-card="2"></div>
  <div class="card" data-card="3"></div>
</div>


.card {
  width: 50px;
  height: 50px;
  background-color: gray;
  margin: 10px;
  display: inline-block;
  cursor: pointer;
 transition: all 1s linear;
}


.flip{
background-color: white;
}

*/


// Exercício 1
// Referência do elemento pai.
let musica = document.querySelector(".col-12 > h1");
// Criar um novo elemento <div>.
let novaDiv = document.createElement("div");
// Personalizar o conteúdo do novo elemento.
novaDiv.setAttribute("style", "font-size: 20px");
// Adicionar o novo elemento ao elemento pai.
musica.appendChild(novaDiv);

let form1 = document.forms[0];

form1.addEventListener("submit", event => {
  event.preventDefault();
  const deveContarAte = form1.elements["inputQtd"].value;

  if (deveContarAte > 0) {
    if (novaDiv.innerText !== "") {
      novaDiv.innerText = "";
    } else {
      novaDiv.innerText = marianaConta(deveContarAte);
    }
  } else {
    alert("O campo não pode estar vazio!");
  }
});


var letra = "";
function marianaConta(contador = 5) {
  for (var i = 1; i <= contador; i++) {
    letra += `Mariana conta ${i} \n`;
    letra += `Mariana conta ${i} \n`;

    for (var j = 1; j <= i; j++) {
      letra += `é ${j} `
    }
    letra += `é \n`;
    letra += `Ana, viva a Mariana, viva a Mariana\n\n`;
  }
  return letra;
}

// -----------
// Exercício 2
let galeria = document.querySelector('.container:nth-of-type(2) h1:last-child');
let divImagem = document.createElement("div");
galeria.appendChild(divImagem);

let form2 = document.forms[1];
let imagens = [];
let contador = 0;

//imagens.setAttribute("src", imagens[contador]);
imagens.push(imagens[contador++]);

form2.addEventListener("submit", event => {
  event.preventDefault();
  const url = form2.elements["imputUrl"].value;
  divImagem.innerHTML = `<img src="${url}" alt="Imagem">`;

  /*
  imagens.forEach(imagem, function () {
    
  });*/
});