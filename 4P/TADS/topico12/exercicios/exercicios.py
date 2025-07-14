import pandas as pd

nba  = pd.read_csv("./data/nba.csv").dropna(how="any")

nba["Salary"] = nba["Salary"].fillna(0) # Preenche colunas vazias com valores de placeholder.
nba["College"] = nba["College"].fillna("None")

nba["Salary"] = nba["Salary"].astype(int) # Forçando a conversão do tipo da coluna.
nba["Number"] = nba["Number"].astype(int)
nba["Age"] = nba["Age"].astype(int)
nba["Position"] = nba["Position"].astype("category")
nba["Team"] = nba["Team"].astype("category")

print(nba["Team"].nunique())

# Ordenação
print(nba.sort_values("Salary",ascending=True))
nba.reset_index()
print(nba)
print(nba.sort_index(ascending=False))