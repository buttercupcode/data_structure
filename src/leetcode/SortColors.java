package leetcode;

import java.util.stream.IntStream;

public class SortColors {
    public static void main(String[] args) {
    SortColors s = new SortColors();
    int[] ints = new int[]{2,0,2,1,1,0};
    s.sortColors(ints);
        for (int i : ints) {
            System.out.println(i);
        }
    }

    public void sortColors(int[] nums) {
        int left =0, right= nums.length-1;
        int i =0;
        while(i<=right){
            if(nums[i]==0){
                swap(nums,i, left);
                left++;
            }
            if(nums[i]==2){
                swap(nums, i,right);
                right--;
                i--;
            }
            i++;
        }
    }

    public void swap (int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i]= nums[j];
        nums[j]= tmp;
    }
}
