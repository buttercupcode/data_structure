package leetcode;

import java.util.Arrays;

public class ProductExceptSelf238 {
    public static void main(String[] args) {
        ProductExceptSelf238 exceptSelf238 = new ProductExceptSelf238();
        int[] p = exceptSelf238.productExceptSelf2(new int[]{1, 2, 3, 4});
    }

    public int[] productExceptSelf(int[] nums) {
        int[] pre = new int[nums.length];
        int[] suff = new int[nums.length];

        pre[0] = 1;
        suff[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            suff[i] = suff[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            pre[i] = pre[i] * suff[i];
        }

        return pre;
    }

    public int[] productExceptSelf2(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, 1);

        int curr = 1;
        for (int i = 0; i < nums.length; i++) {
            ans[i] *= curr;
            curr *= nums[i];

        }
        curr = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] *= curr;
            curr *= nums[i];
        }

        return ans;
    }
}
