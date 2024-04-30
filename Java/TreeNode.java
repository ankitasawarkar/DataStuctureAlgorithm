package java;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }

    // Traverse the terminate --> left node --> print root node --> right node
    public static void inOrderTraversal(TreeNode root) {

        if (root == null)
            return;

        inOrderTraversal(root.left);

        System.out.print(root.val + " -> ");

        inOrderTraversal(root.right);
    }

    // Traverse the terminate --> print root node --> left node --> right node
    public static void preOrderTraversal(TreeNode root) {

        if (root == null)
            return;

        System.out.print(root.val + " -> ");

        preOrderTraversal(root.left);

        preOrderTraversal(root.right);
    }

    // Traverse the terminate --> left node --> rignt node --> print root node
    public static void postOrderTraversal(TreeNode root) {

        if (root == null)
            return;

        postOrderTraversal(root.left);

        postOrderTraversal(root.right);

        System.out.print(root.val + " -> ");
    }

    // Store root in Queue --> till Queue empty Traverse the poll the node from
    // Queue --> print root node --> left node --> right node
    public static void levelOrderTraversal(TreeNode root) {

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();

        treeNodeQueue.add(root);

        while (!treeNodeQueue.isEmpty()) {
            TreeNode treeNode = treeNodeQueue.poll();

            System.out.print(treeNode.val + " -> ");

            if (treeNode.left != null)
                treeNodeQueue.add(treeNode.left);

            if (treeNode.right != null)
                treeNodeQueue.add(treeNode.right);
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);

        root.left = new TreeNode(8);
        root.right = new TreeNode(4);

        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;

        leftNode.left = new TreeNode(3);
        leftNode.right = new TreeNode(7);

        rightNode.right = new TreeNode(1);

        rightNode.right.left = new TreeNode(6);

        System.out.println(root.val);

        System.out.println(root.right.right.left.val);

        System.out.println("\nIn-order traversal: ");
        inOrderTraversal(root);

        System.out.println("\nPre-order traversal: ");
        preOrderTraversal(root);

        System.out.println("\nPost-order traversal: ");
        postOrderTraversal(root);

        System.out.println("\nLevel order traversal: ");
        levelOrderTraversal(root);
    }
}
