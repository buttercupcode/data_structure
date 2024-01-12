package questions;

import java.util.ArrayList;
import java.util.List;

public class KDistanceIndex {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 2, 2, 2};//{3,4,9,1,3,9,5};
        //int  key = 9, k = 1;
        int key = 2, k = 2;
        KDistanceIndex kd = new KDistanceIndex();
        // List<Integer> l = kd.findKDistantIndicesMySol(nums,key,k);
        List<Integer> m = kd.findKDistantIndicesBetterSol(nums, key, k);
        //System.out.println(l);
        System.out.println(m);
    }

    public List<Integer> findKDistantIndicesBetterSol(int[] nums, int key, int k) {
        List<Integer> list = new ArrayList<>();
        int last = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                int j = Math.max(last, i - k);
                for (; j < nums.length && j <= i + k; j++) {
                    list.add(j);
                }
                last = j;
            }

        }
        return list;
    }

    public List<Integer> findKDistantIndicesMySol(int[] nums, int key, int k) {
        int l = nums.length;
        int[] arr = new int[nums.length];
        List<Integer> list = new ArrayList<>();
        int a = 0, b = 0, c = 0;
        while (b < l) {
            if (nums[b] == key) {
                a = b;
                c = b;
                while (b - a <= k && a >= 0) {
                    arr[a] = 1;

                    a--;
                }
                while ((c - b) <= k && c < l) {
                    arr[a] = 1;
                    c++;
                }
            }
            b++;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1)
                list.add(i);
        }
        return list;
    }
}
