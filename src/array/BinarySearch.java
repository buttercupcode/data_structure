package array;

public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch b = new BinarySearch();
        System.out.println(b.search(new int[]{-1,0,3,5,9,12}, 2));
        Math.sqrt(2);
}
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low=0,high=n-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]> target)
                high=mid-1;
            else
                low=mid+1;
        }
        return -1;
    }
}
