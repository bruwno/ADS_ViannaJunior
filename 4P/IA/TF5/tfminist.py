import os
import tensorflow as tf
from tensorflow import keras
import matplotlib.pyplot as plt
import math

(train_images, train_labels), (test_images, test_labels) = tf.keras.datasets.mnist.load_data()

train_images = train_images[:1000].reshape(-1,28*28) / 255.0
train_labels = train_labels[:1000]

test_images = test_images[:1000].reshape(-1,28*28) / 255.0
test_labels = test_labels[:1000]

def create_model():
    model = tf.keras.Sequential([
        keras.layers.Dense(512,activation='relu',input_shape=(784,)),
        keras.layers.Dropout(0.2),
        keras.layers.Dense(10)
    ])

    model.compile(
        optimizer='adam',
        loss=tf.keras.losses.SparseCategoricalCrossentropy(from_logits=True),
        metrics = [tf.keras.metrics.SparseCategoricalAccuracy()]
    )

    return model

model = create_model()

loss,acc = model.evaluate(test_images,test_labels,verbose=2)
print("Acuracia inicial: {:5.2f}%".format(100*acc))

checkpoint_path = "training_1/cp.weights.h5"
checkpoint_dir = os.path.dirname(checkpoint_path) # Onde o checkpoint será salvo

loss,acc = model.evaluate(test_images,test_labels,verbose=2)
print("Acuracia inicial: {:5.2f}%".format(100*acc))

model.load_weights(checkpoint_path) # Carrega os pesos do modelo
loss,acc = model.evaluate(test_images,test_labels,verbose=2)
print("Acuracia com os pesos do checkpoint: {:5.2f}%".format(100*acc))

print(checkpoint_dir)

# Funcao de callback para salvar o modelo, que será chamado durante o treinamento
# O modelo será salvo a cada 5 epochs
cp_callback = tf.keras.callbacks.ModelCheckpoint(
    filepath=checkpoint_path,
    save_weights_only=True,
    verbose=1
)

model.fit(
    train_images,
    train_labels,
    epochs=10,
    validation_data=(test_images, test_labels),
    callbacks=[cp_callback]
)

#
checkpoint_path = "training_2/cp-{epoch:04d}.weights.h5"
checkpoint_dir = os.path.dirname(checkpoint_path) # Onde o checkpoint será salvo

batch_size = 32

n_batches = len(train_images) / batch_size
n_batches = math.ceil(n_batches)

# Funcao de callback para salvar o modelo, que será chamado durante o treinamento
cp_callback = tf.keras.callbacks.ModelCheckpoint(
    filepath=checkpoint_path,
    save_weights_only=True,
    verbose=1,
    save_freq=5*n_batches # Salva a cada 5 batches
)
model = create_model()

model.fit(
    train_images,
    train_labels,
    epochs=50,
    batch_size=batch_size,
    validation_data=(test_images, test_labels),
    callbacks=[cp_callback],
    verbose=0
)

# Salvando o modelo completo
model.save('mnist_model.h5')