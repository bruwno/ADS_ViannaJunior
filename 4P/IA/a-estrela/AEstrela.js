import Rastreador from "./Rastreador.js";
import Grafo from "./Grafo.js";

class AEstrela {
    encontrarCaminho(grafo, origem, destino) {
        if (typeof origem === 'string') {
            origem = grafo.encontrarVertice(origem);
        }
        if (typeof destino === 'string') {
            destino = grafo.encontrarVertice(destino);
        }

        if (!origem || !destino) {
            throw new Error("Origem ou destino não encontrados no grafo.");
        }

        this.validarHeuristicas(grafo);

        const abertos = [];
        const fechados = [];

        const rastreadorInicial = new Rastreador(origem);
        abertos.push(rastreadorInicial);

        console.log("Iniciando busca A* de", origem.valor, "para", destino.valor);

        let iteracao = 0;
        while (abertos.length > 0) {
            iteracao++;
            console.log(`\nIteração ${iteracao}:`);

            abertos.sort((a, b) => a.funcaoAvaliacao() - b.funcaoAvaliacao());

            console.log("Lista de abertos:");
            abertos.forEach(r => {
                console.log(`  ${r.vertice.valor} - g: ${r.custoAtual}, h: ${r.vertice.heuristica}, f: ${r.funcaoAvaliacao()}`);
            });

            const rastreadorAtual = abertos.shift();
            console.log(`\nExpandindo: ${rastreadorAtual.vertice.valor} (f = ${rastreadorAtual.funcaoAvaliacao()})`);

            if (rastreadorAtual.vertice === destino) {
                console.log("\nDestino alcançado!");
                return this.reconstruirCaminho(rastreadorAtual);
            }

            fechados.push(rastreadorAtual);

            const vizinhos = rastreadorAtual.vertice.obterVizinhos();

            console.log("Vizinhos:");

            for (const { vertice: vizinho, aresta } of vizinhos) {
                if (fechados.some(r => r.vertice === vizinho)) {
                    console.log(`  ${vizinho.valor} - já explorado (fechado)`);
                    continue;
                }

                const novoCusto = rastreadorAtual.custoAtual + aresta.custo;

                const rastreadorExistente = abertos.find(r => r.vertice === vizinho);
                if (!rastreadorExistente) {
                    const novoRastreador = new Rastreador(vizinho, rastreadorAtual, aresta.custo);
                    abertos.push(novoRastreador);
                    console.log(`  ${vizinho.valor} - novo (g = ${novoCusto}, h = ${vizinho.heuristica}, f = ${novoCusto + vizinho.heuristica})`);
                } else if (novoCusto < rastreadorExistente.custoAtual) {
                    console.log(`  ${vizinho.valor} - atualizado (g: ${rastreadorExistente.custoAtual} -> ${novoCusto})`);
                    rastreadorExistente.anterior = rastreadorAtual;
                    rastreadorExistente.custoAtual = novoCusto;
                } else {
                    console.log(`  ${vizinho.valor} - já na lista aberta com custo menor ou igual`);
                }
            }
        }

        console.log("\nNão foi possível encontrar um caminho.");
        return null;
    }

    validarHeuristicas(grafo) {
        console.log("-- Validação das heurísticas ---");
        let todasValidas = true;

        for (const vertice of grafo.vertices) {
            if (vertice.heuristica < 0) {
                console.error(`Erro: O vértice ${vertice.valor} possui heurística negativa (${vertice.heuristica})`);
                todasValidas = false;
            }

            for (const { vertice: vizinho, aresta } of vertice.obterVizinhos()) {
                if (vertice.heuristica > vizinho.heuristica + aresta.custo) {
                    console.log(`[!] A heurística pode não ser consistente entre ${vertice.valor} (${vertice.heuristica}) e ${vizinho.valor} (${vizinho.heuristica}). Diferença: ${vertice.heuristica - vizinho.heuristica}, Custo aresta: ${aresta.custo}`);
                }
            }
        }

        if (todasValidas) {
            console.log("As heurísticas são válidas.");
        } else {
            console.log("[!] Nem todas as heurísticas são válidas e/ou consistentes. A busca pode não encontrar o caminho mais curto.");
        }

        console.log(" -- Validação finalizada --\n");
    }

    reconstruirCaminho(rastreadorFinal) {
        const caminho = [];
        const arestas = [];
        let atual = rastreadorFinal;
        let numeroDeSaltos = 0;

        while (atual) {
            caminho.unshift(atual.vertice.valor);

            if (atual.anterior) {
                numeroDeSaltos++;
                const aresta = atual.vertice.arestas.find(a =>
                    a.vertices.includes(atual.anterior.vertice)
                );

                arestas.unshift({
                    de: atual.anterior.vertice.valor,
                    para: atual.vertice.valor,
                    custo: aresta.custo
                });
            }
            atual = atual.anterior;
        }

        return {
            caminho: caminho,
            arestas: arestas,
            custo: rastreadorFinal.custoAtual,
            saltos: numeroDeSaltos
        };
    }
}

