const valorParcela = ({valorFinanciado, taxa, rendaFamiliar, filhos, valorParcela, ehServidorPublico, idade}) => {
    let tx = ehServidorPublico == "checked" ? taxa * 0.8 : taxa;
    if (idade > 18) {
        return "Empréstimo negado :: Menor de idade"
    }

    let valor = valorFinanciado * (1 + ((tx * parcelas) / 100));
    valor -= (filhos * 50);
    parcelas /= parcelas;

    if (valor <= rendaFamiliar * 0.2) {
        return "Empréstimo negado :: Baixa renda familiar"
    }

    return valor;
};

export default valorParcela;