package tree;

import java.util.*;

public class TreeTraversalMedium extends TreeExamples {
    public static void main(String[] args) {
        TreeTraversalMedium tm = new TreeTraversalMedium();
                  /*
        Tree developed below is
                            4
                      2         6
                    1   3     5    8
                                  7
         */
        TreeNode tree = tm.tree1();


        List<String> output = tm.binaryTreePaths(tree);
        System.out.println(output);
        TreeNode tree2 = tm.tree3();
        List<List<Integer>> elements = tm.pathSum(tree2, 5);
        System.out.println(elements);
        List<Integer> result = tm.rightSideView(tree);
        System.out.println(result);
        System.out.println(tm.goodNodes(tree2));
        System.out.println(tm.isValidBST(tree));

    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> values = new ArrayList<>();
        binaryTreePaths(root, "", values);
        return values;
    }

    public void binaryTreePaths(TreeNode node, String path, List<String> values) {
        if (node == null)
            return;
        path = path == "" ? String.valueOf(node.val) : path + "->" + node.val;
        if (node.left == null && node.right == null) {

            values.add(path);

        }
        binaryTreePaths(node.left, path, values);
        binaryTreePaths(node.right, path, values);

    }

    private int heightLeft(TreeNode root) {
        return root == null ? -1 : 1 + heightLeft(root.left);
    }

    private int heightRight(TreeNode root) {
        return root == null ? -1 : 1 + heightRight(root.right);
    }

    public int nodesCount(TreeNode root) {
        int leftHeight = this.heightLeft(root);
        int rightHeight = this.heightRight(root);
        if (rightHeight == leftHeight) {
            return (1 << leftHeight) - 1; // this is shift wise operator which is same as 2^h -1
        }
        return 1 + nodesCount(root.left) + nodesCount(root.right);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> result = pathSum(root, targetSum, 0);
        return result;
    }

    List<List<Integer>> pathSum(TreeNode root, int targetSum, int currentSum) {
        if (root == null)
            return new ArrayList<>();
        currentSum += root.val;
        // not needed
     /*   if(currentSum> targetSum || (currentSum==targetSum && (root.left!=null|| root.right!=null )))
            return new ArrayList<>();*/
        if (root.left == null && root.right == null && targetSum == currentSum) {
            List<Integer> element = new LinkedList<>();
            element.add(root.val);
            List<List<Integer>> elements = new LinkedList<>();
            elements.add(element);
            return elements;
        }

        List<List<Integer>> leftList = pathSum(root.left, targetSum, currentSum);
        List<List<Integer>> rightList = pathSum(root.right, targetSum, currentSum);

        List<List<Integer>> finalList = new ArrayList<>();

        finalList.addAll(leftList);

        finalList.addAll(rightList);
        finalList.forEach(list -> {
            list.add(0, root.val);
        });
        return finalList;
    }

    public int findBottomLeftValue(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int left = 0;
        while (!queue.isEmpty()) {

            for (int i = 0; i < queue.size(); i++) {
                TreeNode t = queue.poll();
                left = t.val;
                if (t.right != null)
                    queue.offer(t.right);
                if (t.left != null)
                    queue.offer(t.left);
            }
        }
        return left;
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int right = 0;
            int s = queue.size();
            for (int i = 0; i < s; i++) {
                TreeNode tn = queue.poll();
                right = tn.val;
                if (tn.left != null) queue.offer(tn.left);
                if (tn.right != null) queue.offer(tn.right);
            }
            result.add(right);
        }
        return result;
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSame(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;

        if (s.val != t.val) return false;

        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }

    public int goodNodes(TreeNode root) {
        return goodNodes(root, -10000);
    }

    public int goodNodes(TreeNode root, int maxCurr) {
        if (root == null)
            return 0;
        int count = root.val >= maxCurr ? 1 : 0;
        count += goodNodes(root.left, Math.max(root.val, maxCurr));
        count += goodNodes(root.right, Math.max(root.val, maxCurr));
        return count;
    }

    /*public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        if((root.left!=null && root.left.val> root.val)
            || (root.right!=null && root.right.val < root.val))
            return false;
        boolean left = root.left == null || isValidBST(root.left);
        boolean right= root.right == null || isValidBST(root.right);
        return left && right;
    }*/


    public boolean isValidBST(TreeNode tn) {
        return (tn == null)
                || isValidBST(tn, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode tn, long minValue, long maxValue) {
        if (tn == null)
            return true;
        if (tn.val <= minValue
                || tn.val >= maxValue
                || (tn.left != null && tn.left.val >= tn.val)
                || (tn.right != null && tn.right.val <= tn.val))
            return false;
        boolean left = tn.left == null || isValidBST(tn.left, minValue, Math.min(tn.val, maxValue));
        boolean right = tn.right == null || isValidBST(tn.right, Math.max(tn.val, minValue), maxValue);
        return left && right;
    }
}
