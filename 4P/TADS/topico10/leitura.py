path = "texto.txt"

with open(path, "r") as f:
    # content = f.read()
    # print(content)
    # for i, line in enumerate(f):
    #     if line.strip():
    #         print(f"Line {i}:", line)
    lst = [line.strip() for line in f if line.strip()]
    print(lst[1])