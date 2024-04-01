// this aponta para o próprio objeto.
// Usando a palavra this temos acesso ao this.

let person = {
    name: "William",
    surname: "Silva",
    age: 26,
    fullName: function () {
        return `${this.name} ${this.surname}`;
    }
}

console.log(person.fullName());

let person2 = {
    name: "Bruno",
    surname: "Silva",
    age: 26,
    fullName: () => {
        return `${name} ${surname}`; // Não serve para retonar elementos do objeto!
    }
}

console.log(person2.fullName()); // Erro.