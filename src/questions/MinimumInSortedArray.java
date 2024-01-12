package questions;

public class MinimumInSortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{11, 13, 15, 17};//{3,4,5,1,2};//new int[]{4,5,6,7,0,1,2};
        MinimumInSortedArray mins = new MinimumInSortedArray();
        int min = mins.min(arr);
        System.out.println(min);

    }

    public int min(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int left = 0, right = arr.length - 1, min = Integer.MAX_VALUE;


        while (left <= right) {

            int mid = left + (right - left) / 2;
            if ((mid > 0 && arr[mid] < arr[mid - 1]) || (mid == 0) && arr[mid] <= arr[arr.length - 1])
                return arr[mid];
            if (arr[mid] > arr[right])
                left = mid + 1;
            else
                right = mid;


        }
        return -1;

    }
}
