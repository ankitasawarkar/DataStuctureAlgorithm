package Java;

public class TreeProblems {
    
    public static void main(String[] args) {

        TreeNode root = new TreeNode();
        insertedDataTree(root);


        System.out.println("\nIn-order traversal: ");
        TreeTraversel.inOrderTraversal(root);

        System.out.println("\nPre-order traversal: ");
        TreeTraversel.preOrderTraversal(root);

        System.out.println("\nPost-order traversal: ");
        TreeTraversel.postOrderTraversal(root);

        System.out.println("\nLevel order traversal: ");
        TreeTraversel.levelOrderTraversal(root);
    }

    private static void insertedDataTree(TreeNode root) {
        root = new TreeNode(2);

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
    }
}
