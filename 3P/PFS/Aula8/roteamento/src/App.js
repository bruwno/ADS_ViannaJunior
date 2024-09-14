import React from "react";
import { BrowserRouter, Routes, Route, Router } from "react-router-dom";
import Layout from "./components/Layout";
import Pagina1 from "./components/Pagina1";
import Pagina2 from "./components/Pagina2";
import Pagina3 from "./components/Pagina3";
import Pagina4 from "./components/Pagina4";

const App = () => {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Layout />}>
                    <Route index element={<Pagina1 />} />
                    <Route path="pagina1" element={<Pagina1 />} />
                    <Route path="pagina2" element={<Pagina2 />} />
                    <Route path="pagina3" element={<Pagina3 />} />
                    <Route path="pagina4" element={<Pagina4 />} />
                </Route>
            </Routes>
        </BrowserRouter>
    );
};

export default App;