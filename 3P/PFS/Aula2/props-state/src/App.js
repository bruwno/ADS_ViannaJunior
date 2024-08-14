import './App.css';
import { faker } from '@faker-js/faker';

import Evento from './components/Evento';

function App() {
  return (
    <div className='ui feed'>
      {
        objetos.map(x => {
          return <Evento nome={x.nome} likes={x.likes} mensagem={x.mensagem} fotoPerfil={x.fotoPerfil} tempo={x.tempo} />
        })
      }
    </div>
  );
}

const objetos = [
  {
    nome: faker.person.firstName(),
    likes: faker.number.int(),
    mensagem: faker.lorem.sentence(),
    fotoPerfil: faker.image.avatar(),
    tempo: faker.number.int()
  },
  {
    nome: faker.person.firstName(),
    likes: faker.number.int(),
    mensagem: faker.lorem.sentence(),
    fotoPerfil: faker.image.avatar(),
    tempo: faker.number.int()
  },
  {
    nome: faker.person.firstName(),
    likes: faker.number.int(),
    mensagem: faker.lorem.sentence(),
    fotoPerfil: faker.image.avatar(),
    tempo: faker.number.int()
  },
  {
    nome: faker.person.firstName(),
    likes: faker.number.int(),
    mensagem: faker.lorem.sentence(),
    fotoPerfil: faker.image.avatar(),
    tempo: faker.number.int()
  },
];

export default App;
