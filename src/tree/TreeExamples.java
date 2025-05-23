package tree;

import java.util.ArrayList;
import java.util.List;

public class TreeExamples {
    public TreeNode tree1() {
          /*
        Tree developed below is
                            4
                      2         6
                    1   3     5    8
                                  7
         */
        TreeNode tree = new TreeNode(4);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(6);
        tree.left.left = new TreeNode(1);
        tree.left.right = new TreeNode(3);
        tree.right.right = new TreeNode(8);
        tree.right.left = new TreeNode(5);
        tree.right.right.left = new TreeNode(7);
        return tree;
    }

    public TreeNode tree2() {
        /*
         * Test tree 2
         *      1
         * 2         3
         *
         * */
        ////
        TreeNode testTree = new TreeNode(1);
        testTree.left = new TreeNode(2);
        testTree.right = new TreeNode(3);
        return testTree;
    }

    public TreeNode tree3() {
        /**
         * This si a
         *
         **/
        TreeNode tree2 = new TreeNode(2);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(2);
        tree2.left.left = new TreeNode(1);
        tree2.left.right = new TreeNode(1);
        tree2.right.right = new TreeNode(1);
        tree2.right.left = new TreeNode(0);
        return tree2;
    }

    /**
     * 1
     * /   \
     * 2       2
     * \     /
     * 3   3
     */
    public TreeNode tree4() {
        /**
         * This si a
         *
         **/
        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(2);
        tree2.left.right = new TreeNode(3);
        tree2.right.left = new TreeNode(3);
        return tree2;
    }

    /**
     * 1
     * /   \
     * 2       3
     * \     /
     * 4   5
     */
    public TreeNode tree5() {
        /**
         * This si a
         *
         **/
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);
        tree1.left.right = new TreeNode(4);
        tree1.right.left = new TreeNode(5);
        return tree1;
    }

    /**
     * 1
     * /   \
     * 2       3
     * \     /
     * 4   5
     */
    public TreeNode tree6() {
        /**
         * This si a
         *
         **/
        TreeNode tree1 = new TreeNode(4);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(6);
        tree1.left.left = new TreeNode(1);
        tree1.right.left = new TreeNode(3);
        return tree1;
    }

    public List<Integer> preOrder(NArrayNode node) {
        List<Integer> result = new ArrayList<>();
        preOrder(node, result);
        return result;
    }

    public void preOrder(NArrayNode node, List<Integer> list) {
        if (node == null)
            return;
        list.add(node.val);
        for (NArrayNode child : node.children) {
            preOrder(child, list);
        }
    }
}
