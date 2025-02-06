package tree.easy;

import tree.TreeExamples;
import tree.TreeNode;

public class FindSecondMinValue {
    public static void main(String[] args) {
        TreeExamples t = new TreeExamples();
        TreeNode n = t.tree1();
        FindSecondMinValue f = new FindSecondMinValue();
        int i = f.findSecondMinimumValue(n);
        System.out.println(i);

    }

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null)
            return -1;
        int left = root.getVal() == root.getLeft().getVal() ? findSecondMinimumValue(root.getLeft()) : root.getLeft().getVal();
        int right = root.getVal() == root.getRight().getVal() ? findSecondMinimumValue(root.getRight()) : root.getRight().getVal();

        return left == -1 || right == -1 ? Math.max(left, right) : Math.min(left, right);

    }
}
