import Teste from "./Teste";
import { useState, createContext } from "react";

export const AppContext = createContext([0, () => {}]);

function App() {
  const [cliques, setCliques] = useState(0);

  return (
    <div className="App">
      <AppContext.Provider value={[cliques, setCliques]}>
        <h1>Teste de useContext</h1>
        <Teste />
      </AppContext.Provider>
    </div>
  );
}

export default App;
