import React, { useState } from "react";

const Input = () => {
  const [lembrete, setLembrete] = useState("");
  const [lembretes, setLembretes] = useState([]);
  const [qtdLembretes, setQtdLembretes] = useState(0);

  const addLembrete = () => {
    if (lembrete.trim() !== "") {
      setLembretes(lembretes.concat(lembrete));
      setLembrete("");
      setQtdLembretes(lembretes.length+1);
    }
  };

  const removeLembrete = (index) => {
    const novosLembretes = lembretes.filter((lembrete, i) => i !== index);
    setLembretes(novosLembretes);
    setQtdLembretes(lembretes.length-1);
  };

  return (
    <div>
      <div style={{ display: "flex", marginBottom: "10px" }}>
        <label htmlFor="lembrete">Lembre-se de: </label>
        <input
          type="text"
          id="lembrete"
          name="lembrete"
          value={lembrete}
          onChange={(e) => setLembrete(e.target.value)}
        />
        <button
          onClick={addLembrete}
          style={{
            backgroundColor: "blue",
            color: "white",
            width: "22px",
            height: "22px",
            marginLeft: "10px",
          }}
        >
          +
        </button>
      </div>

      <div style={{ display: "inline-block" }}>
        <h5>Quantidade de tarefas na lista: {qtdLembretes}</h5>
      </div>

      <ul>
        {lembretes.map((item, index) => (
          <li key={index} style={{ display: "flex", alignItems: "center" }}>
            {item}
            <button
              onClick={() => removeLembrete(index)}
              style={{
                backgroundColor: "red",
                color: "white",
                marginLeft: "10px",
              }}
            >
              -
            </button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Input;
