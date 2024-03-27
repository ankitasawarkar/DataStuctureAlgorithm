package Java;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree {

    TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    // Insert Recursively
    public void insert(List<Integer> values) {
        for (Integer val : values) {
            root = insertRecursive(root, val);
        }
    }

    private TreeNode insertRecursive(TreeNode root, Integer val) {
        if (val == null) {
            return null;
        }

        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insertRecursive(root.left, val);
        } else if (val > root.val) {
            root.right = insertRecursive(root.right, val);
        }

        return root;
    }

    // Insert Level Order 
    public TreeNode insertLevelOrder(List<Integer> values) {
        if (values == null || values.isEmpty()) {
            return null;
        }

        TreeNode root = new TreeNode(values.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        for (int i = 1; i < values.size(); i += 2) {
            TreeNode current = queue.poll();

            if (values.get(i) != null) {
                current.left = new TreeNode(values.get(i));
                queue.add(current.left);
            }

            if (i + 1 < values.size() && values.get(i + 1) != null) {
                current.right = new TreeNode(values.get(i + 1));
                queue.add(current.right);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        List<Integer> values = Arrays.asList(3,9,20,null,null,15,7);
        TreeNode node = bst.insertLevelOrder(values);
        System.out.println("Inorder Traversal:");
        TreeTraversel.inOrderTraversal(node);
    }
}
