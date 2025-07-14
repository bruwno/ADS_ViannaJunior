# TÓPICO 19 - Análise de Cesta de Compras (Obtendo insights a partir de dados)
# Suporte, Confiança e Lift (Alavancagem)

# LIFT: 1 = Abaixo de 1 nenhum item influencia o outro; ACIMA DE 1: o valor que passa de 1 é o correspondente ao percentual de influencia de um item sobre o outro

# Importação da biblioteca pandas, que fornece estruturas de dados e ferramentas de análise de dados
import pandas as pd
# Importação da biblioteca numpy, que fornece suporte para arrays e matrizes multidimensionais,
# além de funções matemáticas para operar nesses arrays
import numpy as np
# Importação da biblioteca matplotlib, uma biblioteca de visualização para Python
import matplotlib
# Importação do módulo pyplot da matplotlib, que fornece uma interface similar ao MATLAB para criação de gráficos
import matplotlib.pyplot as plt
# Importação da classe TransactionEncoder do módulo mlxtend.preprocessing, que será usada para
# transformar os dados de transação em um formato adequado para o algoritmo Apriori
from mlxtend.preprocessing import TransactionEncoder
# Importação da função apriori do módulo mlxtend.frequent_patterns, que implementa o algoritmo Apriori
# para identificar conjuntos de itens frequentes em dados de transação
from mlxtend.frequent_patterns import apriori
# Importação da função association_rules do módulo mlxtend.frequent_patterns, que será usada para
# gerar regras de associação a partir dos conjuntos de itens frequentes
from mlxtend.frequent_patterns import association_rules
# Importação da função reduce do módulo functools, que permite aplicar cumulativamente uma função
# a itens de uma sequência, da esquerda para a direita
from functools import reduce

# Definição do conjunto de dados de transações
# Cada lista interna representa uma transação individual (uma cesta de compras)
# Cada string dentro da lista interna representa um item comprado naquela transação
transactions = [
    ["curd", "sour cream"],                   # Transação 1: coalhada e creme azedo
    ["curd", "orange", "sour cream"],         # Transação 2: coalhada, laranja e creme azedo
    ["bread", "cheese", "butter"],            # Transação 3: pão, queijo e manteiga
    ["bread", "butter"],                      # Transação 4: pão e manteiga
    ["bread", "milk"],                        # Transação 5: pão e leite
    ["apple", "orange", "pear"],              # Transação 6: maçã, laranja e pêra
    ["bread", "milk", "eggs"],                # Transação 7: pão, leite e ovos
    ["tea", "lemon"],                         # Transação 8: chá e limão
    ["curd", "sour cream", "apple"],          # Transação 9: coalhada, creme azedo e maçã
    ["eggs", "wheat flour", "milk"],          # Transação 10: ovos, farinha de trigo e leite
    ["pasta", "cheese"],                      # Transação 11: massa e queijo
    ["bread", "cheese"],                      # Transação 12: pão e queijo
    ["pasta", "olive oil", "cheese"],         # Transação 13: massa, azeite de oliva e queijo
    ["curd", "jam"],                          # Transação 14: coalhada e geléia
    ["bread", "cheese", "butter"],            # Transação 15: pão, queijo e manteiga
    ["bread", "sour cream", "butter"],        # Transação 16: pão, creme azedo e manteiga
    ["strawberry", "sour cream"],             # Transação 17: morango e creme azedo
    ["curd", "sour cream"],                   # Transação 18: coalhada e creme azedo
    ["bread", "coffee"],                      # Transação 19: pão e café
    ["onion", "garlic"],                      # Transação 20: cebola e alho
]

# Cria uma instância do TransactionEncoder
# Este objeto será usado para transformar os dados de transação em um formato binário (one-hot encoded)
encoder = TransactionEncoder()

# Transforma os dados de transação em um array binário
# O método fit() analisa as transações e identifica todos os itens únicos
# O método transform() converte cada transação em uma linha do array, onde cada coluna representa
# um item único e cada valor é True (item está presente na transação) ou False (item não está presente)
encoded_array = encoder.fit(transactions).transform(transactions)

# Converte o array codificado em um DataFrame do pandas
# As colunas são nomeadas com base nos itens únicos encontrados pelo encoder
# Cada linha representa uma transação, com True onde o item está presente e False onde não está
df_itemsets = pd.DataFrame(encoded_array, columns=encoder.columns_)

# Aplica o algoritmo Apriori para encontrar conjuntos de itens frequentes
# min_support=0.1: apenas itens que aparecem em pelo menos 10% das transações são considerados frequentes
# use_colnames=True: usa os nomes dos itens nas saídas, em vez de índices numéricos
frequent_itemsets = apriori(df_itemsets, min_support=0.1, use_colnames=True)

