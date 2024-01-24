package questions.medium;

import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] num = new int[]{1, 2, 3, 4};
        ProductExceptSelf pes = new ProductExceptSelf();
        int[] ints = pes.productExceptSelfMinMem(num);
        System.out.println(ints);

    }

    public int[] productExceptSelf(int[] num) {
        int[] left = new int[num.length];
        int[] right = new int[num.length];

        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for (int i = 1; i < num.length; i++) {
            left[i] = num[i - 1] * left[i - 1];
        }
        for (int i = num.length - 2; i >= 0; i--) {
            right[i] = num[i + 1] * right[i + 1];
        }
        for (int i = 0; i < num.length; i++) {
            num[i] = left[i] * right[i];
        }
        return num;
    }

    public int[] productExceptSelfMinMem(int[] num) {
        int right = 1;
        int[] res = new int[num.length];
        Arrays.fill(res, 1);
        for (int i = 1; i < num.length; i++) {
            res[i] = num[i - 1] * res[i - 1];
        }

        for (int i = num.length - 1; i >= 0; i--) {
            res[i] *= right;
            right *= num[i];
        }
        return res;


    }
}
