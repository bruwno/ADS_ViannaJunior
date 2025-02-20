from binary_tree import BinaryTree

def main():
    tree = BinaryTree()

    tree.insert(5)
    tree.insert(3)
    tree.insert(7)
    tree.insert(1)
    tree.insert(9)

    print("Altura da árvore:", tree.height())
    print("Buscar item 7:", item_search(tree, 7))
    print("In Ordem:", tree.in_order())


def item_search(tree, item):
    result = tree.search(item)
    if result:
        return f"Item {item} encontrado."
    else:
        return f"Item {item} não encontrado."


if __name__ == "__main__":
    main()