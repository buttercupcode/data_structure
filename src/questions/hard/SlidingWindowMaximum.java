package questions.hard;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        SlidingWindowMaximum s = new SlidingWindowMaximum();
        s.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        int left =0, right=0;
        int max= Integer.MIN_VALUE;
        while(left<=right && right< nums.length){
            int i = nums[right];
            max= Math.max(max,i);
            if(right>=k-1){

            }
        }
        return null;
    }
}
