import csv

path = "data.csv"

with open(path, "r") as csv_file:
    csv_reader = csv.DictReader(csv_file)

    cars = []
    for row in csv_reader:
        cars.append(dict(row))
    print(cars)

    # for row in cars :
    #     print(list(row.values()))

to_update = ["1999", "Chevy", "Venture"]

new_price = "4500.00"

with open(path, "w") as csvfile:
    fieldnames = cars[0].keys()
    writer = csv.DictWriter(csv_file, fieldnames=fieldnames)
    writer.writeheader()

    for row in cars:
        if set(to_update).issubset(set(row.values())):
            row["Price"] = new_price
        writer.writerow(row)