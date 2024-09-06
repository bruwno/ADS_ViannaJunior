import React, {useContext} from 'react';
import { AppContext } from './App'; 

const Teste = () => {
    const [cliques, setCliques] = useContext(AppContext);

    return (
        <div>
            <h4>Teste</h4>
            <p>{cliques}</p>
            <button onClick={() => setCliques(cliques + 1)}>Ok</button>
        </div>
    );
};

export default Teste;