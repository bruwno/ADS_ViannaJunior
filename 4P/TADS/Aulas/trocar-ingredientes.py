def trocaPU(lista):
    lista[0],lista[-1] = lista[-1], lista[0]

ingredientes = ["farinha","açúcar","manteiga","maçãs"]

trocaPU(ingredientes)

print(ingredientes)