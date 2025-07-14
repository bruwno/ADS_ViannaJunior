import urllib3

http = urllib3.PoolManager()

r = http.request("GET", "http://127.0.0.1:5500/texto.txt")

for i, line in enumerate(r.data.decode("utf-8").split("\n")):
    if line.strip():
        print("Line %i: " % i, line.strip())