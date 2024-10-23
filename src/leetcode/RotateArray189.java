package leetcode;

public class RotateArray189 {
    public static void main(String[] args) {
        RotateArray189 r= new RotateArray189();
        int[] test1=  new int[]{1,2,3,4,5,6,7};
        //r.rotate(test1,3);
        //r.rotate(new int[]{-1,-100,3,99},2);
        //r.rotate(new int[]{-1},2);
        r.rotate(new int[]{1,2},3);
        System.out.println(test1);
    }
    public void rotate(int[] nums, int k) {
        if(k<0)
            k=nums.length+k;
        k =  k% nums.length ;
        reverse(nums,0, nums.length-k-1);
        reverse(nums,nums.length-k, nums.length-1);
        reverse(nums,0, nums.length-1);
    }
    public void reverse(int[] nums, int start, int end){
        while(start<=end){
            int temp= nums[start];
            nums[start]= nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }

}
