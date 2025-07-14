import json

d = {"cars":

[{"Year": "1997", "Make": "Ford", "Model": "E350", "Price": "3200.00"},

{"Year": "1999", "Make": "Chevy", "Model": "Venture", "Price": "4800.00"},

{"Year": "1996", "Make": "Jeep", "Model": "Grand Cherokee", "Price": "4900.00"}

]}

with open("cars_list.json", "w") as outfile:
    json.dump(d, outfile)

with open("cars_list.json", "r") as cars:
    c = json.load(cars)
    for car in c ["cars"]:
        for key, value in car.items():
            print(f"{key}:", value)