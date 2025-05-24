package leetcode.trees;

import tree.TreeNode;

import java.util.*;

public class VerticalOrder987 {

    public static void main(String[] args) {

    }
    List<Triplet<Integer, Integer, Integer>> order;

   private void bfs(TreeNode root) {

        Queue<Triplet<TreeNode, Integer, Integer>> queue = new ArrayDeque();
        int row = 0, column = 0;
        queue.offer(new Triplet<>(root, row, column));
        while (!queue.isEmpty()) {
            Triplet<TreeNode, Integer, Integer> triplet = queue.poll();
            root = triplet.first;
            row = triplet.second;
            column = triplet.third;
            if (root != null) {
                order.add(new Triplet<>(column, row, root.val));
                queue.offer(new Triplet<>(root.left, row + 1, column - 1));
                queue.offer(new Triplet<>(root.right, row + 1, column + 1));
            }
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> output = new ArrayList<>();
        if(root==null)
            return output;
        this.order = new ArrayList<>();
        bfs(root);
        Collections.sort(this.order, new Comparator<Triplet<Integer, Integer, Integer>>() {
            @Override
            public int compare(Triplet<Integer, Integer, Integer> o1, Triplet<Integer, Integer, Integer> o2) {
                if(o1.first.equals(o2.first)){
                    if(o1.second.equals(o2.second)){
                        return o1.third- o2.third;
                    }
                    else{
                        return o1.second-o2.second;
                    }
                }else{
                    return o1.first-o2.first;
                }
            }
        });
        List<Integer> currColumn = new ArrayList<>();
        Integer currColIdx = this.order.get(0).first;
        for(Triplet<Integer,Integer,Integer> triplet : this.order){
            if(currColIdx.equals(triplet.first)){
                currColumn.add(triplet.third);
            }else{
                output.add(currColumn);
                currColIdx = triplet.first;;
                currColumn = new ArrayList<>();
                currColumn.add(triplet.third);
            }
        }
        output.add(currColumn);
        return output;
    }

    class Triplet<F, S, T> {
        private final F first;
        private final S second;
        private final T third;

        public Triplet(F first, S second, T third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
}
