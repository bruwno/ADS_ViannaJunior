async function getData() {//Filtrando os dados do Json
    const carsDataResponse = await fetch('https://storage.googleapis.com/tfjs-tutorials/carsData.json');
    const carsData = await carsDataResponse.json();
    const cleaned = carsData.map(car => ({
        mpg: car.Miles_per_Gallon,
        horsepower: car.Horsepower,
    })).filter(car => (car.mpg != null && car.horsepower != null));

    return cleaned;

}

async function run() {

    const data = await getData();
    const values = data.map(d => ({ /*Conjunto de treinamento*/
        x: d.horsepower,
        y: d.mpg
    }));

    tfvis.render.scatterplot(/*Redenrizar  */
        { name: 'Horsepower v MPG' },
        { values },
        {
            xLabel: 'Horsepower',
            yLabel: 'MPG',
            height: 300
        }
    )

    const model = createModel();

    tfvis.show.modelSummary({ name: "Modelo" }, model);

    async function trainModel(model,inputs,labels) {
        model.compile({
            optimizer: tf.train.adam(),
            loss: tf.losses.meanSquaredError,
            metrics: ['mse'],//sumario de todos os erros
        });

        const batchSize = 32;
        const epochs = 50;

        return await model.fit(inputs,labels,{
            batchSize,
            epochs,
            shuffle: true,
            callbacks: tfvis.show.fitCallbacks(
                {name: "Performance do treinamento"},
                ["loss","mse"],
                {height: 200, callbacks: ["onEpochEnd"]}
            ),
        });
    }

    const tensorData = convertToTensor(data);
    const {inputs,labels} = tensorData;
    await trainModel(model,inputs,labels);
    console.log("Treino Completo");

    testModel(model,data,tensorData);
    
}

function createModel() {
    const model = tf.sequential();/*Modelo sequencial*/

    model.add(tf.layers.dense({ inputShape: [1], units: 1, useBias: true }));/*Camada de entrada*/

    model.add(tf.layers.dense({ units: 1, useBias: true })); /*Camada de saída */

    return model;
}

function convertToTensor(data) {

    return tf.tidy(() => {

        //Embaralha os dados
        tf.util.shuffle(data); 

        //Converte dados em tensor
        const inputs = data.map((d) => d.horsepower);
        const labels = data.map((d) => d.mpg);

        const inputTensor = tf.tensor2d(inputs, [inputs.length, 1]);//varias colunas e uma linha - tensor longitudinal
        const labelTensor = tf.tensor2d(labels, [labels.length, 1]);


        //Nomalizar dados
        const inputMax = inputTensor.max();
        const inputMin = inputTensor.min();
        const labelMax = labelTensor.max();
        const labelMin = labelTensor.min();

        const normalizedInputs = inputTensor
        .sub(inputMin)
        .div(inputMax.sub(inputMin));

        const normalizedLabels = labelTensor
        .sub(labelMin)
        .div(labelMax.sub(labelMin));

        return{
            inputs: normalizedInputs,
            labels: normalizedLabels,
            inputMax,
            inputMin,
            labelMax,
            labelMin
        }

    })
}

function testModel(model, inputData, normalizedData) {
    const{inputMax,inputMin,labelMax,labelMin} = normalizedData;
    const[xs,preds] = tf.tidy(() => {
        const xs = tf.linspace(0,1,100);
        const preds = model.predict(xs.reshape([100,1]));

        const unNormXs = xs.mul(inputMax.sub(inputMin)).add(inputMin);
        const unNormPreds = preds.mul(labelMax.sub(labelMin)).add(labelMin);

        return [unNormXs.dataSync(), unNormPreds.dataSync()];
    });

    const predictedPoints = Array.from(xs).map((val,i)=>{//valores previsão
        return {
            x: val, 
            y: preds[i]}
    })

    const originalPoints = inputData.map( d =>({//valores originais
        x: d.horsepower,
        y: d.mpg
    }));

    tfvis.render.scatterplot(
        {name: "Previsões do modelo vs Dados originais"},
        {
            values: [originalPoints, predictedPoints],
            series: ["original", "predicted"]
        },{
            xLabel: "HorsePower",
            yLabel: "MPG",
            height: 300
        }
    )
    
}

document, addEventListener('DOMContentLoaded', run);