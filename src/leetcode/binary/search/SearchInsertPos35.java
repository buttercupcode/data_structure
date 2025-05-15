package leetcode.binary.search;

public class SearchInsertPos35 {
    public static void main(String[] args) {
        SearchInsertPos35 s = new SearchInsertPos35();
       int out ;

       System.out.println(s.searchInsert(new int[]{1,3,5,6},5));
        out =s.searchInsert(new int[]{1,3,5,6},2);
        System.out.println(out);
    }
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length-1;

        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]> target)
                high =mid-1;
            else
                low= mid+1;
        }
        return low;
    }
}
