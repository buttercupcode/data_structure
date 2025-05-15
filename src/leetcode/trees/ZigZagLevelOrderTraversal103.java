package leetcode.trees;

import tree.TreeExamples;
import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagLevelOrderTraversal103 {
    public static void main(String[] args) {
        TreeExamples examples = new TreeExamples();
        TreeNode root= examples.tree5();
        ZigZagLevelOrderTraversal103 zig = new ZigZagLevelOrderTraversal103();
        List<List<Integer>> lists = zig.zigzagLevelOrder(root);
        System.out.println(lists);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        boolean even=true;
        if(root==null)
            return ans;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            while(size-->0){
                TreeNode node = queue.poll();
                level.add(node.val);
                if(even){
                    if(node.right!=null)queue.offer(node.right);
                    if(node.left!=null) queue.offer(node.left);
                }
                else{

                    if(node.left!=null) queue.offer(node.left);
                    if(node.right!=null)queue.offer(node.right);
                }
            }
            even=!even;
            ans.add(level);
        }

        return ans;
    }
}
