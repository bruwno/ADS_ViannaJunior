import pandas as pd
import pandas_datareader as pdr

spx_index = pdr.get_data_stooq("^SPX","2025-01-01", "2025-04-01")

print(spx_index)