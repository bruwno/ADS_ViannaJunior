import React from "react";
import { Outlet, Link } from "react-router-dom";

const Layout = () => {
  return (
    <React.Fragment>
      <nav>
        <ul>
          <li><Link to="/">Home</Link></li>
          <li><Link to="/pagina1">Página 1</Link></li>
          <li><Link to="/pagina2">Página 2</Link></li>
          <li><Link to="/pagina3">Página 3</Link></li>
          <li><Link TO="/PAGINA4">Página 4</Link></li>
        </ul>
      </nav>
      <Outlet /> {/*Processa o componente que foi clicado.*/}
    </React.Fragment>
  );
};

export default Layout;
