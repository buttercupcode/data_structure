package leetcode.array.oned;

import java.util.Arrays;

public class NextPermutation31 {
    public static void main(String[] args) {
        NextPermutation31 np = new NextPermutation31();
        int[] input = new int[]{1,2,4,9,8,7,6,5,3};
        np.nextPermutation(input);
        Arrays.stream(input).forEach(System.out::println);
    }
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        while(i>=0 && nums[i+1]<=nums[i]){
            i--;
        }
        if(i>=0){
            int j = nums.length-1;
            while(nums[j] <=nums[i]){
                j--;
            }
            swap(nums,i,j);
        }
        reverse(nums,i+1);
    }
    private void reverse(int[] nums, int start){
        int i = start, j = nums.length-1;
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums,int i, int j){
        int temp = nums[i];
        nums[i]= nums[j];
        nums[j]= temp;
    }
}
