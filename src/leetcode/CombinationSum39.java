package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> comb = new LinkedList<>();
        backTrack(target, comb, 0, candidates, res);
        return res;
    }

    public void backTrack(int remain, List<Integer> comb, int start, int[] candidates, List<List<Integer>> res) {
        if (remain == 0) {
            res.add(new ArrayList<>(comb));
            return;
        } else if (remain < 0)
            return;

        for (int i = start; i < candidates.length; ++i) {
            comb.add(candidates[i]);
            backTrack(remain - candidates[i], comb, i, candidates, res);
            comb.removeLast();
        }
    }
}