function resolverCaminho() {
    const grafo = new Grafo();

    // VÉRTICES (com heurísticas).
    // 14 ITERAÇÕES (MELHOR CAMINHO) -> h(n)=saltos restantes x 19 (menor custo de aresta)
    // OBS.: Executa sem avisos.
    // const juizDeFora = grafo.addVertice("Juiz de Fora", 76);
    // const coronelPacheco = grafo.addVertice("Coronel Pacheco", 95);
    // const rioPomba = grafo.addVertice("Rio Pomba", 76);
    // const santaBarbaraDoTugurio = grafo.addVertice("Santa Bárbara do Tugúrio", 57);
    // const barbacena = grafo.addVertice("Barbacena", 38);
    // const saoJoaoDelRei = grafo.addVertice("São João del Rei", 19);
    // const carrancas = grafo.addVertice("Carrancas", 0);
    // const santosDumont = grafo.addVertice("Santos Dumont", 57);
    // const ibertioga = grafo.addVertice("Ibertioga", 57);
    // const madreDeDeusEminas = grafo.addVertice("Madre de Deus de Minas", 38);
    // const saoVicenteDeMinas = grafo.addVertice("São Vicente de Minas", 19);
    // const limaDuarte = grafo.addVertice("Lima Duarte", 76);
    // const bomJardimDeMinas = grafo.addVertice("Bom Jardim de Minas", 57);
    // const andrelandia = grafo.addVertice("Andrelândia", 38);

    // 6 ITERAÇÕES (MELHOR CAMINHO) -> h(n)=somatório do - menor (diferentes caminhos podem ser tomados em alguns momentos) - custo das arestas restantes
    // OBS.: Executa com 1 aviso de inconsistência de heurísticas
    const juizDeFora = grafo.addVertice("Juiz de Fora", 249);
    const coronelPacheco = grafo.addVertice("Coronel Pacheco", 299);
    const rioPomba = grafo.addVertice("Rio Pomba", 256);
    const santaBarbaraDoTugurio = grafo.addVertice("Santa Bárbara do Tugúrio", 203);
    const barbacena = grafo.addVertice("Barbacena", 161);
    const saoJoaoDelRei = grafo.addVertice("São João del Rei", 83);
    const carrancas = grafo.addVertice("Carrancas", 0);
    const santosDumont = grafo.addVertice("Santos Dumont", 209);
    const ibertioga = grafo.addVertice("Ibertioga", 154);
    const madreDeDeusEminas = grafo.addVertice("Madre de Deus de Minas", 115);
    const saoVicenteDeMinas = grafo.addVertice("São Vicente de Minas", 86);
    const limaDuarte = grafo.addVertice("Lima Duarte", 191);
    const bomJardimDeMinas = grafo.addVertice("Bom Jardim de Minas", 147);
    const andrelandia = grafo.addVertice("Andrelândia", 105);

    // ARESTAS (com custos).
    // Caminho 1
    grafo.addAresta("Juiz de Fora -> Coronel Pacheco", juizDeFora, coronelPacheco, 54);
    grafo.addAresta("Coronel Pacheco -> Rio Pomba", coronelPacheco, rioPomba, 43);
    grafo.addAresta("Rio Pomba -> Santa Bárbara do Tugúrio", rioPomba, santaBarbaraDoTugurio, 53);
    grafo.addAresta("Santa Bárbara do Tugúrio -> Barbacena", santaBarbaraDoTugurio, barbacena, 42);
    grafo.addAresta("Barbacena -> São João del Rei", barbacena, saoJoaoDelRei, 78);
    grafo.addAresta("São João del Rei -> Carrancas", saoJoaoDelRei, carrancas, 83);

    // Caminho 2
    grafo.addAresta("Juiz de Fora -> Santos Dumont", juizDeFora, santosDumont, 53);
    grafo.addAresta("Santos Dumont -> Barbacena", santosDumont, barbacena, 48);
    grafo.addAresta("Barbacena -> Ibertioga", barbacena, ibertioga, 45);
    grafo.addAresta("Ibertioga -> Madre de Deus de Minas", ibertioga, madreDeDeusEminas, 68);
    grafo.addAresta("Madre de Deus de Minas -> São Vicente de Minas", madreDeDeusEminas, saoVicenteDeMinas, 29);

    // Caminho 3
    grafo.addAresta("Juiz de Fora -> Lima Duarte", juizDeFora, limaDuarte, 58);
    grafo.addAresta("Lima Duarte -> Bom Jardim de Minas", limaDuarte, bomJardimDeMinas, 44);
    grafo.addAresta("Bom Jardim de Minas -> Andrelândia", bomJardimDeMinas, andrelandia, 42);
    grafo.addAresta("Andrelândia -> São Vicente de Minas", andrelandia, saoVicenteDeMinas, 19);
    grafo.addAresta("São Vicente de Minas -> Carrancas", saoVicenteDeMinas, carrancas, 86);

    const aEstrela = new AEstrela();
    const resultado = aEstrela.encontrarCaminho(grafo, juizDeFora, carrancas);

    if (resultado) {
        console.log("\n -- MELHOR CAMINHO --");
        console.log(resultado.caminho.join(" -> "));

        console.log("\nDETALHES DAS ETAPAS:");
        resultado.arestas.forEach((aresta, i) => {
            console.log(`  ${i + 1}. ${aresta.de} -> ${aresta.para}: ${aresta.custo} minutos`);
        });

        console.log("\nTOTAL DE SALTOS:", resultado.saltos);
        console.log("TEMPO TOTAL:", resultado.custo, "minutos (" + converterMinutosParaHoras(resultado.custo) + " horas)");
    }

    return resultado;
}

function converterMinutosParaHoras(minutos) {
    return minutos / 60;
}

resolverCaminho();