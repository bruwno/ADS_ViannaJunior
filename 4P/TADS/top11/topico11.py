import pandas as pd

data = ["Samuelzim","Renanzim","Rapahelzim"]

emps_name = pd.Series(data, index=[9001,9002,9003])
emps_name.name = "name"

# print(emps_name)
# print(emps_name.iloc[0]) # índice
# print(emps_name.loc[9001:9002]) # fatia

data2 = ["samuel.zim", "renan.zim", "raphael.zim"]
emps_emails = pd.Series(data2, index=[9001,9002,9003], name="emails")

data3 = ["99988-0011","99977-0022","99966-033"]
emps_phones = pd.Series(data3, index=[9001,9002,9003], name="phones")

df = pd.concat([emps_name, emps_emails, emps_phones], axis=1) # DataFrame

print(df)