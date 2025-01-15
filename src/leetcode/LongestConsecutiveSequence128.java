package leetcode;

public class LongestConsecutiveSequence128 {
    public static void main(String[] args) {

    }

    public int longestConsecutive(int[] nums) {


        int maxLen = 1;
        for (Integer num : elements) {
            if (!elements.contains(num - 1)) {
                int x = num;
                while (!elements.contains(x)) {
                    x += 1;
                }
                maxLen = Math.max(maxLen, x - num);
            }
        }
        return maxLen;
    }
}
