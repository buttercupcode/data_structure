package tree.easy;

import tree.TreeNode;

public class IsSameTree {
    public static void main(String[] args) {


        TreeNode root1 = new TreeNode(4);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(6);
        root1.setLeft(left);
        root1.setRight(right);

        right.setLeft(new TreeNode(5));
        right.setRight(new TreeNode(7));

        left.setRight(new TreeNode(3));
        left.setLeft(new TreeNode(1));
        //
        TreeNode root2 = new TreeNode(4);
        TreeNode left2 = new TreeNode(2);
        TreeNode right2 = new TreeNode(6);
        root2.setLeft(left2);
        root2.setRight(right2);

        right2.setLeft(new TreeNode(5));
        TreeNode rightRight = new TreeNode(7);
        rightRight.setRight(new TreeNode(8));
        right2.setRight(rightRight);

        left2.setRight(new TreeNode(3));
        left2.setLeft(new TreeNode(1));
        IsSameTree ist = new IsSameTree();
        System.out.println(ist.isSameTree(root1, root2));


    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        else if ((p != null && q == null) || (p == null && q != null))
            return false;
        else if (p.getVal() != q.getVal())
            return false;
        else if (p.getVal() == q.getVal()) {
            boolean left = isSameTree(p.getLeft(), q.getLeft());
            boolean right = isSameTree(p.getRight(), q.getRight());
            return left && right;
        }
        return true;
    }
}
