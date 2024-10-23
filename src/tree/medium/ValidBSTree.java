package tree.medium;

import tree.TreeNode;

import java.util.Stack;

public class ValidBSTree {
    public static void main(String[] args) {
        ValidBSTree vbt = new ValidBSTree();

    }

    public boolean isValidBST(TreeNode root) {
        TreeNode current = root,preCurr=null;
        Stack<TreeNode> stack = new Stack<>();
        while (current!=null || !stack.isEmpty()){
            while (current!=null){
                stack.push(current);
                current=current.getLeft();
            }
            current= stack.pop();
            if(preCurr!=null && current.getVal()<=preCurr.getVal())
                return false;
            preCurr=current;
            current=current.getRight();

        }
        return true;
    }
}
