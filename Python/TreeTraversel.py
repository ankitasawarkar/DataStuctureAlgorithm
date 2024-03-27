import TreeNode
from collections import defaultdict 

class TreeTravelsal:
    inorder_result = []
    preorder_result = []
    postorder_result = []

# Traverse the terminate --> left node --> print root node --> right node
    def inOrderTraversal(self, root: TreeNode):
        
        if not root: return
        self.inOrderTraversal(root.left)
        self.inorder_result.append(root.val)
        self.inOrderTraversal(root.right)

# Traverse the terminate --> left node --> print root node --> right node
    def inOrderTraversal(self, root: TreeNode):
        
        if not root: return
        self.inOrderTraversal(root.left)
        self.inorder_result.append(root.val)
        self.inOrderTraversal(root.right)

# Traverse the terminate --> left node --> print root node --> right node
    def inOrderTraversal(self, root: TreeNode):
        
        if not root: return
        self.inOrderTraversal(root.left)
        self.inorder_result.append(root.val)
        self.inOrderTraversal(root.right)

# Store root in Queue --> till Queue empty Traverse the poll the node from
# Queue --> print root node --> left node --> right node
    def levelOrder(self, root: TreeNode):
        result = defaultdict(list)
    
        def depth(node,level):
            if not node: return
            result[level].append(node.val)
            depth(node.left,level+1)
            depth(node.right,level+1)
            
        depth(root,0)
            
        return result.values()

