image = "GabenXP.jpg"

with open (image, "rb") as imgfile:
    content = imgfile.read()
    print(len(content))
