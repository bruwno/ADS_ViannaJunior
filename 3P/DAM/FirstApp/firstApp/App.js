// import { StatusBar } from 'expo-status-bar';
// import { useState } from 'react';
// import { StyleSheet, Text, TextInput, TouchableOpacity, View } from 'react-native';

// export default function App() {
//   // Declaração de variável useState.
//   // Manipula a variável e o valor que será exibido na tela.
//   const [v1, setV1] = useState(0) //  é o valor de inicialização da variável.
//   const [v2, setV2] = useState(5)
  
//   const calcular = () =>{
//     setV1(v1 + 1); // Executa de forma assíncrona.
//     setV2(v2 + 1);
//     console.log(val1, val2);
//   }

//   return (
//     <View style={styles.container}>
//       <Text style={styles.titulo}>Calculadora</Text>

//       <View style={styles.body}>
//         <Text style ={styles.texto}>Valor 1</Text>
//         <TextInput style ={styles.campo} value={val1}/>
//         <Text style ={styles.texto}>Valor 2</Text>
//         <TextInput style ={styles.campo} value={val2}/>
//       </View>

//       <TouchableOpacity onPress={calcular} style ={styles.btn}>
//         Calcular
//       </TouchableOpacity>
//     </View>
//   );
// }

// const styles = StyleSheet.create({
//   btn: {
//     padding: 25,
//     fontSize: 32,
//     backgroundColor: '#2B9EB3',
//     borderRadius: 15,
//     marginBottom: 10,
//     width: '98%',
//     textAlign: 'center'
//   },
//   body: {
//     flexGrow: 1,
//     //backgroundColor: '#ff0',
//   },
//   container: {                                         
//     flex: 1,
//     backgroundColor: '#AA9',
//     alignItems: 'center',
//     justifyContent: 'center',
//   },
//   texto: {
//     fontSize: 20,
//     paddingBottom: 10,
//     paddingTop: 10,
//   },
//   campo: {
//     backgroundColor: '#fff',
//     fontSize: 22,
//     padding: 5,
//   },
//   titulo: {
//     fontSize: 48,
//     fontWeight: 'bold',
//     padding: 25,
//   }
// });

import { StatusBar } from 'expo-status-bar';
import { useState } from 'react';
import { StyleSheet, Text, TextInput, TouchableOpacity, View } from 'react-native';


export default function App() {

  //let v1 = 0;
  //let v2 = 5;
  const [v1, setV1] = useState(0);
  const [v2, setV2] = useState(5);

  const calcular = () =>{
    setV1 (v1 + 1);
    setV2 (v2 + 1);
    //v2 = v2 + 1;
    console.log("OK ", v1, v2);
  }

  return (
    <View style={styles.container}>
      <Text style={styles.titulo}>Calculadora</Text>

      <View style={styles.body}>
        <Text style ={styles.texto}>Valor 1</Text>
        <TextInput style ={styles.campo} value={v1}/>
        <Text style ={styles.texto}>Valor 2</Text>
        <TextInput style ={styles.campo} value={v2}/>
      </View>

      <TouchableOpacity onPress={calcular} style ={styles.btn}>
        Calcular
      </TouchableOpacity>
    </View>
  );
}

const styles = StyleSheet.create({
  btn: {
    padding: 25,
    fontSize: 32,
    backgroundColor: '#0d6007',
    borderRadius: 15,
    marginBottom: 10,
    width: '98%',
    textAlign: 'center'
  },
  body: {
    flexGrow: 1,
    //backgroundColor: '#ff0',
  },
  container: {                                         
    flex: 1,
    backgroundColor: '#AA9',
    alignItems: 'center',
    justifyContent: 'center',
  },
  texto: {
    fontSize: 20,
    paddingBottom: 10,
    paddingTop: 10,
  },
  campo: {
    backgroundColor: '#fff',
    fontSize: 22,
    padding: 5,
  },
  titulo: {
    fontSize: 48,
    fontWeight: 'bold',
    padding: 25,

  }
});
