package tree;

import java.util.*;
import java.util.stream.Collectors;

public class TreeTraversalBasic extends TreeExamples {
    public static void main(String[] args) {
        TreeTraversalBasic t = new TreeTraversalBasic();
        TreeNode tree = t.tree1();
        System.out.println("PreOrderTraversal using Recursion");

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

        List<Integer> maxValues = t.largestValues(tree);
        System.out.println("Max Values :: " + maxValues);


        t.sumLeafToNodeNumbers(tree);
        int sumNumber = t.sumNumber(tree);
        System.out.println(" sum number " + sumNumber);
    }


    public void preOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.getVal() + "->");
        preOrderTraversal(root.getLeft());
        preOrderTraversal(root.getRight());

    }

    public void preOrderTraversalIt(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                System.out.print(root.getVal() + "->");
                stack.push(root);
                root = root.getLeft();
            }
            if (stack.isEmpty())
                return;
            root = stack.pop().getRight();
        }
    }

    public void inOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        inOrderTraversal(root.getLeft());
        System.out.print(root.getVal() + "->");
        inOrderTraversal(root.getRight());
    }

    public void inOrderTraversalIt(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.getLeft();
            }

            if (stack.isEmpty())
                return;
            root = stack.pop();
            System.out.print(root.getVal() + "->");
            root = root.getRight();
        }
    }

    public void postOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        postOrderTraversal(root.getLeft());
        postOrderTraversal(root.getRight());
        System.out.print(root.getVal() + "->");
    }

    public void postOrderTraversalIt(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode previous = null;
        do {
            while (root != null) {
                stack.push(root);
                root = root.getLeft();
            }
            while (root == null && !stack.isEmpty()) {
                root = stack.peek();
                if (root.getRight() == null || root.getRight() == previous) {
                    System.out.print(root.getVal() + "->");
                    stack.pop();
                    previous = root;
                    root = null;
                } else
                    root = root.getRight();
            }
        } while (!stack.isEmpty());
    }

    public void levelOrderTraversalIt(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        do {
            while (root != null) {
                System.out.print(root.getVal() + "->");
                if (root.getLeft() != null) queue.add(root.getLeft());
                if (root.getRight() != null) queue.add(root.getRight());
                root = queue.poll();
            }
        } while (!queue.isEmpty());
    }

    public List<List<Integer>> levelOrderAllLevelInOneList(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode n = queue.peek();
                if (n.left != null) queue.offer(n.left);
                if (n.right != null) queue.offer(n.right);
                levelList.add(Objects.requireNonNull(queue.poll()).val);
            }
            if (!levelList.isEmpty())
                result.add(levelList);
        }
        return result;
    }

    public List<List<Integer>> levelOrderAllLevelBottomFirst(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode n = queue.peek();
                if (n.left != null) queue.offer(n.left);
                if (n.right != null) queue.offer(n.right);
                levelList.add(queue.poll().val);
            }
            if (!levelList.isEmpty())
                result.add(0, levelList);
        }
        return result;
    }

    public int findMax(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null)
            return 0;
        int maxNumber = Integer.MIN_VALUE;
        stack.push(root);
        while (!stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                maxNumber = Math.max(maxNumber, root.val);
                System.out.print("->" + root.val);
                root = root.getLeft();
            }
            root = stack.pop().getRight();
        }
        return maxNumber;
    }

    public int findMaxRecursion(TreeNode root) {
        int left, right, max;
        if (root == null)
            return Integer.MIN_VALUE;
        max = root.val;
        left = findMaxRecursion(root.left);
        right = findMaxRecursion(root.right);
        max = Math.max(max, left);
        max = Math.max(max, right);

        return max;

    }

    public List<Integer> InOrderTryDiffApproach(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> lis = new ArrayList<>();
        if (root == null)
            return lis;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.getLeft();
            }
            TreeNode b = stack.pop();
            lis.add(b.getVal());
            root = b.getRight();

        }
        return lis;
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                TreeNode b = queue.poll();
                max = Math.max(max, b.getVal());
                if (b.getLeft() != null) queue.offer(b.getLeft());
                if (b.getRight() != null) queue.offer(b.getRight());
            }
            result.add(max);
        }
        return result;
    }

    /**
     * 1
     * 2   3
     * Input: root = [1,2,3]
     * Output: 25
     * Explanation:
     * The root-to-leaf path 1->2 represents the number 12.
     * The root-to-leaf path 1->3 represents the number 13.
     * Therefore, sum = 12 + 13 = 25.
     *
     * @param root
     * @return
     */
    public void sumLeafToNodeNumbers(TreeNode root) {
        List<String> allLeaf = sumNumberStringMethod(root);
        System.out.println(allLeaf);
    }

    public List<String> sumNumberStringMethod(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<String> left = sumNumberStringMethod(root.left);
        List<String> right = sumNumberStringMethod(root.right);

        left.addAll(right);
        if (left == null || left.size() == 0) {
            left = new ArrayList<>();
            left.add(String.valueOf(root.val));
            return left;
        }
        return left.stream().map(s -> root.val + s).collect(Collectors.toCollection(ArrayList::new));
    }

    public int sumNumber(TreeNode tree) {
        int sum = sumNumber(tree, 0);
        return sum;
    }

    public int sumNumber(TreeNode node, int sum) {
        if (node == null) return 0;
        if (node.left == null && node.right == null)
            return sum * 10 + node.val;
        int leftSum = sumNumber(node.left, sum * 10 + node.val);
        int rightSum = sumNumber(node.right, sum * 10 + node.val);
        return leftSum + rightSum;
    }
}
