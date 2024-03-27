package Java;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversel {
    
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
}
