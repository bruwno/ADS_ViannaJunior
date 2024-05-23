import _ from 'lodash';

let array1 = ['Banana','Morango','Maçã'];
let array2 = ['Banana','Morango','Uva'];
let diference = _.difference(array1, array2);
console.log(diference);

const const1 = 17;
let var1 = "Teste";

console.log(var1);

function soma(a,b) {
    let resultado = a + b;
    return resultado;
}

function sub(a,b) {
    let resultado = a - b;
    return resultado;
}

console.log(soma(2,3));
console.log(sub(2,3));

let resultMenos = sub(10,7);
console.log(resultMenos);