// FUNÇÃO CONSTRUTORA DOS OBJETOS DO TIPO Pessoa:
function Person(first, last, age, gender, interests) { // Classe Pessoa
    this.name = {
        'first': first, // first é um atributo de name.
        'last': last // last também, é um atributo de name.
    };

    this.age = age;
    this.gender = gender;
    this.interests = interests;
}

// Populando um objeto pessoa.
// let pessoa = new Person("William", "Silva", 26, "Masc", ["Java", "C#", "Livros"]);

/* A propriedade prototype é como uma caixa de ferramentas para as classes */

Person.prototype.bio = function() {
    // First define a string, and make it equal to the part of
    // the bio that we know will always be the same.
    let string = this.name.first + ' ' + this.name.last + ' is ' + this.age + ' years old. ';
    // define a variable that will contain the pronoun part of
    // the second sentence
    let pronoun;

    // check what the value of gender is, and set pronoun
    // to an appropriate value in each case
    if(this.gender === 'male' || this.gender === 'Male' || this.gender === 'm' || this.gender === 'M') {
      pronoun = 'He likes ';
    } else if(this.gender === 'female' || this.gender === 'Female' || this.gender === 'f' || this.gender === 'F') {
      pronoun = 'She likes ';
    } else {
      pronoun = 'They like ';
    }

    // add the pronoun string on to the end of the main string
    string += pronoun;

    // use another conditional to structure the last part of the
    // second sentence depending on whether the number of interests
    // is 1, 2, or 3
    if(this.interests.length === 1) {
      string += this.interests[0] + '.';
    } else if(this.interests.length === 2) {
      string += this.interests[0] + ' and ' + this.interests[1] + '.';
    } else {
      // if there are more than 2 interests, we loop through them
      // all, adding each one to the main string followed by a comma,
      // except for the last one, which needs an and & a full stop
      for(let i = 0; i < this.interests.length; i++) {
        if(i === this.interests.length - 1) {
          string += 'and ' + this.interests[i] + '.';
        } else {
          string += this.interests[i] + ', ';
        }
      }
    }

    // finally, with the string built, we alert() it
    alert(string);
  };

  Person.prototype.greeting = function() {
    alert('Hi! I\'m ' + this.name.first + '.');
  };

  Person.prototype.farewell = function() {
    alert(this.name.first + ' has left the building. Bye for now!');
  }

  Person.prototype.bye = function() {
    alert('Goodbye! ' + this.name.first);
  }

  function Teacher(first, last, age, gender,interests, subject) {
    Person.call(this, first, last, age, gender, interests); // O método call (nativo do JS) chama o construtor da classe dentro de outro objeto.
    this.sbuject = subject;
  }

  console.log(Person.constructor);

// Usando o método bye.
// pessoa.bye();

// Populando um objeto pessoa.
let pessoa = new Person("William", "Silva", 26, "Masc", ["Java", "C#", "Livros"]);
console.log(pessoa);

// Sobrescrevendo o prototype.
Teacher.prototype = Object.create(Person.prototype); // Herdando da classe Pessoa. (A criação de um objeto Teacher usa como base a classe Person)

// 
Object.defineProperty(Teacher.prototype, "constructor", {
    value: Teacher,
    enumerable: false,
    whitable: true
});

Teacher.prototype.lesson = function() {
    alert("Start lesson!");
}

// Criando um objeto Teacher utilizando o construtor da classe Pessoa.
let professor = new Teacher("Gildo", "Leonel", 38, "male", ["CSS", "JS", "Jogos"],["JS", "CSS", "PHP", "IA"]);

console.log(professor);

