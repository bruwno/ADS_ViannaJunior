// Title.js
import { StyleSheet, Text } from "react-native";

const Title = ({ children, fontSize, customFontColor }) => {
    let customFontSize = styles.mediumText;
    if (fontSize === "small-text") {
        customFontSize = styles.smallText;
    } else if (fontSize === "big-text") {
        customFontSize = styles.bigText;
    }

    const customFontSettings = {
        color: customFontColor || "#003366",
    };

    return (
        <Text style={[customFontSize, customFontSettings]}>{children}</Text>
    );
};

const styles = StyleSheet.create({
    smallText: {
        fontSize: 15,
        fontWeight: "bold",
        padding: 10,
    },
    mediumText: {
        fontSize: 22,
        fontWeight: "bold",
        padding: 10,
    },
    bigText: {
        fontSize: 35,
        fontWeight: "bold",
        padding: 10,
    },
});

export default Title;