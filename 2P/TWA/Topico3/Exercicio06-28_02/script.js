var aluno = {
    nome: "Juquinha",
    matricula: 123456,
    nota: 9,
    frequencia: 0.8,
    imprimeNota() {
        console.log(`Nota: ${this.nota}`);
    },
    imprimeFrequencia() {
        console.log(`Frequência: ${this.frequencia}`);
    },
    verificaAprovacao(media, frequencia) {
        if (this.nota >= media && this.frequencia >= frequencia) {
            return true;
        } else {
            return false;
        }
    }

};

aluno.nota = 6;
aluno.imprimeNota();
aluno.imprimeFrequencia();
aluno.aprovado = aluno.verificaAprovacao(7, 0.75);
