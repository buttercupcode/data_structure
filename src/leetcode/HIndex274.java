package leetcode;

public class HIndex274 {
    public static void main(String[] args) {
        HIndex274 hi = new HIndex274();
        int[] input = new int[]{3, 0, 6, 1, 5};

        int output = hi.hIndex(input);
        System.out.println(output);

        input = new int[]{1, 3, 1};
        output = hi.hIndex(input);
        System.out.println(output);
    }

    public int hIndex(int[] citations) {
        int[] arr = new int[citations.length + 1];

        int h = 0;
        int n = citations.length;
        for (int citation : citations) {
            if (citation >= n)
                citation = n;
            arr[citation]++;
        }
        int i = arr.length - 1;
        while (i >= 0) {
            h = h + arr[i];
            if (h >= i)
                return i;
            i--;
        }
        return i;
    }
}
