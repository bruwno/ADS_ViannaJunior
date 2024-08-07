import React from "react";
import ReactDOM from "react-dom/client";

const root = ReactDOM.createRoot(
    document.getElementById("root")
);

const nome = () => { return "William" };


const App = () => {
    return Saudacao();
    return <div>Olá {nome() + ' bem-vindo de volta!'}</div>;
};

const data = new Date();
const hora = data.getHours();

const Saudacao = () => {
    if (hora >= 0 && hora < 12 ) {
        return <div>Bom dia!</div>
    } else if (hora >= 12 && hora < 18) {
        return <div>Boa tarde!</div>
    } else {
        return <div>Boa noite</div>
    }

}

root.render(
    <App />
);


