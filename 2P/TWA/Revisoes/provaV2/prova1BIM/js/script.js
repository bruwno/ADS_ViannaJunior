const link = document.querySelectorAll('.enunciado a');
const resposta = document.querySelector('.resposta');

link.forEach(numero=>{
    numero.addEventListener('click',()=>{
        let tabuada ='';
        for (let i = 1; i <=10; i++) {
           tabuada += `${numero.innerText} x ${i} = ${numero.innerText*i}<br>`
        }
        resposta.innerHTML = `<h1>Tabuada</h1>${tabuada}`;
    });
});

/*colete do usuário um dia (usando inputs) e adicione a classe “destaque” no “quadrado” desse dia.
 Por exemplo, se o usuário escolher 21 – o quadrado com o dia 21 (domingo) deve ter a classe destaque.*/

const tdDia = document.querySelectorAll('.mes td');
const inputDia = document.querySelector('#dia');
const botao = document.querySelector('form');

botao.addEventListener('submit',(ev)=>{
    ev.preventDefault();
    tdDia.forEach(td => {
        if(td.innerText == inputDia.value){
            td.classList.add('destaque');
        };
    });
});

/*colete do usuário dois dias (usando inputs), a seguir adicione a classe “destaque2” nos dias entre as 
datas selecionadas e nos dias selecionados a classe “destaque3”.*/

const btn2 = document.querySelector(".btn2");
const input01 = document.querySelector('#dia1');
const input02 = document.querySelector('#dia2');

btn2.addEventListener('click', (event)=> {
    event.preventDefault();
    tdDia.forEach(td =>{
        if(td.textContent == parseInt(input01.value) || td.textContent == parseInt(input02.value)){
            td.classList.add('destaque3');
        }else if(td.textContent > parseInt(input01.value) && td.textContent < parseInt(input02.value)){
            td.classList.add('destaque2');
        }
    });
});

/* Ao clicar na imagem do exemplo a mesma deve ser trocada por outra, após 3 trocas deve ser exibida a 
imagem original e o ciclo deve recomeçar. Todas as imagens que devem ser utilizadas estão na pasta da 
prova.
 */

const imagem = document.querySelector('.questao3 img');
const imagens = [
                './imagens/turing.jpg', 
                './imagens/dijkstra.jpg', 
                './imagens/lovelace.jpg'];

let contador = 0;
imagem.addEventListener('click', () =>{
  contador++;
  if (contador == imagens.length) {
    contador = 0;
  };
  imagem.setAttribute('src', imagens[contador]);
});







