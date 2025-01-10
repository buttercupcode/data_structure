package tree.medium;

import tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int lenQ = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < lenQ; i++) {
                TreeNode element = queue.poll();


                if (element.getLeft() != null) queue.offer(element.getLeft());
                if (element.getRight() != null) queue.offer(element.getRight());
                list.add(element.getVal());
            }
            res.add(list);
        }
        return res;
    }
}
