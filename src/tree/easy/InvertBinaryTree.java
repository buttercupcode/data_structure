package tree.easy;

import tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(6);
        root.setLeft(left);
        root.setRight(right);

        right.setLeft(new TreeNode(5));
        right.setRight(new TreeNode(7));

        left.setRight(new TreeNode(3));
        left.setLeft(new TreeNode(1));
        InvertBinaryTree ibt = new InvertBinaryTree();
        TreeNode output = ibt.invertTreeQueue(root);
        System.out.println(output);
    }

    public TreeNode invertTreeRecursion(TreeNode root) {
        if (root == null) {
            return root;
        }
        if (root.getLeft() == null && root.getRight() == null)
            return root;
        TreeNode left = invertTreeRecursion(root.getRight());
        TreeNode right = invertTreeRecursion(root.getLeft());
        root.setLeft(left);
        root.setRight(right);
        return root;
    }

    public TreeNode invertTreeStack(TreeNode root) {
        if (root == null) {
            return root;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode left = node.getLeft();
            node.setLeft(node.getRight());
            node.setRight(left);
            if (node.getLeft() != null)
                stack.push(node.getLeft());
            if (node.getRight() != null)
                stack.push(node.getRight());
        }
        return root;
    }

    public TreeNode invertTreeQueue(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode left = node.getLeft();
            node.setLeft(node.getRight());
            node.setRight(left);
            if (node.getLeft() != null)
                queue.offer(node.getLeft());
            if (node.getRight() != null)
                queue.offer(node.getRight());
        }
        return root;
    }
}
