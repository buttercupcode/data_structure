package leetcode.trees;

import tree.TreeExamples;
import tree.TreeNode;

public class SumRootToLeafNumber129 {
    public static void main(String[] args) {
        TreeExamples treeExamples = new TreeExamples();
        TreeNode root =  treeExamples.tree2();
        SumRootToLeafNumber129 s = new SumRootToLeafNumber129();
        int sum = 0;
        //s.sumNumbers(root);
        System.out.println(sum);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(1);
        node1.left = node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
       sum= s.sumNumbers(node1);
        System.out.println(sum
        );
    }

    public int sumNumbers(TreeNode root) {

        if(root==null)
            return 0;
        int left = sum(root.left,root.val);
        int right = sum(root.right,root.val);
        return left+ right;

    }

    public int sum(TreeNode root, int sum){
        if(root==null)
            return sum;
        sum = sum* 10;
        sum= sum + root.val;
        if(root.left==null && root.right==null)
            return sum;
        int left = 0;
        if(root.left!=null)
            left = sum(root.left,sum);
        int right = 0;
        if(root.right!=null)
            right = sum(root.right,sum);
        return left+right;
    }
}
