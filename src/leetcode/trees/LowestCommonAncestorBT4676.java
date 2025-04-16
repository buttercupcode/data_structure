package leetcode.trees;

import tree.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestorBT4676 {

    public static void main(String[] args) {

    }
    private TreeNode lca;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Set<Integer> set = new HashSet<>();
        for (TreeNode node : nodes) {
            set.add(node.getVal());
        }
        int max = helper(root, set);
        return lca;

    }

    public int helper(TreeNode root, Set<Integer> nodes) {
        if (root == null)
            return 0;
        int left = helper(root.getLeft(), nodes);
        int right = helper(root.getRight(), nodes);
        int foundCount = left + right;
        if (nodes.contains(root.getVal()))
            foundCount++;
        if (foundCount == nodes.size() && lca == null)
            lca = root;
        return foundCount;
    }
}
