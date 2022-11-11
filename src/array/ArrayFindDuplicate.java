package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayFindDuplicate {

    public static void main(String[] args) {
        ArrayFindDuplicate a = new ArrayFindDuplicate();
        int[] nums = new int[]{2, 5, 9, 6, 9, 3, 8, 9, 7, 1};
        System.out.println(a.dupBySorting(nums));
        System.out.println(a.dupBySet(nums));
        System.out.println(a.dupByNegativeMarking(nums));
        for (int num : nums)
            System.out.print(num + " ");
        System.out.println();
        System.out.println(a.arrayAsHashMap(nums));
        System.out.println(a.findDupByBinary(nums));
        System.out.println(Arrays.toString(a.findErrorNums(new int[]{2, 2})));
    }

    public int dupBySorting(int[] nums) {
        int[] num2 = Arrays.copyOf(nums, nums.length);
        Arrays.sort(num2);
        for (int i = 1; i < num2.length; i++) {
            if (num2[i] == num2[i - 1]) return num2[i];
        }
        return -1;
    }

    public int dupBySet(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            if (numSet.contains(num)) return num;
            numSet.add(num);
        }
        return -1;
    }

    public int dupByNegativeMarking(int[] nums) {
        int duplicate = -1;
        for (int i = 0; i < nums.length; i++) {
            int current = Math.abs(nums[i]);
            if (nums[current] < 0) {
                duplicate = current;
                break;
            }
            nums[current] *= -1;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }
        return duplicate;
    }

    public int arrayAsHashMap(int[] nums) {
        int[] num2 = Arrays.copyOf(nums, nums.length);
        return swap(num2, 0);
    }

    public int swap(int[] nums, int number) {
        if (nums[number] == number) return number;
        int temp = nums[number];
        nums[number] = number;
        return swap(nums, temp);
    }

    public int findDupByBinary(int[] nums) {
        int[] num2 = Arrays.copyOf(nums, nums.length);
        int low = 0, high = num2.length - 1, duplicate = -1;
        while (low <= high) {
            int cur = (low + high) / 2;
            int count = 0;
            for (int num : nums) {
                if (num <= cur)
                    count++;
            }
            if (count > cur) {
                duplicate = cur;
                high = cur - 1;
            } else {
                low = cur + 1;
            }
        }
        return duplicate;
    }

    public int[] findErrorNums(int[] nums) {
        nums = Arrays.copyOf(nums, nums.length);
        int dup = -1, missing = 1;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int idx = Math.abs(n) - 1;
            if (nums[idx] < 0) {
                dup = Math.abs(idx) + 1;

            } else

                nums[idx] *= -1;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0)
                missing = i + 1;
        }
        return new int[]{dup, missing};
    }
}
