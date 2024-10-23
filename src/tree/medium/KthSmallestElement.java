package tree.medium;

import tree.TreeNode;

import java.util.Stack;

public class KthSmallestElement {
    public static void main(String[] args) {

    }
    public int kthSmallest(TreeNode root, int k) {
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        while (current!=null|| !stack.isEmpty()){
            while(current!=null){
                stack.push(current);
                current=current.getLeft();
            }
            current=stack.pop();
            if(--k==0)
                return current.getVal();

            current=current.getRight();
        }
        return 0;

    }
}
