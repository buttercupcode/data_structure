package questions;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        RotateArray ra = new RotateArray();
        int[] original = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        //int[] arr = ra.gcdMethod(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 2);
        //int[] arr = ra.gcdMethod(new int[]{1,2,3}, 2);

       int [] arr = ra.rotate(original, 2);
        System.out.println(Arrays.toString(arr));
    }

    public int[] tempSpace(int[] arr, int k) {
        int n = arr.length;
        ;
        k = k % n;

        int[] tempArray = new int[n - k];
        if (n - k >= 0) System.arraycopy(arr, 0, tempArray, 0, n - k);
        for (int i = 0; i < k; i++) {
            arr[i] = arr[n - k + i];
        }
        for (int i = 0; i < n - k; i++) {
            arr[i + k] = tempArray[i];
        }
        return arr;
    }

    public int[] gcdMethod(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        int gcd = gcd(n, k);
        for (int i = 0; i < gcd; i++) {
            int temp = arr[i];
            int j = i;
            while (true) {
                int d = j + k;
                if (d >= n)
                    d = d - n;

                if (d == i)
                    break;

                arr[j] = arr[d];
                j = d;
            }
            arr[j] = temp;
        }
        return arr;
    }

    int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }


    public int[] rotate(int[] nums, int k) {
        k%=nums.length;
       reverse(nums,0,nums.length-1);
       reverse(nums,0,k-1);
       reverse(nums,k,nums.length-1);
        return nums;
    }

    public void reverse(int[] nums, int start, int end) {
        while(start<=end){
            int temp = nums[start];
            nums[start]= nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}