# Adiciona uma coluna 'length' ao DataFrame frequent_itemsets
# Esta coluna indica quantos itens estão em cada conjunto de itens frequente
# A função lambda recebe cada itemset (que é um frozenset) e retorna seu tamanho usando len()
frequent_itemsets['length'] = frequent_itemsets['itemsets'].apply(lambda itemset: len(itemset))

# Imprime os conjuntos de itens frequentes que contêm 2 ou mais itens
# Filtra o DataFrame para mostrar apenas linhas onde o valor na coluna 'length' é maior ou igual a 2
print(frequent_itemsets[frequent_itemsets['length'] >= 2])

# Gera regras de associação a partir dos conjuntos de itens frequentes
# metric="confidence": usa a métrica de confiança para avaliar as regras
# min_threshold=0.5: inclui apenas regras com confiança de pelo menos 0.5 (50%)
# As regras indicam: "se um cliente compra o item A, qual é a probabilidade de que também compre o item B?"
rules = association_rules(frequent_itemsets, metric="confidence", min_threshold=0.5)

# Imprime as primeiras 7 colunas do DataFrame de regras
# Essas colunas incluem antecedentes, consequentes, suporte, confiança e lift
print(rules.iloc[:,0:7])

# Cria um novo DataFrame vazio para preparar os dados para visualização
rules_plot = pd.DataFrame()

# Converte os antecedentes (que são frozensets) em strings para facilitar a visualização
# Para cada frozenset, converte-o em uma lista, depois junta os elementos com vírgulas
# Por exemplo, frozenset({'bread', 'butter'}) se torna "bread,butter"
rules_plot["antecedents"] = rules["antecedents"].apply(lambda x: ",".join(list(x)))

# Faz o mesmo para os consequentes, convertendo frozensets em strings separadas por vírgulas
rules_plot["consequents"] = rules["consequents"].apply(lambda x: ",".join(list(x)))

# Copia os valores de lift, arredondando para 2 casas decimais para melhor visualização
rules_plot["lift"] = rules["lift"].apply(lambda x: round(x,2))

# Cria uma tabela pivotada para visualização
# As linhas são os antecedentes, as colunas são os consequentes
# Os valores nas células são os valores de lift para cada par antecedente-consequente
# Células vazias (NaN) indicam que não há regra para esse par específico
pivot = rules_plot.pivot(index="antecedents", columns="consequents", values='lift')

# Imprime a tabela pivotada
print(pivot)

# Extrai os nomes dos antecedentes (rótulos das linhas) como uma lista
# Estes serão usados para rotular o eixo y no mapa de calor
antecedents = list(pivot.index.values)

# Extrai os nomes dos consequentes (rótulos das colunas) como uma lista
# Estes serão usados para rotular o eixo x no mapa de calor
consequents = list(pivot.columns)

# Converte o DataFrame pivotado em um array NumPy
# Esta conversão é necessária para usar com a função imshow() do matplotlib
pivot = pivot.to_numpy()

# Imprime o array NumPy
print(pivot)

# Gerando o mapa de calor de correlação entre items
# Cria uma nova figura e um conjunto de eixos
# fig representa toda a figura, ax representa a área de plotagem
fig, ax = plt.subplots()

# Cria o mapa de calor usando a função imshow()
# pivot: os dados a serem exibidos
# cmap="Reds": usa uma paleta de cores vermelhas, onde cores mais escuras representam valores mais altos
# O resultado é armazenado em 'im', que pode ser usado para adicionar uma barra de cores (não feito neste código)
im = ax.imshow(pivot, cmap="Reds")

# Define as posições das marcações no eixo x
# Cria um array de números inteiros começando em 0 e indo até o número de consequentes
ax.set_xticks(np.arange(len(consequents)))

# Define as posições das marcações no eixo y
# Cria um array de números inteiros começando em 0 e indo até o número de antecedentes
ax.set_yticks(np.arange(len(antecedents)))

# Define os rótulos para as marcações no eixo x usando os nomes dos consequentes
ax.set_xticklabels(consequents)

# Define os rótulos para as marcações no eixo y usando os nomes dos antecedentes
ax.set_yticklabels(antecedents)

# Configura os rótulos do eixo x para serem rotacionados em 45 graus
# rotation=45: rotaciona os rótulos em 45 graus
# ha="right": alinha horizontalmente os rótulos à direita
# rotation_mode="anchor": define o ponto de ancoragem para rotação
plt.setp(ax.get_xticklabels(), rotation=45, ha="right", rotation_mode="anchor")

