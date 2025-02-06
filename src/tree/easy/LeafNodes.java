package tree.easy;

import tree.TreeExamples;
import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeafNodes {
    public static void main(String[] args) {
        LeafNodes l = new LeafNodes();
        TreeExamples t = new TreeExamples();
        TreeNode n = t.tree1();
        List<Integer> list = l.leafNodes(n);
        list.forEach(e -> System.out.println(e));
    }

    public List<Integer> leafNodes(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return leafNodes(root, list);

    }

    public List<Integer> leafNodes(TreeNode root, List<Integer> list) {
        if (root == null)
            return list;
        if ((root.getLeft() == null) && (root.getRight() == null))
            list.add(root.getVal());
        leafNodes(root.getLeft(), list);
        leafNodes(root.getRight(), list);
        return list;

    }
}
