import { useState } from "react";
import { StyleSheet, Text, View } from "react-native";
import { Avatar, Button, Card, Checkbox, TextInput } from "react-native-paper";

export default Simulacao = ({ route, navigation }) => {
  const { dados } = route.params;
  //console.log(dados);
  const [user, setUser] = useState({
    ...dados,
    valorFinanciado: "",
    taxa: "",
    parcelas: "",
    ehServidorPublico: "unchecked",
  });

  const validaServidor = () => {
    let aux = user.ehServidorPublico == "checked" ? "unchecked" : "checked";
    setUser({ ...user, ehServidorPublico: aux });
  };

  return (
    <View style={styles.container}>
      {/* <Text style={styles.titulo}>Olá Sr(a) {dados.nome}</Text> */}

      <Card.Title
        title={"Olá Sr(a) " + user.nome}
        subtitle="Vamos simular o seu financiamento!"
        left={(props) => <Avatar.Icon {...props} icon="account-outline" />}
      />

      <TextInput
        style={styles.campo}
        mode="flat"
        label="Valor financiado"
        keyboardType="decimal-pad"
        value={user.valorFinanciado}
        onChangeText={(t) => setUser({ ...user, valorFinanciado: t })}
      />

      <TextInput
        style={styles.campo}
        mode="flat"
        label="Taxa Juros"
        value={user.taxa}
        onChangeText={(t) => setUser({ ...user, taxa: t })}
      />

      <TextInput
        style={styles.campo}
        mode="flat"
        label="Número de parcelas"
        value={user.parcelas}
        onChangeText={(t) => setUser({ ...user, parcelas: t })}
      />

      <Checkbox.Item
        style={styles.campo}
        label="Servidor Público"
        status="unchecked"
        value={user.ehServidorPublico}
        onPress={validaServidor}
      />

      <View style={styles.body}>
        <Button
          icon="skip-next"
          style={styles.btn}
          size={60}
          mode="contained"
          onPress={() => {
            console.log(user);
            navigation.navigate("res", { dados: user });
          }}
        >
          Próximo
        </Button>
      </View>

      {/* <TouchableOpacity style={styles.btn}>
                <Text style={styles.titulo}>Próximo</Text>
            </TouchableOpacity> */}
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#fff",
    alignItems: "flex-start",
    justifyContent: "flex-start",
    // paddingTop: 5,
  },
  body: {
    backgroundColor: "#bbb",
    width: "100%",
    flex: 1,
    flexGrow: 1,
    // alignItems: 'flex-start',
  },
  titulo: {
    fontSize: 28,
    padding: 15,
    fontWeight: "bold",
    textAlign: "center",
    width: "100%",
  },
  campo: {
    maxHeight: 70,
    padding: 5,
    width: "100%",
  },
  btn: {
    padding: 10,
    width: "100%",
  },
});
