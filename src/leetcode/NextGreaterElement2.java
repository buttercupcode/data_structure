package leetcode;

public class NextGreaterElement2 {
    public static void main(String[] args) {
        NextGreaterElement2 n = new NextGreaterElement2();
        n.nextGreaterElements(new int[]{1,2,3,4,3});

    }
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int max= nums[0];
        left[0]=-1;
        right[n-1]= -1;
        for( int i = 1; i< n; i++){
            left[i]= Math.max(max,left[i-1]);
            max= nums[i];
        }
        max= nums[n-1];
        for( int i = n-2; i>=0; i--){
            right[i]= Math.max(max,right[i+1]);
            max= nums[i];
        }
        for( int i =0; i< n ; i++){
            right[i]= Math.max( left[i], right[i]);
        }

        for( int i = 0; i < n; i++){
            right[i]= nums[i]< right[i]? right[i]:-1;
        }

        return right;
    }
}
