package questions.hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        SlidingWindowMaximum s = new SlidingWindowMaximum();
        int[] ints = s.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for( int ki : ints)
            System.out.println(ki);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        int lidx=0;
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i =0; i< nums.length; i++){
            while(!queue.isEmpty() && queue.peek()<i-k+1)
                queue.poll();
            while(!queue.isEmpty() && nums[i]>nums[queue.peekLast()])
                queue.pollLast();
            queue.offer(i);
            if(i>=k-1)
                res[lidx++]= nums[queue.peek()];
        }
        return res;
    }
}
