package leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RandomizedSet {
    HashMap<Integer, Integer> mapping;
    List<Integer> nums;
    Random random;


    public RandomizedSet() {
        mapping = new HashMap<>();
        nums = new ArrayList<>();
        random = new Random();

    }

    public boolean insert(int val) {
        boolean b = mapping.containsKey(val);
        if (b) return false;
        mapping.put(val, nums.size());
        nums.add(val);
        return true;
    }

    public boolean remove(int val) {
        boolean r = mapping.containsKey(val);
        if (!r) return false;
        int valIdx = mapping.get(val);
        if (valIdx < nums.size() - 1) {
            int lastKey = nums.get(nums.size() - 1);
            nums.set(valIdx, lastKey);
            mapping.put(lastKey, valIdx);
        }
        nums.remove(nums.size() - 1);
        return mapping.remove(val, valIdx);

    }

    public int getRandom() {
        int num = random.nextInt(0, nums.size());
        return nums.get(num);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */