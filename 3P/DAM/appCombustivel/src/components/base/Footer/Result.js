// Result.js
import { View, StyleSheet, Text } from "react-native";

const Result = ({children, result}) => {
  return (
    <View style={styles.container}>
        <Text style={styles.txtCaption}>{children}</Text>
        <Text style={styles.txtResult}>{result}</Text>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    display: "flex",
    width: "90%",
    height: 120,
    borderWidth: 5,
    borderColor: "#CCCCCC",
    borderRadius: 22,
    alignItems: "center",
    padding: 10,
    marginTop: 10,
    marginBottom: 10,
    backgroundColor: "#FFFFFF",
  },
  txtCaption: {
    fontSize: 20,
    color: "#003366",
  },
  txtResult: {
    fontSize: 35,
    fontWeight: "bold",
    padding: 10,
    color: "#003366",
  },
});

export default Result;