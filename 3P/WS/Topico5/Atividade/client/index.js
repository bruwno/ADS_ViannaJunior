const porta = 40100;

document.addEventListener("DOMContentLoaded", () => {
  const adicionarProduto = document.getElementById("adicionarProduto");
  const atualizarProduto = document.getElementById("atualizarProduto");
  const listarProdutos = document.getElementById("listarProdutos");

  document.getElementById("menuAdicionar").addEventListener("click", () => {
    adicionarProduto.style.display = "block";
    atualizarProduto.style.display = "none";
    listarProdutos.style.display = "none";
  });

  document.getElementById("menuAtualizar").addEventListener("click", () => {
    adicionarProduto.style.display = "none";
    atualizarProduto.style.display = "block";
    listarProdutos.style.display = "none";
  });

  document.getElementById("menuListar").addEventListener("click", () => {
    adicionarProduto.style.display = "none";
    atualizarProduto.style.display = "none";
    listarProdutos.style.display = "block";
    getProducts();
  });

  async function getProducts() {
    const produtoList = document.getElementById("produtoList");

    try {
      const response = await fetch(`http://localhost:${porta}/produto`);
      if (!response.ok) {
        throw new Error(`Ocorreu um erro: ${response.status}`);
      }

      const data = await response.json();

      if (data.length > 0) {
        produtoList.innerHTML = `<ul>
            ${data
              .map(
                (produto) =>
                  `<li>
                    <strong>ID: ${produto.id}</strong> <br>
                    <strong>Nome:</strong> ${produto.nomeProduto} <br>
                        <strong>Preço: </strong> ${produto.precoUnitario.toLocaleString(
                          "pt-BR",
                          { style: "currency", currency: "BRL" }
                        )} <br>
                        <strong>Quantidade:</strong> ${produto.quantidade} <br>
                        <strong>Categoria:</strong> ${produto.categoria} <br>
                        <strong>Fabricante:</strong> ${
                          produto.fabricante.nomeFabricante
                        } <br>
                        <strong>Telefone:</strong> ${
                          produto.fabricante.telefone
                        } <br>
                        <strong>Endereço:</strong> ${
                          produto.fabricante.endereco.logradouro
                        }, ${produto.fabricante.endereco.numero} - ${
                    produto.fabricante.endereco.bairro
                  }, ${produto.fabricante.endereco.cidade} - ${
                    produto.fabricante.endereco.uf
                  } <br>
                    <strong>CEP:</strong> ${
                      produto.fabricante.endereco.cep
                    } <br>
                    <br>
                </li>`
              )
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

async function insertProduct() {
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
      alert("Por favor, preencha todos os campos!");
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
        uf,
      },
      telefone,
    };

    const produto = {
      fabricante,
      nomeProduto,
      precoUnitario,
      quantidade,
      categoria,
    };

    try {
      const response = await fetch(`http://localhost:${porta}/produto`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(produto),
      });

      if (response.status === 201) {
        const data = await response.json();
        alert("Produto adicionado com sucesso!");
        console.log(data);
      } else {
        alert("Erro ao tentar adicionar produto!");
      }
    } catch (error) {
      alert("Ocorreu um erro ao tentar adicionar o produto!");
      console.error("Erro: ", error);
    }
}

async function getProductById(id) {
  try {
    const response = await fetch(`http://localhost:${porta}/produto/${id}`, {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
      },
    });

    if (!response.ok) {
      alert(`Erro ao buscar o produto!\nStatus: ${response.status} ${response.statusText}`);
    }

    const produto = await response.json();

    document.getElementById("idProduto").value = produto.id;
    document.getElementById("updateNomeFabricante").value = produto.fabricante.nomeFabricante;
    document.getElementById("updateTelefone").value = produto.fabricante.telefone;
    document.getElementById("updateNomeProduto").value = produto.nomeProduto;
    document.getElementById("updatePrecoUnitario").value = produto.precoUnitario;
    document.getElementById("updateQuantidade").value = produto.quantidade;
    document.getElementById("updateCategoria").value = produto.categoria;
    document.getElementById("updateLogradouro").value = produto.fabricante.endereco.logradouro;
    document.getElementById("updateNumero").value = produto.fabricante.endereco.numero;
    document.getElementById("updateBairro").value = produto.fabricante.endereco.bairro;
    document.getElementById("updateCidade").value = produto.fabricante.endereco.cidade;
    document.getElementById("updateCep").value = produto.fabricante.endereco.cep;
    document.getElementById("updateUf").value = produto.fabricante.endereco.uf;

    console.log("Dados do produto carregados com sucesso", produto);
  } catch (erro) {
    console.error("Erro ao buscar o produto:", erro);
  }
}

async function updateProductInfo(idProduto) {
  const produtoAtualizado = {
    id: idProduto,
    fabricante: {
      nomeFabricante: document.getElementById("nomeFabricante").value.trim(),
      endereco: {
        logradouro: document.getElementById("updateLogradouro").value.trim(),
        numero: document.getElementById("updateNumero").value.trim(),
        bairro: document.getElementById("updateBairro").value.trim(),
        cidade: document.getElementById("updateCidade").value.trim(),
        cep: document.getElementById("updateCep").value.trim(),
        uf: document.getElementById("updateUf").value.trim(),
      },
      telefone: document.getElementById("updateTelefone").value.trim(),
    },
    nomeProduto: document.getElementById("updateNomeProduto").value.trim(),
    precoUnitario: document.getElementById("updatePrecoUnitario").value.trim(),
    quantidade: document.getElementById("updateQuantidade").value.trim(),
    categoria: document.getElementById("updateCategoria").value.trim(),
  };

  try {
    const response = await fetch(
      `http://localhost:${porta}/produto/${idProduto}`,
      {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(produtoAtualizado),
      }
    );

    const data = await response.json();
    alert(
      `Os dados do produto foram atualizados com sucesso! [ID: ${data.id}]`
    );
  } catch (erro) {
    console.error(
      "Ocorreu um erro ao tentar atualizar os dados do produto",
      erro
    );
  }

  console.log(produtoAtualizado);
}

const btnAddProduto = document.getElementById("btnAddProduto");
btnAddProduto.addEventListener("click", () => {
  insertProduct();
});


const btnBuscarProduto = document.getElementById("btnBuscarProduto");
btnBuscarProduto.addEventListener("click", () => {
  let id = document.getElementById("idProduto").value;

  if (id === null || id === undefined || id === "") {
    alert("Digite um ID para realizar a busca!");
    document.getElementById("idProduto").focus();
  } else {
    getProductById(id);
  }
});

const btnAtualizar = document.getElementById("btnAtualizarProduto");
btnAtualizar.addEventListener("click", () => {
  let id = document.getElementById("idProduto").value;

  if (id === null || id === undefined || id === "") {
    alert("Digite um ID para buscar um produto e atualizar os seus dados!");
    document.getElementById("idProduto").focus();
  } else {
    updateProductInfo(id);
  }
});
