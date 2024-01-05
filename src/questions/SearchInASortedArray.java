package questions;

public class SearchInASortedArray {
    public static void main(String[] args) {
        SearchInASortedArray s = new SearchInASortedArray();
        int[] arr= new int[]{4,5,6,7,0,1,2};

        int search = s.search(arr, 0);
        System.out.println(search);
    }
    public int search(int[] nums, int target) {
        if(nums==null || nums.length==0 )
            return -1;
        int n = nums.length;
        int left=0, right = nums.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target)
                return mid;
            if(nums[left]<nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                }
                else
                {
                    left = mid + 1;
                }

            }
            else {
                if(target<=nums[right] && target>nums[mid]){
                    left=mid+1;
                }
                else {
                    right= mid-1;
                }
            }

        }
        return nums[left]==target?nums[left]:-1;
    }
}
