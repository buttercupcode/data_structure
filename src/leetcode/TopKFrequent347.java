package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class TopKFrequent347 {
    public static void main(String[] args) {
        TopKFrequent347 top = new TopKFrequent347();
        int[] res = top.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        for (int i : res)
            System.out.println(i);
    }

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
        int[] res = new int[k];
        for (int i : nums)
            map.put(i, map.getOrDefault(i, 0) + 1);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(entry);
        }
        for (int i = 0; i < k; i++) {
            res[i] = Objects.requireNonNull(queue.poll()).getKey();
        }

        return res;

    }
}
