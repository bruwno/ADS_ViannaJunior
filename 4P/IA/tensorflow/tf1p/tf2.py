import matplotlib.pyplot as plt
import numpy as np
import pandas as pd
import seaborn as sns
import tensorflow as tf
from tensorflow import keras
from tensorflow.keras import layers

np.set_printoptions(precision=3, suppress=True)

# Carregar e pré -processar o conjunto de dados
url = 'http://archive.ics.uci.edu/ml/machine-learning-databases/auto-mpg/auto-mpg.data'
column_names = [
    'MPG', 'Cylinders', 'Displacement', 'Horsepower', 'Weight',
    'Acceleration', 'Model Year', 'Origin'
]

# Ler o conjunto de dados
raw_dataset = pd.read_csv(
    url,
    names=column_names,
    na_values='?',
    comment='\t',
    sep=' ',
    skipinitialspace=True
)

# Criar uma cópia e limpar os dados
dataset = raw_dataset.copy()

dataset = dataset.dropna()  # Remover qualquer linha que tiver espaços ausentes

# Converter 'Origin' em codificação categórica e única
dataset['Origin'] = dataset['Origin'].map({1: 'USA', 2: 'Europe', 3: 'Japan'})
dataset = pd.get_dummies(dataset, columns=['Origin'], prefix='', prefix_sep='')

# Exibir as últimas linhas para testar
print("Dataset preview (last 5 rows):")
print(dataset.tail())

# Primeiro dataset de treinamento - 80% das amostras (que vem do dataset original) 
# vão para o treinamento
train_dataset = dataset.sample(frac=0.8, random_state=0)
test_dataset = dataset.drop(train_dataset.index)

# Visualização dos dados (seaborn - plota elementos estatísticos)
sns.pairplot(
    train_dataset[['MPG', 'Cylinders', 'Displacement', 'Weight']],
    diag_kind='kde' # 'hist' pra imprmir o histograma
)
plt.show() # Usar até esse ponto para fazer a atividade da semana.

print("\nTraining set statistics:")
print(train_dataset.describe().transpose())

train_features = train_dataset.copy()
test_features = test_dataset.copy()

train_labels = train_features.pop('MPG')
test_labels = test_features.pop('MPG')
                                
# train_dataset.describe().transpose()[['mean', 'std']]

# normalizer = tf.keras.layers.Normalization(axis=-1)

# normalizer.adapt(np.array(train_features.drop(columns=['Europe', 'Japan', 'USA'])))

# print("\nNormalization mean values:")
# print(normalizer.mean.numpy())

# first_example = np.array(train_features.drop(columns=['Europe', 'Japan', 'USA'])[:1])

# print("\nFirst example (before normalization):")
# with np.printoptions(precision=2, suppress=True):
#     print(first_example)

# print("\nFirst example (after normalization):")
# with np.printoptions(precision=2, suppress=True):
#     print(normalizer(first_example).numpy())

