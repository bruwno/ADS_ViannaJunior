import { NavigationContainer } from "@react-navigation/native";
import { createStackNavigator } from "@react-navigation/stack";
import Splash from "../../View/Splash";
import Dados from "../../View/Dados";
import Simulacao from "../../View/Simulacao";
import Resultado from "../../View/Resultado";

const Stack = createStackNavigator();

export default MenuNavigator = () => {
    return(
        <NavigationContainer>
            <Stack.Navigator initialRouteName="splash">

                <Stack.Screen name="slash" component={Splash}
                options={{headerShown:false}}/> 
                <Stack.Screen name="dados" component={Dados}
                options={{headerTitle:""}} /> 
                <Stack.Screen name="simul" component={Simulacao} options={{headerTitle:""}} />
                <Stack.Screen name="res" component={Resultado}/>

            </Stack.Navigator>
        </NavigationContainer>
    );
};