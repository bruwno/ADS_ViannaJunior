import logo from "./logo.svg";
import "./App.css";
import Evento from "./components/Evento";
import Spinner from "./components/Spinner";
import { faker } from "@faker-js/faker";
import React from "react";

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = { feeds: [], carregando: true };
  }

  render() {
    if (this.state.carregando) {
        // O que é passado aqui sobrescreve o que está definido como padrão, no defaultProps.
        return <Spinner mensagem="Carregando..."/>
    }

    return (
      <div className="ui feed">
        {this.state.feeds.map((x) => {
          return (
            <Evento
              nome={x.nome}
              likes={x.likes}
              mensagem={x.mensagem}
              fotoPerfil={x.fotoPerfil}
              tempo={x.tempo}
            />
          );
        })}
      </div>
    );
  }

  componentDidMount() {
    if (this.state.carregando) {
      setTimeout(() => {
        this.setState({ feeds: objetos, carregando: false });
      }, 2000);
    }
  }
}

const objetos = [
  {
    nome: faker.person.firstName(),
    likes: faker.number.int({ min: 0, max: 50 }),
    mensagem: faker.lorem.sentence(),
    fotoPerfil: faker.image.avatar(),
    tempo: faker.number.int({ min: 0, max: 50 }),
  },
  {
    nome: faker.person.firstName(),
    likes: faker.number.int({ min: 0, max: 50 }),
    mensagem: faker.lorem.sentence(),
    fotoPerfil: faker.image.avatar(),
    tempo: faker.number.int({ min: 0, max: 50 }),
  },
  {
    nome: faker.person.firstName(),
    likes: faker.number.int({ min: 0, max: 50 }),
    mensagem: faker.lorem.sentence(),
    fotoPerfil: faker.image.avatar(),
    tempo: faker.number.int({ min: 0, max: 50 }),
  },
  {
    nome: faker.person.firstName(),
    likes: faker.number.int({ min: 0, max: 50 }),
    mensagem: faker.lorem.sentence(),
    fotoPerfil: faker.image.avatar(),
    tempo: faker.number.int({ min: 0, max: 50 }),
  },
  {
    nome: faker.person.firstName(),
    likes: faker.number.int({ min: 0, max: 50 }),
    mensagem: faker.lorem.sentence(),
    fotoPerfil: faker.image.avatar(),
    tempo: faker.number.int({ min: 0, max: 50 }),
  },
];

export default App;
