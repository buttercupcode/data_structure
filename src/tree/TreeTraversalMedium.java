package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
}
