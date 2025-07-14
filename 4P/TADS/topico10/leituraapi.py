# 143235db5fa74640b754d35069e83713
import json
import urllib3
import requests

params = {
    "q":"Python",
    "from":"2025-03-25",
    "to":"2025-03-25",
    "sortBy":"popularity",
    "apiKey":"143235db5fa74640b754d35069e83713"
}

req = "https://newsapi.org/v2/everything"

http = urllib3.PoolManager()

# Com urllib3
r1 = http.request("GET", req)
# Com requests
r2 = requests.get("https://newsapi.org/v2/everything", params)

# Com urlib3
articles1 = json.loads(r1.data.decode("utf-8"))
# Com requests
articles2 = json.loads(r2.text)

print(articles1)

for article in articles1["articles"]:
    print(article["title"])
    print(article["publishedAt"])
    print(article["url"])
    print()
