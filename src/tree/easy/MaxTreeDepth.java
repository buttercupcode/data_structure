package tree.easy;

import tree.TreeNode;

public class MaxTreeDepth {
    int max = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(6);
        root.setLeft(left);
        root.setRight(right);

        right.setLeft(new TreeNode(5));
        right.setRight(new TreeNode(7));

        left.setRight(new TreeNode(3));
        left.setLeft(new TreeNode(1));
        MaxTreeDepth mtd = new MaxTreeDepth();
        System.out.println(mtd.diameter(root));
    }

    public int diameter(TreeNode root) {
        maxDepth(root);
        return max;
    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = maxDepth(root.getLeft());
        int right = maxDepth(root.getRight());
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}
