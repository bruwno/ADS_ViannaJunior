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
#print(emps)

# JOIN
#emps_salary = emps.join(salary) # Por padrão o DataFrame, utilizando o método join, faz um LEFT JOIN.

# INNER
emps_salary = emps.join(salary, how="inner")

print(emps_salary)