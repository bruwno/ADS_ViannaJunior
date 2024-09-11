import { StyleSheet, Text, TouchableOpacity, View } from "react-native";

export default Splash = ({navigation}) => {

    const callDados = () => {
        navigation.navigate('dados');
    }

    return (
        <View style={styles.container}>
            <Text style={styles.titulo}>SPLASH</Text>

            <TouchableOpacity style={styles.btn}
            onPress={callDados}>
                <Text style={styles.titulo}>Próximo</Text>
            </TouchableOpacity>

            <View style={styles.container}>
                <Text style={styles.titulo}></Text> 

            </View>
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