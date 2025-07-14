# As séries regulares têm um padrão (regularidade)

import pandas as pd
import numpy as np

df = pd.read_csv("./finance/tesla.csv")

df.set_index("Date", inplace=True)
#print(pd.concat([df["Close"], df["Close"].shift(2)],axis=1,keys=["Close","2DaysShift"])) # deslocamento de 2 dias atrás.
#print((df["Close"]-df["Close"].shift(2))/df["Close"].shift(2)) # Calculando a porcentagem de crescimento.

# Logaritmo
df["2DayRise"] = np.log(df["Close"]/df["Close"].shift(2))
#print(df)

# Cálculos de janela rolante
df["2DaysAvg"] = df["Close"].shift(1).rolling(2).mean() # Volta um dia com o shift e pega uma janela de dois dias para trás, tirando a média.
df["2DaysAvgRise"] = np.log(df["Close"]/df["2DaysAvg"])
print(df[["Close", "2DayRise", "2DaysAvg","2DaysAvgRise"]])