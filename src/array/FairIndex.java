package array;

public class FairIndex {
    public static void main(String[] args) {
        FairIndex fi = new FairIndex();
        System.out.println(fi.getFairIndex(new int[]{4, -1, 0, 3}, new int[]{-2, 5, 0, 3}));
    }

    public int getFairIndex(int[] a, int[] b) {
        int sumA = 0;
        int sumB = 0;
        for (int i = 0; i < a.length; i++) {
            sumA += a[i];
            sumB += b[i];
        }
        int count = 0;
        int tempA = a[0];
        int tempB = b[0];
        for (int i = 1; i < a.length; i++) {
            if (i != 1 && 2 * tempA == sumA && 2 * tempB == sumB && tempA == tempB)
                count++;
            tempA += a[i];
            tempB += b[i];
        }
        return count;
    }
}
