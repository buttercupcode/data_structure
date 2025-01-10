package tree.easy;

import tree.TreeNode;

public class IsSubTree {
    IsSameTree ist = new IsSameTree();

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
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null)
            return true;
        if (root == null) return false;
        if (ist.isSameTree(root, subRoot)) return true;
        boolean leftSame = isSubtree(root.getLeft(), subRoot);
        boolean rightSame = isSubtree(root.getRight(), subRoot);
        return leftSame || rightSame;


    }
}
