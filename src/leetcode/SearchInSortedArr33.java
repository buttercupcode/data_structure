package leetcode;

public class SearchInSortedArr33 {
    public static void main(String[] args) {
        SearchInSortedArr33 s = new SearchInSortedArr33();
        int out = s.searchInSortedArrUnderstandableSol(new int[]{1}, 1);
        System.out.println(out);
    }

    public int searchInSortedArr(int[] nums, int target) {

        int low = 0, high = nums.length - 1, mid = (high + low) / 2;

        while (low <= high) {
            mid = (high + low) / 2;
            int comp;
            if ((target >= nums[0] && nums[mid] >= nums[0])
                    || (target < nums[0] && nums[mid] < nums[0])) {
                comp = nums[mid];
            } else {
                if (target < nums[0])
                    comp = Integer.MIN_VALUE;
                else
                    comp = Integer.MAX_VALUE;
            }
            if (target == comp) return mid;
            else if (target > comp)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
    public int searchInSortedArrUnderstandableSol(int[] nums, int target) {

        int n = nums.length;

        int low = 0, high = n-1 , minIdx = 0;

        while(low<high){
            int mid = (low+high) /2;
            if( nums[mid] > nums[high])
                low = mid +1;
            else
                high = mid;
        }
        minIdx= low;
        if( minIdx == 0){
            low = 0;
            high = n-1;
        }
        else{
            if( target>= nums[0] && target <= nums[minIdx-1]){
                low = 0;
                high = minIdx-1;
            }
            else {
                low = minIdx;
                high = n-1;
            }
        }
        while(low<= high){
            int mid = (low+high)/2;
            if( nums[mid]== target){
                return mid;
            }else if(nums[mid]<target){
                low= mid+1;
            }else{
                high=mid-1;
            }

        }
        return -1;

    }
/*


    int left = 0,right =height.length-1;
    int max=0;
    while(left<right){
        int a = Math.min(height[right],height[left])*(right-left);
        max= Math.max(max,a);
        if(height[left]<height[right]){
            left++;
        }
        else{
            right--;
        }
    }
    return max;

 */

}
