package tree.easy;

import tree.TreeNode;

public class HeightAndDepthOfNode {
    public static void main(String[] args) {

    }

    public int depthTree(TreeNode root, int x) {
        if (root == null)
            return -1;
        int dis = -1;
        if ((root.getVal() == x)) {
            return 0;
        } else {
            int left = depthTree(root.getLeft(), x);
            int right = depthTree(root.getRight(), x);
            return Math.max(left, right) + 1;
        }
    }
}
