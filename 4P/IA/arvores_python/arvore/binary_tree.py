from node import Node

class BinaryTree:
    def __init__(self):
        self.root = None
    

    def insert(self, data):
        if not self.root:
            self.root = Node(data)
        else:
            self._recursive_insert(self.root, data)
    

    def _recursive_insert(self, actual_node, data):
        if data < actual_node.data:
            if actual_node.left is None:
                actual_node.left = Node(data)
            else:
                self._recursive_insert(actual_node.left, data)
        else:
            if actual_node.right is None:
                actual_node.right = Node(data)
            else:
                self._recursive_insert(actual_node.right, data)
    

    def search(self, data):
        return self._recursive_search(self.root, data)
    

    def _recursive_search(self, actual_node, data):
        if actual_node is None:
            return False
        
        if data == actual_node.data:
            return True
        
        if data < actual_node.data:
            return self._recursive_search(actual_node.left, data)
        return self._recursive_search(actual_node.right, data)
    

    def in_order(self):
        result = []
        self._recursive_in_order(self.root, result)
        return result
    

    def _recursive_in_order(self, actual_node, result):
        if actual_node is not None:
            self._recursive_in_order(actual_node.left, result)
            result.append(actual_node.data)
            self._recursive_in_order(actual_node.right, result)
    

    def height(self):
        return self._recursive_height(self.root)
    

    def _recursive_height(self, actual_node):
        if actual_node is None:
            return 0
        
        left_height = self._recursive_height(actual_node.left)
        right_height = self._recursive_height(actual_node.right)
        
        return max(left_height, right_height) + 1