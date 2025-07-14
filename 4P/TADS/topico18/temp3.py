
# Avaliando relação entre preço e valor das transações

import pandas as pd
import numpy as np

df = pd.read_csv("./finance/tesla1mo.csv", index_col=0, parse_dates=True)

df = df[["Close","Volume"]].rename(columns={"Close":"Price"})

# Verificando o aumento do preço em relação ao dia anterior
df["PriceRise"] = np.log(df["Price"]/df["Price"].shift(1))
print(df)

df["VolumeRise"] = np.log(df["Volume"]/df["Volume"].shift(1))

print(df[abs(df["PriceRise"] > 0.05)])
print(df["VolumeRise"].mean().round(4))

#
print(df[abs(df["PriceRise"]) > 0.05]["VolumeRise"].mean().round(4))

df["VolumeSum"] = df["Volume"].shift(1).rolling(2).sum().fillna(0).astype(int)
df["NextVolume"] = df["Volume"].shift(-1).fillna(0).astype(int)
print(df[abs(df["PriceRise"]) > 0.05].replace(0, np.nan).dropna())