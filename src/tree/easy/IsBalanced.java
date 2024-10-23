package tree.easy;

import tree.TreeNode;

public class IsBalanced {
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
        IsBalanced ib = new IsBalanced();
        System.out.println(ib.isBalanced(root));
    }

    public boolean isBalanced(TreeNode root) {
        int height = getHeight(root);
        return height != -1;

    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getHeight(root.getLeft());
        int right = getHeight(root.getRight());
        if (left == -1 || right == -1)
            return -1;

        int diff = left >= right ? left - right : right - left;
        if (diff > 1)
            return -1;
        else {
            return Math.max(left, right) + 1;
        }
    }
}
