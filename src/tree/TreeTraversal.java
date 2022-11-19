package tree;

import java.util.*;

public class TreeTraversal {
    public static void main(String[] args) {
        /*
        Tree developed below is
                            4
                      2         6
                    1   3     5    8
                                  7
         */
        BinaryTreeNode tree = new BinaryTreeNode(4);
        tree.left = new BinaryTreeNode(2);
        tree.right = new BinaryTreeNode(6);
        tree.left.left = new BinaryTreeNode(1);
        tree.left.right = new BinaryTreeNode(3);
        tree.right.right = new BinaryTreeNode(8);
        tree.right.left = new BinaryTreeNode(5);
        tree.right.right.left = new BinaryTreeNode(7);

        ////
        System.out.println("PreOrderTraversal using Recursion");
        TreeTraversal t = new TreeTraversal();
        t.preOrderTraversal(tree);
        System.out.println();
        System.out.println("PreOrderTraversal using Iteration");
        t.preOrderTraversalIt(tree);
        System.out.println();
        System.out.println("InOrderTraversal using Recursion");
        t.inOrderTraversal(tree);
        System.out.println();
        System.out.println("InOrderTraversal using Iteration");
        t.inOrderTraversalIt(tree);
        System.out.println();
        System.out.println("InOrder traversal using diff approach");
        List<Integer> lis = t.InOrderTryDiffApproach(tree);
        System.out.println(lis);
        System.out.println();
        System.out.println("PostOrderTraversal using Recursion");
        t.postOrderTraversal(tree);
        System.out.println();
        System.out.println("PostOrderTraversal using iteration");
        t.postOrderTraversalIt(tree);
        System.out.println();
        System.out.println("Level Order Traversal using Iteration");
        t.levelOrderTraversalIt(tree);
        System.out.println();
        System.out.println("level order list traversal");
        List<List<Integer>> elements = t.levelOrderAllLevelInOneList(tree);
        System.out.println(elements);
        elements = t.levelOrderAllLevelBottomFirst(tree);
        System.out.println(elements);
        System.out.println("tree max " + t.findMax(tree));
        System.out.println("max using recursion " + t.findMaxRecursion(tree));

    }

    public void preOrderTraversal(BinaryTreeNode root) {
        if (root == null)
            return;
        System.out.print(root.getValue() + "->");
        preOrderTraversal(root.getLeft());
        preOrderTraversal(root.getRight());

    }

    public void preOrderTraversalIt(BinaryTreeNode root) {

        Stack<BinaryTreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                System.out.print(root.getValue() + "->");
                stack.push(root);
                root = root.getLeft();
            }
            if (stack.isEmpty())
                return;
            root = stack.pop().getRight();
        }
    }

    public void inOrderTraversal(BinaryTreeNode root) {
        if (root == null)
            return;
        inOrderTraversal(root.getLeft());
        System.out.print(root.getValue() + "->");
        inOrderTraversal(root.getRight());
    }

    public void inOrderTraversalIt(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.getLeft();
            }

            if (stack.isEmpty())
                return;
            root = stack.pop();
            System.out.print(root.getValue() + "->");
            root = root.getRight();
        }
    }

    public void postOrderTraversal(BinaryTreeNode root) {
        if (root == null)
            return;
        postOrderTraversal(root.getLeft());
        postOrderTraversal(root.getRight());
        System.out.print(root.getValue() + "->");
    }

    public void postOrderTraversalIt(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode previous = null;
        do {
            while (root != null) {
                stack.push(root);
                root = root.getLeft();
            }
            while (root == null && !stack.isEmpty()) {
                root = stack.peek();
                if (root.getRight() == null || root.getRight() == previous) {
                    System.out.print(root.getValue() + "->");
                    stack.pop();
                    previous = root;
                    root = null;
                } else
                    root = root.getRight();
            }
        } while (!stack.isEmpty());
    }

    public void levelOrderTraversalIt(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new ArrayDeque<>();
        do {
            while (root != null) {
                System.out.print(root.getValue() + "->");
                if (root.getLeft() != null) queue.add(root.getLeft());
                if (root.getRight() != null) queue.add(root.getRight());
                root = queue.poll();
            }
        } while (!queue.isEmpty());
    }

    public List<List<Integer>> levelOrderAllLevelInOneList(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                BinaryTreeNode n = queue.peek();
                if (n.left != null) queue.offer(n.left);
                if (n.right != null) queue.offer(n.right);
                levelList.add(queue.poll().value);
            }
            if (!levelList.isEmpty())
                result.add(levelList);
        }
        return result;
    }

    public List<List<Integer>> levelOrderAllLevelBottomFirst(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                BinaryTreeNode n = queue.peek();
                if (n.left != null) queue.offer(n.left);
                if (n.right != null) queue.offer(n.right);
                levelList.add(queue.poll().value);
            }
            if (!levelList.isEmpty())
                result.add(0, levelList);
        }
        return result;
    }

    public int findMax(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        if (root == null)
            return 0;
        int maxNumber = Integer.MIN_VALUE;
        stack.push(root);
        while (!stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                maxNumber = Math.max(maxNumber, root.value);
                System.out.print("->" + root.value);
                root = root.getLeft();
            }
            root = stack.pop().getRight();
        }
        return maxNumber;
    }

    public int findMaxRecursion(BinaryTreeNode root) {
        int left = Integer.MIN_VALUE, right = Integer.MIN_VALUE, max = Integer.MIN_VALUE;
        if (root == null)
            return Integer.MIN_VALUE;
        max = root.value;
        left = findMaxRecursion(root.left);
        right = findMaxRecursion(root.right);
        max = Math.max(max, left);
        max = Math.max(max, right);

        return max;

    }

    public List<Integer> InOrderTryDiffApproach(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        List<Integer> lis = new ArrayList<>();
        if (root == null)
            return lis;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.getLeft();
            }
            BinaryTreeNode b = stack.pop();
            lis.add(b.getValue());
            root = b.getRight();

        }
        return lis;
    }
}
