// TextField.js
import { View, Text, StyleSheet, TextInput } from "react-native";

const TextField = ({ children, keyboard, fieldPlaceHolder, onChangeTextEvt }) => {
    return (
        <View style={styles.container}>
            <Text style={styles.text}>{children}</Text>
            <TextInput
                style={styles.field}
                keyboardType={keyboard}
                placeholder={fieldPlaceHolder}
                placeholderTextColor="#666666"
                onChangeText={onChangeTextEvt}
            />
        </View>
    );
};

const styles = StyleSheet.create({
    container: {
        flex: 0,
        width: "100%",
        borderRadius: 20,
        alignItems: "center",
        alignSelf: "flex-start",
        padding: 10,
    },
    field: {
        fontSize: 20,
        fontWeight: "bold",
        color: "#333333",
        width: "90%",
        textAlign: "center",
        minHeight: 45,
        borderColor: "#003366",
        borderRadius: 20,
        borderWidth: 3,
        backgroundColor: "#FFFFFF",
        padding: 5,
        marginBottom: 20,
    },
    text: {
        fontSize: 20,
        fontWeight: "600",
        padding: 3,
        color: "#003366",
    },
});

export default TextField;
