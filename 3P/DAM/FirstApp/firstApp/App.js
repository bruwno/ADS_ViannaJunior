import { useState } from "react";
import {
  StyleSheet,
  Text,
  TextInput,
  TouchableOpacity,
  View,
} from "react-native";

export default function App() {
  const [pValor, setPValor] = useState(0);
  const [sValor2, setSValor] = useState(0);
  const [resultado, setResultado] = useState(0);

  const calcular = () => {
    const val1 = parseFloat(pValor);
    const val2 = parseFloat(sValor2);

    if (!isNaN(val1) && !isNaN(val2)) {
      setResultado(val1 + val2);
    } else {
      setResultado("Entrada inválida");
    }
    console.log("OK ", pValor, sValor2);
  };

  const limparCampos = () => {
    if (pValor !== "" || sValor2 !== "") {
      setPValor(0);
      setSValor(0);
      setResultado(0);
    }
  };

  return (
    <View style={styles.container}>
      <View style={styles.titulo}>
        <Text style={styles.titulo}>Calculadora</Text>
      </View>

      <View style={styles.body}>
        <Text style={styles.texto}>Primeiro valor</Text>
        <TextInput
          style={styles.campo}
          value={String(pValor)}
          onChangeText={(text) => setPValor(text)}
        />

        <Text style={styles.texto}>Segundo valor</Text>
        <TextInput
          style={styles.campo}
          value={String(sValor2)}
          onChangeText={(text) => setSValor(text)}
        />
      </View>

      <View style={styles.resultadoContainer}>
        <Text style={styles.resultadoTitulo}>Resultado</Text>
        <TextInput
          style={styles.resultadoCampo}
          value={String(resultado)}
          editable={false}
        />
      </View>

      <View style={styles.btnContainer}>
        <TouchableOpacity onPress={calcular} style={styles.btnCalcular}>
          <Text style={styles.btnCalcular}>Calcular</Text>
        </TouchableOpacity>

        <TouchableOpacity onPress={limparCampos} style={styles.btnLimpar}>
          <Text style={styles.btnLimpar}>Limpar</Text>
        </TouchableOpacity>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  body: {
    flexGrow: 1,
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
    color: "#F5F5F5",
    padding: 5,
    fontSize: 32,
    backgroundColor: "#424242",
    borderRadius: 15,
    marginBottom: 10,
    width: "95%",
    textAlign: "center",
  },
  btnLimpar: {
    color: "#212121",
    padding: 2,
    fontSize: 20,
    backgroundColor: "#8B7D7B",
    borderRadius: 15,
    marginBottom: 5,
    width: "95%",
    textAlign: "center",
  },
  resultadoContainer: {
    alignItems: "center",
    marginVertical: 20,
  },
  resultadoTitulo: {
    fontSize: 20,
    marginBottom: 10,
  },
  resultadoCampo: {
    backgroundColor: "#E0E0E0",
    fontSize: 40,
    fontWeight: "bold",
    width: "90%",
    height: 70,
    textAlign: "center",
    padding: 10,
    borderRadius: 5,
    borderWidth: 1.5,
    borderColor: "#424242",
    margin: 10,
  },
});
