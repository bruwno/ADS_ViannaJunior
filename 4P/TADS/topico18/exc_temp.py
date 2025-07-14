import pandas as pd
import numpy as np

df = pd.read_csv("./salesmen.csv", index_col=0, parse_dates=True)

# dfBob = df[df["Salesman"] == "Bob"]

# dfBob["2DayRise"] = np.log(dfBob["Revenue"]/dfBob["Revenue"].shift(2))

# dfBob["2DaysAvg"] = dfBob["Revenue"].shift(1).rolling(2).mean()
# #print(dfBob[["Revenue", "2DayRise", "2DaysAvg"]])

# dfBob["2DaysAvgRise"] = np.log(dfBob["Revenue"]/dfBob["2DaysAvg"])
# print(dfBob["2DaysAvgRise"].sum())

print(set(df["Salesman"]))

revenues = pd.DataFrame()
for salesman in set(df["Salesman"]):
    hist = df[df["Salesman"] == salesman]
    hist = pd.DataFrame(hist[["Revenue"]].rename(columns={"Revenue":salesman}))
    if revenues.empty:
        revenues = hist
    else:
        revenues = revenues.join(hist)
        twoDaysAvg = df[df["Salesman"].shift(2).rolling(2).mean()]
        revenues[f"{df[df["Salesman"]]}-2DA"] = np.log(revenues[df[df["Salesman"]]]/twoDaysAvg)

print(revenues)

# Exibir o nome dos vendedores que tiveram em algum dia um crescimento maior que 10% em relação à média dos dois dias anteriores.
for name in revenues.columns:
    twoDayAvg = revenues[name].shift(1).rolling(2).mean()
    twoDayAvgRise = np.log(revenues[name]/twoDaysAvg)
    if ((twoDayAvgRise > 0.1).any):
        print(name)