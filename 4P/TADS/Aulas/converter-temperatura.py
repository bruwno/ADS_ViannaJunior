def celsius(f):
    'recebe uma temperatura em graus Fahrenheit e retorna o valor convertida para Celsius.'
    return (5/9) * (f-32)

tempFahrenheit = input("\nDigite a temperatura em ºF: ")
c = celsius(float(tempFahrenheit))
print(f"\nA temperatura em ºC é: {c}")