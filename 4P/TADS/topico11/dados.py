import pandas as pd

data = ["Samuelzim","Renanzim","Raphaelzim"]

emp_data = pd.Series(data, index=[9001,9002,9003])

print(emp_data)