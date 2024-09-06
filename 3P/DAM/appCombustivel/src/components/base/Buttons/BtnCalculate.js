// BtnCalculate.js
import { View, StyleSheet, TouchableOpacity, Text } from "react-native";

const BtnCalculate = ({ children, caption, onPressEvt }) => {
  return (
    <View style={styles.container}>
      <Text style={styles.txtTitle}>{caption}</Text>
      <TouchableOpacity style={styles.btnCalculate} onPress={onPressEvt}>
        <Text style={styles.btnCalculateText}>{children}</Text>
      </TouchableOpacity>
    </View>
  );
};

const styles = StyleSheet.create({
    container: {
        flex: 1,
        position: "relative",
        width: "100%",
        alignItems: "center",
        justifyContent: "center",
        backgroundColor: "#F2F2F2",
        borderRadius: 25,
        padding: 15,
      },
      txtTitle: {
        fontSize: 17,
        textAlign: "center",
        padding: 0,
        color: "#003366",
      },
      btnCalculate: {
        backgroundColor: "#0066CC",
        width: "95%",
        borderColor: "#003366",
        borderWidth: 4,
        borderRadius: 20,
        position: "absolute",
        bottom: 0,
        marginBottom: 20,
      },
      btnCalculateText: {
        fontSize: 32,
        color: "#FFFFFF",
        textAlign: "center",
        fontWeight: "bold",
      },
});

export default BtnCalculate;
