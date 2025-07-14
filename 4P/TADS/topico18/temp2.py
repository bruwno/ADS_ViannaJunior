import pandas as pd
import numpy as np

stocks = pd.DataFrame()

tickers = ["MSFT", "TSLA", "GM", "AAPL", "ORCL", "AMZN"]

for ticker in tickers:
    hist = pd.read_csv(f"./finance/{ticker}.csv", index_col=0, parse_dates=True)
    hist = pd.DataFrame(hist[["Close"]].rename(columns={"Close":ticker}))
    if stocks.empty:
        stocks = hist
    else:
        stocks= stocks.join(hist)

stocks_to_keep = []
for i in stocks.columns:
    if stocks[stocks[i]/stocks[i].shift(1)< .97].empty:
        stocks_to_keep.append(i)

# print(stocks[stocks_to_keep])

for i in stocks.columns:
    twoDaysAvg = stocks[i].shift(2).rolling(2).mean()
    stocks[f"{i}-2DA"] = np.log(stocks[i]/twoDaysAvg)

print(stocks)