import { useState } from "react";
import {
  StyleSheet,
  Text,
  TextInput,
  TouchableOpacity,
  View,
} from "react-native";

export default function App() {
  const [pValor, setPValor] = useState("");
  const [sValor2, setSValor] = useState("");
  const [resultado, setResultado] = useState(0);

  const calcular = () => {
    const val1 = parseFloat(pValor);
    const val2 = parseFloat(sValor2);

    if (!isNaN(val1) && !isNaN(val2)) {
      setResultado(val1 + val2);
    } else {
      setResultado("Valor inválido!");
    }
  };

  const limparCampos = () => {
    setPValor("");
    setSValor("");
    setResultado(0);
  };

  return (
    <View style={styles.container}>
      <Text style={styles.titulo}>Calculadora</Text>

      <View style={styles.body}>
        <Text style={styles.texto}>Primeiro valor</Text>
        <TextInput
          style={styles.campo}
          value={String(pValor)}
          keyboardType="number-pad"
          placeholder="Informe o primeiro valor"
          onChangeText={(text) => setPValor(text)}
        />

        <Text style={styles.texto}>Segundo valor</Text>
        <TextInput
          style={styles.campo}
          value={String(sValor2)}
          keyboardType="number-pad"
          placeholder="Informe o segundo valor"
          onChangeText={(text) => setSValor(text)}
        />
      </View>

      <View style={styles.resultadoContainer}>
        <Text style={styles.resultadoTitulo}>Resultado</Text>
        <Text style={styles.resultadoCampo}>{String(resultado)}</Text>
      </View>

      <View style={styles.btnContainer}>
        <TouchableOpacity onPress={calcular} style={styles.btnCalcular}>
          <Text style={styles.btnCalcularTexto}>Calcular</Text>
        </TouchableOpacity>

        <TouchableOpacity onPress={limparCampos} style={styles.btnLimpar}>
          <Text style={styles.btnLimparTexto}>Limpar</Text>
        </TouchableOpacity>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  body: {
    flexGrow: 1,
    marginTop: 45,
    width: "80%",
    borderRadius: 15,
  },
  container: {
    flex: 1,
    backgroundColor: "#F5F5F5",
    alignItems: "center",
    justifyContent: "center",
  },
  titulo: {
    color: "#212121",
    fontSize: 40,
    fontWeight: "bold",
    padding: 25,
    backgroundColor: "#E0E0E0",
    width: "100%",
    textAlign: "center",
    borderRadius: 15,
    marginTop: 15,
  },
  texto: {
    fontSize: 20,
    color: "#212121",
    paddingBottom: 10,
    paddingTop: 10,
    textAlign: "center",
  },
  campo: {
    backgroundColor: "#E0E0E0",
    borderColor: "#424242",
    borderRadius: 5,
    fontSize: 22,
    padding: 5,
    marginBottom: 10,
    textAlign: "center",
  },
  btnContainer: {
    backgroundColor: "#E0E0E0",
    padding: 10,
    width: "100%",
    borderWidth: 2,
    borderColor: "#E0E0E0",
    borderRadius: 15,
    alignContent: "center",
    alignItems: "center",
  },
  btnCalcular: {
    backgroundColor: "#424242",
    borderRadius: 15,
    marginBottom: 10,
    width: "95%",
    padding: 10,
    alignItems: "center",
  },
  btnCalcularTexto: {
    color: "#F5F5F5",
    fontSize: 32,
  },
  btnLimpar: {
    backgroundColor: "#8B7D7B",
    borderRadius: 15,
    marginBottom: 5,
    width: "95%",
    padding: 5,
    alignItems: "center",
  },
  btnLimparTexto: {
    color: "#212121",
    fontSize: 20,
  },
  resultadoContainer: {
    alignItems: "center",
    marginVertical: 20,
    width: "100%",
  },
  resultadoTitulo: {
    fontSize: 20,
    marginBottom: 5,
  },
  resultadoCampo: {
    backgroundColor: "#E0E0E0",
    fontSize: 40,
    fontWeight: "bold",
    width: "90%",
    textAlign: "center",
    padding: 10,
    borderRadius: 5,
    borderWidth: 1.5,
    borderColor: "#424242",
    margin: 10,
  },
});