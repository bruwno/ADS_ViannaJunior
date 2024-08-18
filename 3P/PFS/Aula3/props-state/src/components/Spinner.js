import React from "react";

const Spinner = ({mensagem}) => {
    return (
        <div className="ui active dimmer">
          <div className="ui text loader">{mensagem}</div>
        </div>
    );
}

// Mensagem passada por padrão.
Spinner.defaultProps = {
    mensagem: "Carregando..."
};

export default Spinner;
