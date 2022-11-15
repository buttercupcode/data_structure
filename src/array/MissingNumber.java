package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MissingNumber {
    public static void main(String[] args) {
        MissingNumber mn = new MissingNumber();
        List<Integer> disappearedNumbers = mn.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        disappearedNumbers.forEach(System.out::println);
        disappearedNumbers = mn.findDisappearedNumbersLeetCode(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        disappearedNumbers.forEach(System.out::println);
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] freqArray = new int[nums.length];
        for (int num : nums) {
            freqArray[num - 1]++;
        }
        Set<Integer> missingNumbers = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (freqArray[i] == 0)
                missingNumbers.add(i + 1);
        }
        return missingNumbers.stream().toList();
    }

    public List<Integer> findDisappearedNumbersLeetCode(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < nums.length; i++)
            nums[(nums[i] - 1) % n] += n;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] <= n) res.add(i + 1);
        return res;
    }
}
