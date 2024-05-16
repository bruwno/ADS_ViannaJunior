/*-> Usar a pokeapi para mostrar o primeiro pokémon da pokédex
  -> Exibir o número, nome, sprite e uma lista com os tipos do pokémon
  -> Exibir um botão de próximo para avançar um número 
  -> Exibir um botão de anterior, caso NUM > 00, para recuar uma unidade.
 */

  const numField = document.getElementById('num');
  const nameField = document.getElementById('name');
  const typesField = document.getElementById('types');
  const spriteField = document.getElementById('sprite');
  const btnPrev = document.getElementById('btnPrev');
  const btnNext = document.getElementById('btnNext');
  
  let currentNum = 1;
  btnPrev.style.display = "none";
  
  async function getPokeData(id) {
      const response = await fetch(`https://pokeapi.co/api/v2/pokemon/${id}`);
      if (response.status != 200){
          return null;
      }
      const data = await response.json();
  
      return {
          name : data.name,
          num : data.order,
          sprite : data.sprites.front_default,
          types : data.types
      }
  
  }
  
  async function updateData() {
      const pokeData = await getPokeData(currentNum);
      numField.innerText = pokeData.num;
      nameField.innerText = pokeData.name;
      spriteField.setAttribute('src',pokeData.sprite);
      let typesHtml = '';
      pokeData.types.forEach(type => {
          typesHtml += `<li>${type.type.name}</li>`;
      });
      typesField.innerHTML = typesHtml;
  }
  
  updateData();
  
  btnNext.addEventListener('click', ()=>{
      currentNum++;
      updateData();
      if (currentNum > 0){
          btnPrev.style.display = "inline";
      }
  });
  
  btnPrev.addEventListener('click', ()=>{
      currentNum--;
      updateData();
      if (currentNum <= 1){
          btnPrev.style.display = "none";
      }
  });