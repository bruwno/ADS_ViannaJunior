import pandas as pd
import yfinance as yf

tkr = yf.Ticker("PETR4.SA")

hist = tkr.history(period="5d")
hist = hist.drop(["Dividends", "Stock Splits"], axis=1)

hist = hist.reset_index() # O índice volta a ser numérico.
hist = hist.set_index("Date") # Definindo o índice como o atributo Date.

print(hist)