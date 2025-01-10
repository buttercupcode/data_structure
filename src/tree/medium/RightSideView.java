package tree.medium;

import tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    public static void main(String[] args) {

    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int output = 0;
            for (int i = 0; i < size; i++) {
                TreeNode t = queue.poll();
                output = t.getVal();
                if (t.getLeft() != null) queue.offer(t.getLeft());
                if (t.getRight() != null) queue.offer(t.getRight());
            }
            res.add(output);
        }
        return res;
    }
}
