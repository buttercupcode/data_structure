package questions.easy;

public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        System.out.println(bs.search(new  int[]{-1,0,3,5,9,12},9));
    }
    public int search(int[] nums, int target) {
        int low = 0, high= nums.length-1;
        while(low<=high){
            int mid = low + (high-low) / 2;
            if(nums[mid]== target )
                return mid;
            else if(nums[mid]<target){
                low= mid+1;
            }
            else if(nums[mid]> target){
                high = mid-1;
            }
        }
        return -1;
    }
}
