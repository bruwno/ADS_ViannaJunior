import { StyleSheet, Text, TouchableOpacity, View } from "react-native";

export default Resultado = ({route, navigation}) => {
    const {dados} = route.params;
    console.log(dados);

    return (
        <View style={styles.container}>
            <Text style={styles.titulo}>RESULTADO</Text>

            <TouchableOpacity style={styles.btn}>
                <Text style={styles.titulo}>Próximo</Text>
            </TouchableOpacity>
        </View>
    );
};

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: "#FFF",
        alignItems: "flex-start",
        justifyContent: "flex-start",
        paddingTop:15,
    },
    titulo: {
        fontSize: 28,
        padding: 15,
        fontWeight: "bold",
        textAlign:"center",
        width:"100%",
    },
    btn: {
        padding: 15,
        backgroundColor: "#BB0",
        width:"100%",
    },
});