import pandas as pd

data = [
    [2608, 9001, 35],
    [2617, 9001, 35],
    [2620, 9001, 139],
    [2621, 9002, 95],
    [2626, 9002, 218],
]

orders = pd.DataFrame(data, columns=["Pono", "Empno", "Total"])

print(orders)