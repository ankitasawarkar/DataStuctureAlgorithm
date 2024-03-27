from TreeTraversel import TreeTravelsal
from TreeNode import TreeNode

class TreeInsert:

    
    def insert_inorder(self, root, values, index:int):
        if index < len(values):
            if values[index] is not None:
                root = TreeNode(values[index])
                root.left = self.insert_inorder(root.left, values, 2 * index + 1)
                root.right = self.insert_inorder(root.right, values, 2 * index + 2)
        return root
    
if __name__ == "__main__":
    values = [3, 9, 20, None, None, 15, 7]
    tree_insert = TreeInsert()  # Create an instance of the TreeInsert class
    root = tree_insert.insert_inorder(None, values, 0)  # Use the instance to call the method

    traversal = TreeTravelsal()
    traversal.inorder_result(root)
