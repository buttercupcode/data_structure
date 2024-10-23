package tree.hard;

import tree.TreeNode;

public class MaxPathSum {

    int max;
    public static void main(String[] args) {

    }
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return max;
    }

    public int maxSum(TreeNode root){
        if(root== null)
            return 0;
        int left = Math.max(0,maxPathSum(root.getLeft()));
        int right= Math.max(0,maxPathSum(root.getRight()));
        int maxSum = root.getVal()+left+right;

        max= Math.max(max,maxSum);

        return Math.max(left,right)+ root.getVal();
    }
}
