import { useState } from "react"
import { StyleSheet, Text, TouchableOpacity, View } from "react-native"
import { Avatar, Button, TextInput } from "react-native-paper"


export default Dados = ( {navigation} )=>{

    const [user, setUser] = useState({
        nome: '',
        idade: '',
        rendaFamiliar: '',
        filhos: '',
    })

    return (
        <View style={styles.container}>

            <Avatar.Icon size={48} 
            color="#fff"
            style={styles.margem}
            icon="account-supervisor-outline" />

            <View style={styles.body}>
                <TextInput
                    style={styles.campo}
                    mode="flat"
                    label="Nome"
                    value={user.nome}
                    onChangeText={ t => setUser({ ...user, nome: t}) }
                    />
                <TextInput
                    style={styles.campo}
                    mode="flat"
                    label="Idade"
                    keyboardType="number-pad"
                    value={user.idade}
                    onChangeText={ t => setUser({ ...user, idade: t}) }
                    />
                <TextInput
                    style={styles.campo}
                    mode="flat"
                    label="Renda Familiar"
                    keyboardType="decimal-pad"
                    value={user.rendaFamiliar}
                    onChangeText={ t => setUser({ ...user, rendaFamiliar: t}) }
                    />
                <TextInput
                    style={styles.campo}
                    mode="flat"
                    label="Filhos"
                    keyboardType="number-pad"
                    value={user.filhos}
                    onChangeText={ t => setUser({ ...user, filhos: t}) }
                    />
                    
            </View>
            {/* <View style={styles.rodape}> */}
                <Button icon="skip-next"
                style={styles.btn}
                size={60} 
                mode="contained" 
                onPress={() => {
                    console.log(user)
                    navigation.navigate("simul")
                    }}>
                    Próximo
                </Button>

            {/* </View> */}

            {/* <Text style={styles.titulo}>DADOS</Text> */}

            {/* <TouchableOpacity  style={styles.btn}>
                <Text style={styles.titulo}>Próximo</Text>
            </TouchableOpacity> */}

        </View>
    )
}

const styles = StyleSheet.create({
    container:{
        flex:1,
        backgroundColor: '#fff',
        alignItems: 'flex-start',
        justifyContent: 'flex-start',
        // paddingTop: 5,
    },
    campo:{
        maxHeight: 70,
        padding: 5,
        width: '100%',
    },
    rodape:{
        flex:1,
        alignItems: 'center',
        justifyContent: 'center',
    },
    body:{
        backgroundColor: '#bbb',
        width: '100%',
        flex:1,
        flexGrow:1,
        // alignItems: 'flex-start',

    },
    margem:{
        margin: 10,
    },
    titulo:{
        fontSize: 28,
        padding: 15,
        fontWeight: 'bold',
        textAlign: 'center',
        width: '100%',
    },
    btn:{        
        padding: 10,
        // backgroundColor: '#bb0',  
        width: '100%',      
    }
})