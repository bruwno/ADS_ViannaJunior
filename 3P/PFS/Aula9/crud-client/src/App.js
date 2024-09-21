import React, { useEffect, useState } from "react";
import axios from "axios";

const getNovoFeed = () => {
  return {
    id: Number(new Date()) + "",
    usuario: "",
    tempo: "",
    mensagem: "",
    fotoPerfil: "",
    likes: 0,
  };
};

function App() {
  const [feeds, setFeeds] = useState(null);
  const [novoFeed, setNovoFeed] = useState(getNovoFeed());

  const carregarDados = () => {
    axios
      .get("http://localhost:3005/feeds")
      .then((result) => setFeeds(result.data));
  };

  const excluir = (id) => {
    axios.delete(`http://localhost:3005/feeds/${id}`).then(() => {
      carregarDados();
    });
  };

  const inserir = () => {
    axios.post(`http://localhost:3005/feeds`, novoFeed).then(() => {
      setNovoFeed(getNovoFeed());
      carregarDados();
    });
  };

  useEffect(() => {
    carregarDados();
  }, []);

  if (!feeds) {
    return <div>Carregando...</div>;
  }

  return (
    <div>
      <fieldset>
        <legend>Inserir</legend>
        <div>
          <label>Usuário</label>
          <input
            type="text"
            value={novoFeed.usuario}
            onChange={(e) =>
              setNovoFeed({ ...novoFeed, usuario: e.target.value })
            }
          />
        </div>
        <div>
          <label>Tempo</label>
          <input
            type="text"
            value={novoFeed.tempo}
            onChange={(e) =>
              setNovoFeed({ ...novoFeed, tempo: e.target.value })
            }
          />
        </div>
        <button onClick={inserir}>Inserir</button>
      </fieldset>
      <table>
        <thead>
          <tr>
            <th>Usuário</th>
            <th>Tempo</th>
            <th>Ação</th>
          </tr>
        </thead>
        <tbody>
          {feeds.map((x) => {
            return (
              <tr key={x.id}>
                <td>{x.usuario}</td>
                <td>{x.tempo}</td>
                <td>
                  <button onClick={() => excluir(x.id)}>Excluir</button>
                </td>
              </tr>
            );
          })}
        </tbody>
      </table>
    </div>
  );
}

export default App;
