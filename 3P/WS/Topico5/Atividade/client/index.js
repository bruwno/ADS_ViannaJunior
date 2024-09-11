const porta = 40100;

document.addEventListener("DOMContentLoaded", () => {
  const adicionarProduto = document.getElementById("adicionarProduto");
  const buscarProduto = document.getElementById("buscarProduto");
  const listarProdutos = document.getElementById("listarProdutos");

  document.getElementById("menuAdicionar").addEventListener("click", () => {
    adicionarProduto.style.display = "block";
    buscarProduto.style.display = "none";
    listarProdutos.style.display = "none";
    insertProduct();
  });

  document.getElementById("menuBuscar").addEventListener("click", () => {
    adicionarProduto.style.display = "none";
    buscarProduto.style.display = "block";
    listarProdutos.style.display = "none";

    getProductById();
  });

  document.getElementById("menuListar").addEventListener("click", () => {
    adicionarProduto.style.display = "none";
    buscarProduto.style.display = "none";
    listarProdutos.style.display = "block";
    getProducts();
  });

  async function getProducts() {
    const produtoList = document.getElementById("produtoList");

    try {
      const response = await fetch(`http://localhost:${porta}/produto`);
      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
      }

      const data = await response.json();

      if (data.length > 0) {
        produtoList.innerHTML = 
        `<ul>
            ${data.map((produto) => `
                <li>
                    <strong>Nome:</strong> ${produto.nomeProduto} <br>
                         <strong>Preço:</strong> ${produto.precoUnitario} <br>
                         <strong>Quantidade:</strong> ${produto.quantidade} <br>
                        <strong>Categoria:</strong> ${produto.categoria} <br>
                        <strong>Fabricante:</strong> ${produto.fabricante.nomeFabricante} <br>
                        <strong>Telefone:</strong> ${produto.fabricante.telefone} <br>
                        <strong>Endereço:</strong> ${produto.fabricante.endereco.logradouro}, ${produto.fabricante.endereco.numero} - ${produto.fabricante.endereco.bairro}, ${produto.fabricante.endereco.cidade} - ${produto.fabricante.endereco.uf} <br>
                    <strong>CEP:</strong> ${produto.fabricante.endereco.cep} <br>
                </li>`)
                .join("")}
        </ul>`;
      } else {
        produtoList.innerHTML = "<p>Nenhum produto encontrado.</p>";
      }
    } catch (error) {
      console.error("Erro ao carregar produtos:", error);
      produtoList.innerHTML = "<p>Erro ao carregar produtos.</p>";
    }
  }
});

async function getAllProducts() {
  const response = await fetch(`http://localhost:${porta}/produto`);
  const data = await response.json();

  console.log(data);
}

async function getProductById(id) {}

async function insertProduct() {
    btnAddProduto = document.getElementById("btnAddProduto");

    btnAddProduto.addEventListener("click", () => {
        const nomeFabricante = document.getElementById("nomeFabricante").value.trim();
        const logradouro = document.getElementById("logradouro").value.trim();
        const numero = document.getElementById("numero").value.trim();
        const bairro = document.getElementById("bairro").value.trim();
        const cidade = document.getElementById("cidade").value.trim();
        const cep = document.getElementById("cep").value.trim();
        const uf = document.getElementById("uf").value.trim();
        const telefone = document.getElementById("telefone").value.trim();
        const nomeProduto = document.getElementById("nomeProduto").value.trim();
        const precoUnitario = document.getElementById("precoUnitario").value.trim();
        const quantidade = document.getElementById("quantidade").value.trim();
        const categoria = document.getElementById("categoria").value.trim();
    
        if (!nomeFabricante || !logradouro || !numero || !bairro || !cidade || !cep || !uf || !telefone || !nomeProduto || !precoUnitario || !quantidade || !categoria) {
            alert("Por favor, preencha todos os campos obrigatórios.");
            return;
        }
    
        const fabricante = {
            nomeFabricante,
            endereco: {
                logradouro,
                numero,
                bairro,
                cidade,
                cep,
                uf
            },
            telefone
        };
    
        const produto = {
            fabricante,
            nomeProduto,
            precoUnitario,
            quantidade,
            categoria
        };
    
        fetch(`http://localhost:${porta}/produto`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(produto)
        })
        .then(response => {
            if (response.status === 201) {
                return response.json();
            } else {
                throw new Error("Erro ao tentar adicionar produto!");
            }
        })
        .then(data => {
            alert("Produto adicionado com sucesso!");
            console.log(data);
        })
        .catch(error => {
            alert("Ocorreu um erro ao tentar adicionar o produto!");
            console.log("Erro: ", error);
        });
    });
}
