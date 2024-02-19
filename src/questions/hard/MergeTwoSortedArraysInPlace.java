package questions.hard;

import java.util.Arrays;

public class MergeTwoSortedArraysInPlace {
    public static void main(String[] args) {
        MergeTwoSortedArraysInPlace m = new MergeTwoSortedArraysInPlace();
        m.merge(new int[]{1, 3, 5, 7}, new int[]{0, 2, 6, 8, 9});
    }

    public void merge(int[] arr1, int[] arr2) {
        if (arr1.length > arr2.length)
            merge(arr2, arr1);
        int m = arr1.length - 1;
        int n = 0;
        while (m >= 0 && n < arr2.length && arr1[m] > arr2[n]) {
            int temp = arr1[m];
            arr1[m] = arr2[n];
            arr2[n] = temp;
            m--;
            n++;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}

