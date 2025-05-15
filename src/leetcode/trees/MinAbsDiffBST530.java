package leetcode.trees;

import tree.TreeExamples;
import tree.TreeNode;

public class MinAbsDiffBST530 {
    public static void main(String[] args) {
        MinAbsDiffBST530 min = new MinAbsDiffBST530();
        TreeExamples treeExamples = new TreeExamples();
        TreeNode tn = treeExamples.tree6();
        int diff = min.getMinimumDifference(tn);
        System.out.println(diff);
    }
    int minDiff= Integer.MAX_VALUE;
    TreeNode prev;

    void inOrderTraversal(TreeNode node){
        if(node==null)
            return;
        inOrderTraversal(node.left);
        if(prev!=null){
            minDiff = Math.min(minDiff, node.val-prev.val);
        }
        prev=node;
        inOrderTraversal(node.right);
    }
    public int getMinimumDifference(TreeNode root) {
        inOrderTraversal(root);
        return minDiff;
    }
}
