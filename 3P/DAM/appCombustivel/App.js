// App.js
import { StatusBar } from "expo-status-bar";
import { StyleSheet, View } from "react-native";
import Title from "./src/components/base/Header/Title";
import TextField from "./src/components/base/TextField/TextField";
import Result from "./src/components/base/Footer/Result";
import BtnCalculate from "./src/components/base/Buttons/BtnCalculate";
import { useState } from "react";

export default function App() {
  const [gasolinePrice, setGasolinePrice] = useState("");
  const [ethanolPrice, setEthanolPrice] = useState("");
  const [result, setResult] = useState(null);

  const calculate = () => {
    if (!gasolinePrice || !ethanolPrice || isNaN(gasolinePrice) || isNaN(ethanolPrice)) {
      setResult("Preencha os campos!");
      return;
    }

    let res = ethanolPrice / gasolinePrice;

    if (res <= 0.7) {
      setResult("Etanol");
    } else {
      setResult("Gasolina");
    }
  };

  return (
    <View style={styles.container}>
      <Title fontSize="big-text" customFontColor="#003366">
        MelhorCombustível
      </Title>

      <View style={styles.body}>
        <View style={styles.fieldsContainer}>
          <TextField
            keyboard="numeric"
            fieldPlaceHolder="Digite o preço do litro"
            onChangeTextEvt={(text) => setGasolinePrice(parseFloat(text))}
          >
            Preço gasolina (litro)
          </TextField>

          <TextField
            keyboard="numeric"
            fieldPlaceHolder="Digite o preço do litro"
            onChangeTextEvt={(text) => setEthanolPrice(parseFloat(text))}
          >
            Preço etanol (litro)
          </TextField>

          <BtnCalculate onPressEvt={calculate}>Calcular</BtnCalculate>
        </View>

        <Result result={result}>É mais vantajoso abastecer com</Result>
      </View>

      <StatusBar style="auto" />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#F5F5F5",
    alignItems: "center",
    justifyContent: "center",
    marginTop: 30,
  },
  body: {
    flexGrow: 1,
    width: "100%",
    alignItems: "center",
    justifyContent: "flex-start",
  },
  fieldsContainer: {
    flexGrow: 1,
    width: "90%",
    height: 300,
    marginTop: 20,
    borderRadius: 30,
    borderWidth: 7,
    borderColor: "#CCCCCC",
    backgroundColor: "#FFFFFF",
    alignItems: "center",
  },
});
