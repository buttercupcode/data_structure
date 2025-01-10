package tree.medium;

import tree.TreeNode;

public class CommonAncestor {
    public static void main(String[] args) {

    }

    public int commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;
        while (current != null) {
            if (current.getVal() > p.getVal() && current.getVal() > q.getVal())
                current = current.getLeft();
            else if (current.getVal() < p.getVal() && current.getVal() < q.getVal()) {
                current = current.getRight();
            } else {
                return current.getVal();
            }
        }
        return -1;
    }
}
