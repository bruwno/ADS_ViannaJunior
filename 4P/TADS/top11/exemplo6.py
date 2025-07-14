import pandas as pd

import pandas as pd
import json

data = [
    {"Empno": 9001, "Salary": 3000},
    {"Empno": 9002, "Salary": 2800},
    {"Empno": 9003, "Salary": 2500}
]

json_data = json.dumps(data)

salary = pd.read_json(json_data)

salary = salary.set_index("Empno")

data = [
    ["9001","Samuelzim","sales"],
    ["9003","Renanzim","sales"],
    ["9003","Raphaelzim","sales"],
    ["9004","Otaviozim","sales"]
]

emps = pd.DataFrame(data, columns=["Empno","Name","Job"])

columns_type = {"Empno":int, "Name":str, "Job":str}
emps = emps.astype(columns_type)

emps = emps.set_index("Empno")

emps_salary = emps.join(salary, how="inner")

data = [
    [2608, 9001, 35],
    [2617, 9001, 35],
    [2620, 9001, 139],
    [2621, 9002, 95],
    [2626, 9002, 218],
]

orders = pd.DataFrame(data, columns=["Pono", "Empno", "Total"])
emps_orders = emps.merge(
    orders, how="inner", left_on="Empno", right_on="Empno"
).set_index("Pono")

# Retorna a média
#print(orders.groupby(["Empno"])["Total"].mean())

# Retorna a soma das vendas dos empregados
print(orders.groupby(["Empno"])["Total"].sum())

total = orders.groupby(["Empno"])["Total"].sum()

emps_total = emps.join(total, how="inner")

print(emps_total)