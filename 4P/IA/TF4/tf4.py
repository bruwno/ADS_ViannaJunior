import tensorflow as tf
from tensorflow import keras
import matplotlib.pyplot as plt

import numpy as np

imdb = keras.datasets.imdb

(train_data, train_labels), (test_data, test_labels) = imdb.load_data(num_words=10000)

# print("Training entries: {}, labels: {}".format(len(train_data), len(train_labels)))
# print(train_data[0])

# print(len(train_data[0]), len(train_data[1]))

word_index = imdb.get_word_index()

word_index = {k:(v+3) for k,v in word_index.items()}
word_index["<PAD>"] = 0
word_index["<START>"] = 1
word_index["<UNK>"] = 2
word_index["<UNUSED>"] = 3

reversed_word_index = dict([(value, key) for (key,value) in word_index.items()])

def decode_review(text):
    return ' '.join([reversed_word_index.get(i, '?') for i in text])

print(decode_review(train_data[0]))

train_data = keras.preprocessing.sequence.pad_sequences(train_data, 
                                                        value=word_index["<PAD>"],
                                                        padding='post',
                                                        maxlen=256)

test_data = keras.preprocessing.sequence.pad_sequences(test_data, 
                                                       value=word_index["<PAD>"],
                                                       padding='post',
                                                       maxlen=256)

print(len(train_data[0]),len(train_data[1]))

# CRIANDO O MODELO DE MACHINE LEARNING
vocab_size = 10000

model = keras.Sequential()
model.add(keras.layers.Embedding(vocab_size, 16))
model.add(keras.layers.GlobalAveragePooling1D()) # Faz o gerenciamento de memória calculando a média dos elementos
model.add(keras.layers.Dense(16, activation='relu'))
model.add(keras.layers.Dense(1, activation='sigmoid')) # Mais custosa, mais precisa

model.summary()

#Modelo de probabilidade: cada modelo tem uma loss diferente
model.compile(optimizer='adam', #Mesmo papel do gradiente descente
              loss='binary_crossentropy', #Entropia cruzada binaria
              metrics=['accuracy'])

early_stop = keras.callbacks.EarlyStopping(monitor="val_loss", patience=2)

x_val = train_data[:10000]
partial_x_train = train_data[10000:]

y_val = train_labels[:10000]
partial_y_train = train_labels[10000:]

history = model.fit(partial_x_train,
                    partial_y_train,
                    epochs=40,
                    batch_size=512,
                    validation_data=(x_val,y_val),
                    callbacks = [early_stop],
                    verbose=1)

results = model.evaluate(test_data,test_labels,verbose=2)
#print(results)

history_dic = history.history

acc =history_dic["accuracy"]
val_acc = history_dic["val_accuracy"]
loss = history_dic["loss"]
val_loss = history_dic["val_loss"]

epochs = range(1, len(acc) + 1)

plt.plot(epochs,loss,'bo',label="Training loss")
plt.plot(epochs,val_loss,'b',label="Validation loss")
plt.title("Training and Validation loss")
plt.xlabel("Epochs")
plt.ylabel("Loss")
plt.legend()

plt.show()


