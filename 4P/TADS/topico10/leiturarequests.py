import requests

PARAMS = {'bibkeys':'ISBN:1718500521', 'format':'json'}

response = requests.get('http://openlibrary.org/api/books', params = PARAMS)

print(response)