# Loop através de todas as células do mapa de calor
# i representa o índice da linha (antecedente)
for i in range(len(antecedents)):
    # j representa o índice da coluna (consequente)
    for j in range(len(consequents)):
        # Verifica se o valor na célula não é NaN (Not a Number)
        # Isso evita adicionar texto em células vazias
        if not np.isnan(pivot[i,j]):
            # Adiciona o valor de lift como texto no centro da célula
            # j, i: coordenadas (x, y) da célula
            # pivot[i,j]: o valor a ser mostrado
            # ha="center", va="center": centraliza o texto horizontalmente e verticalmente na célula
            text = ax.text(j, i, pivot[i,j], ha="center", va="center")

# Define o título do mapa de calor
ax.set_title("Lift metric for frequent itemsets")

# Ajusta o layout da figura para garantir que todos os elementos sejam visíveis e bem posicionados
fig.tight_layout()

# Mostra o gráfico em uma janela
plt.show()

# Extraindo as três principais consequencias
# Filtra o DataFrame de regras para obter apenas regras onde o antecedente é exatamente {'butter'}
# Seleciona apenas as colunas 'consequents' e 'confidence' dessas regras
# Ordena as regras por 'confidence' em ordem decrescente (do mais confiável ao menos confiável)
butter_antecedent = rules[rules["antecedents"] == {"butter"}][["consequents","confidence"]].sort_values("confidence", ascending=False)

# Extrai os três primeiros consequentes da lista ordenada
# Para cada consequente (que é um frozenset), converte-o em uma lista
# O resultado é uma lista de listas, onde cada lista interna contém os itens do consequente
butter_consequents = [list(item) for item in butter_antecedent.iloc[0:3,:]["consequents"]]

# Define o item para o qual estamos gerando recomendações
item = "butter"

# Imprime os itens frequentemente comprados junto com "butter"
print(f"Itens frequentemente comprados junto ", item, "são: ", butter_consequents)

# Planejando descontos
# Cria uma nova coluna 'itemsets' no DataFrame de regras
# Para cada regra, combina os antecedentes e consequentes em um único conjunto (frozenset)
# Usa a função reduce() para aplicar a operação de união (union) entre os frozensets
# axis=1 indica que a operação é aplicada horizontalmente (por linha)
rules["itemsets"] = rules[["antecedents","consequents"]].apply(lambda x: reduce(frozenset.union, x), axis=1) # Frozenset = conjunto vazio e imutável - Eliminação de duplicatas

# Remove linhas duplicadas do DataFrame com base na coluna 'itemsets'
# subset=["itemsets"]: especifica que a comparação deve ser feita na coluna 'itemsets'
# keep="first": mantém a primeira ocorrência de cada conjunto de itens duplicado
# inplace=True: modifica o DataFrame original em vez de criar uma cópia
rules.drop_duplicates(subset=["itemsets"], keep="first", inplace=True) #Eliminando duplicatas

# Imprime as colunas 'antecedents', 'consequents' e 'itemsets' do DataFrame após a remoção de duplicatas
print(rules[["antecedents","consequents","itemsets"]]) # Items geralmente comprados juntos - Bom para dividir os descontos, evitando dar descontos em itens comprados juntos

# Definindo os itens que terão e os que não terão descontos
# Cria uma lista vazia para armazenar os itens que receberão desconto
discounted = []

# Cria uma lista vazia para armazenar os itens que não receberão desconto
others = []

# Itera por cada conjunto de itens frequentes
for itemset in rules["itemsets"]:
    # Itera por cada item dentro do conjunto atual
    # enumerate() retorna tanto o índice (i) quanto o valor (item)
    for i, item in enumerate(itemset):
        # Verifica se o item atual ainda não está na lista de itens sem desconto
        if item not in others:
            # Adiciona o item à lista de itens com desconto
            discounted.append(item) # add na lista de descontos
            
            # Converte o frozenset em um set comum (mutável) para poder modificá-lo
            itemset = set(itemset) # tira do conjunto o item que já recebeu desconto
            
            # Remove o item que recebeu desconto do conjunto
            itemset.discard(item)
            
            # Adiciona os itens restantes à lista de itens sem desconto
            others.extend(itemset)
            
            # Sai do loop interno - já encontramos um item para receber desconto neste conjunto
            break
    
    # Se chegamos ao último item do conjunto sem encontrar nenhum item elegível para desconto
    # (todos os itens já estavam na lista 'others')
    if i == len(itemset) - 1:
        # Adiciona o último item à lista de descontos como último recurso
        discounted.append(item)
        
        # Converte o frozenset em um set comum (mutável)
        itemset = set(itemset)
        
        # Remove o item que recebeu desconto do conjunto
        itemset.discard(item)
        
        # Adiciona os itens restantes à lista de itens sem desconto
        others.extend(itemset)

# Imprime a lista de itens que receberão desconto
# Esta lista pode conter duplicatas se o mesmo item foi selecionado para receber desconto em múltiplos conjuntos
print(discounted)