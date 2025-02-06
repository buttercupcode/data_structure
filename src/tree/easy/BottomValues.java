package tree.easy;

import tree.TreeExamples;
import tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class BottomValues {
    public static void main(String[] args) {
        TreeExamples t = new TreeExamples();
        BottomValues rn = new BottomValues();
        TreeNode n = t.tree1();
        System.out.println(rn.rightMost(n));

        n = t.tree2();
        System.out.println("bottom right " + rn.rightMost(n));
        System.out.println("bottom left " + rn.bottomLeft(n));

        n = t.tree3();
        System.out.println("bottom right " + rn.rightMost(n));
        System.out.println("bottom left " + rn.bottomLeft(n));

        n = t.tree4();
        System.out.println("bottom right " + rn.rightMost(n));
        System.out.println("bottom left " + rn.bottomLeft(n));

    }

    public int rightMost(TreeNode root) {
        if (root == null)
            return -1;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        TreeNode curr = root;

        while (!queue.isEmpty()) {
            curr = queue.poll();
            if (curr.getLeft() != null) queue.offer(curr.getLeft());
            if (curr.getRight() != null) queue.offer(curr.getRight());
        }
        return curr.getVal();

    }

    public int bottomLeft(TreeNode root) {
        if (root == null)
            return -1;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        TreeNode curr = root;

        while (!queue.isEmpty()) {
            curr = queue.poll();

            if (curr.getRight() != null) queue.offer(curr.getRight());
            if (curr.getLeft() != null) queue.offer(curr.getLeft());
        }
        return curr.getVal();

    }
}
