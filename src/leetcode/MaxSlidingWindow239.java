package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxSlidingWindow239 {
    public static void main(String[] args) {
        MaxSlidingWindow239 m = new MaxSlidingWindow239();
       int[] k =  m.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
        System.out.println(k);
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int numsLength = nums.length;
        int[] result = new int[numsLength - k + 1]; // Array to store the max values for each window
        Deque<Integer> deque = new ArrayDeque<>(); // Double-ended queue to maintain the max element indices

        for (int i = 0, j = 0; i < numsLength; ++i) {
            // Remove the indices of elements from the deque that are out of the current window
            if (!deque.isEmpty() && i - k + 1 > deque.peekFirst()) {
                deque.pollFirst();
            }

            // Remove indices of elements from the deque that are less than
            // the current element nums[i] since they are not useful
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            // Add current element's index to the deque
            deque.offer(i);

            // When we've hit size k, add the current max to the result
            // This corresponds to the index at the front of the deque
            if ((i >= k - 1) && !deque.isEmpty()){
                result[j++] = nums[deque.peekFirst()];
            }
        }

        // Return the populated result array containing max of each sliding window
        return result;
    }
}
