package questions.medium.string;

public class MaximumSwap {
    public static void main(String[] args) {
        MaximumSwap ms = new MaximumSwap();
        // System.out.println(ms.maximumSwap(2736));
        System.out.println(ms.maximumSwap2(9868));
    }

    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        int[] buckets = new int[10];
        for (int i = 0; i < digits.length; i++) {
            buckets[digits[i] - '0'] = i;
        }
        for (int i = 0; i < digits.length; i++) {
            for (int k = 9; k > digits[i] - '0'; k--) {
                if (buckets[k] > i) {
                    char tmp = digits[i];
                    digits[i] = digits[buckets[k]];
                    digits[buckets[k]] = tmp;
                    return Integer.valueOf(new String(digits));
                }
            }
        }
        return num;
    }

    public int maximumSwap2(int num) {

        char[] digits = Integer.toString(num).toCharArray();
        int[] maxIdx = new int[digits.length];
        int maxPos = digits.length - 1;
        maxIdx[maxPos] = maxPos;

        for (int i = digits.length - 2; i >= 0; i--) {
            if (digits[i] > digits[maxPos]) {
                maxPos = i;
            }
            maxIdx[i] = maxPos;
        }

        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != digits[maxIdx[i]]) {
                char tmp = digits[i];
                digits[i] = digits[maxIdx[i]];
                digits[maxIdx[i]] = tmp;
                return Integer.parseInt(String.valueOf(digits));
            }
        }
        return num;
    }
}
