/*
import { StatusBar } from "expo-status-bar";
import { StyleSheet, Text, View, TouchableOpacity } from "react-native";

// Criando uma função.
const click = () => {
  <Text>
    Botão pressionado!
  </Text>
};

export default function App() {
  return (
    <View style={styles.container}>
      <Text>Olá Mundo!</Text>
      <TouchableOpacity onPress={click}>
        <Text>OK</Text>
      </TouchableOpacity>
      <StatusBar style="auto" />
    </View>
  );
}

// O CSS utilizado é puramente para estilização.
const styles = StyleSheet.create({
  container: {
    flex: 1, // O flexbox ocupa a tela inteira usando o valor 1.
    backgroundColor: "#fff",
    alignItems: "center",
    justifyContent: "center",
  },
  texto: {
    fontSize: 18,
  },
});
*/

import React, { useState } from 'react';
import { StyleSheet, Text, View, TouchableOpacity } from 'react-native';

const App = () => {
  const [message, setMessage] = useState('');

  const handlePress = () => {
    setMessage('Botão clicado!');
  };

  return (
    <View style={styles.container}>
      <Text style={styles.message}>{message}</Text>
      <TouchableOpacity style={styles.button} onPress={handlePress}>
        <Text style={styles.buttonText}>Clique aqui</Text>
      </TouchableOpacity>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
  message: {
    fontSize: 24,
    marginBottom: 20,
  },
  button: {
    backgroundColor: '#007AFF',
    paddingVertical: 12,
    paddingHorizontal: 24,
    borderRadius: 4,
  },
  buttonText: {
    color: '#FFFFFF',
    fontSize: 16,
    fontWeight: 'bold',
  },
});

export default App;