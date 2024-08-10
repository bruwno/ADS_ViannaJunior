import logo from "./logo.svg";
import "./App.css";
import Evento from "./components/Evento";

function App() {
  return (
    <div className="ui feed">
      {objetos.map((x) => {
        return <Evento nome={x.nome} likes={x.likes} />;
      })}
    </div>
  );
}

const objetos = [
  { nome: "William", likes: 10 },
  { nome: "Bruno", likes: 15 },
  { nome: "Samuelzim", likes: 70 },
  { nome: "Otaviozim", likes: 50 },
  { nome: "Renanzim", likes: 45 },
];

export default App;
