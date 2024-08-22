import { StatusBar } from "expo-status-bar";
import { useState } from "react";
import { StyleSheet, Text, TouchableOpacity, View } from "react-native";

export default function App() {
  let [cont, setCont] = useState(0);

  const contar = () => {
    if (cont < 1000) {
      setCont(++cont);
    } else {
      resetar();
    }
  };

  const resetar = () => {
    setCont(0);
  };

  const getCores = () => {
    if (cont >= 0 && cont < 10) return "black";
    else if (cont >= 10 && cont < 20) return "darkred";
    else if (cont >= 20 && cont < 30) return "red";
    else if (cont >= 30 && cont < 40) return "orange";
    else if (cont >= 40 && cont < 50) return "gold";
    else if (cont >= 50 && cont < 60) return "yellowgreen";
    else if (cont >= 60 && cont < 70) return "green";
    else if (cont >= 70 && cont < 80) return "turquoise";
    else if (cont >= 80 && cont < 90) return "deepskyblue";
    else if (cont >= 90 && cont < 100) return "blue";
    else if (cont >= 100 && cont < 110) return "indigo";
    else if (cont >= 110 && cont < 120) return "purple";
    else return "black";
  };

  const getBotaoCor = () => {
    if (cont >= 0 && cont < 10) return "#8B8B8B";
    else if (cont >= 10 && cont < 20) return "#A52A2A";
    else if (cont >= 20 && cont < 30) return "#FF4500";
    else if (cont >= 30 && cont < 40) return "#FF8C00";
    else if (cont >= 40 && cont < 50) return "#FFD700";
    else if (cont >= 50 && cont < 60) return "#9ACD32";
    else if (cont >= 60 && cont < 70) return "#32CD32";
    else if (cont >= 70 && cont < 80) return "#40E0D0";
    else if (cont >= 80 && cont < 90) return "#00BFFF";
    else if (cont >= 90 && cont < 100) return "#1E90FF";
    else if (cont >= 100 && cont < 110) return "#4B0082";
    else if (cont >= 110 && cont < 120) return "#800080";
    else return "#8B8B8B";
  };

  return (
    <View style={styles.container}>
      <Text style={styles.title}>Contador</Text>
      <StatusBar style="auto" />

      <View style={styles.body}>
        <View style={styles.visorContainer}>
          <View style={styles.circulo}>
            <Text style={[styles.visor, { color: getCores() }]}>
              {String(cont)}
            </Text>
          </View>
        </View>
      </View>

      <View style={styles.btnContainer}>
        <TouchableOpacity
          style={[styles.btnContar, { backgroundColor: getBotaoCor() }]}
          onPress={contar}
        >
          <Text style={styles.btnContarTexto}>Contar</Text>
        </TouchableOpacity>

        <TouchableOpacity style={styles.btnResetar} onPress={resetar}>
          <Text style={styles.btnResetarTexto}>Resetar</Text>
        </TouchableOpacity>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#F5F5F5", // Um fundo claro e neutro
    alignItems: "center",
    justifyContent: "center",
  },
  body: {
    flexGrow: 1,
    marginTop: 45,
    width: "90%",
    borderRadius: 15,
  },
  title: {
    marginTop: 45,
    fontSize: 30,
  },
  visorContainer: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
    marginBottom: 45,
  },
  circulo: {
    width: 300,
    height: 300,
    borderRadius: 150,
    backgroundColor: "#E0E0E0",
    justifyContent: "center",
    alignItems: "center",
  },
  visor: {
    fontSize: 100,
    fontWeight: "bold",
    textAlign: "center",
  },
  btnContainer: {
    backgroundColor: "#E0E0E0",
    padding: 10,
    width: "90%",
    borderWidth: 2,
    borderColor: "#E0E0E0",
    borderRadius: 15,
    alignContent: "center",
    alignItems: "center",
    marginBottom: 10,
  },
  btnContar: {
    fontSize: 45,
    padding: 10,
    borderRadius: 15,
    marginBottom: 10,
    width: "95%",
    alignItems: "center",
  },
  btnContarTexto: {
    color: "#FFF",
    fontSize: 25,
    fontWeight: "bold",
  },
  btnResetar: {
    backgroundColor: "#4B0082",
    borderRadius: 15,
    marginBottom: 10,
    width: "95%",
    padding: 10,
    alignItems: "center",
  },
  btnResetarTexto: {
    color: "#FFF",
    fontSize: 15,
  },
});
