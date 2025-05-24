package leetcode;

public class MaximumSwap670 {
    public static void main(String[] args) {
        MaximumSwap670 m = new MaximumSwap670();
        int i = m.maximumSwap(2736);
        System.out.println(i);
    }

    public int maximumSwap(int num) {
        int maxIdx = -1, maxRight = -1;
        int leftIdx = -1, rightIdx = -1;
        char[] ch = String.valueOf(num).toCharArray();
        for (int i = ch.length - 1; i >= 0; i--) {
            if (ch[i] > maxRight) {
                maxIdx = i;
                maxRight = ch[i];
                continue;
            }
            if (ch[i] < maxRight) {
                leftIdx = i;
                rightIdx = maxIdx;
            }
        }
        if (leftIdx == -1)
            return num;

        char tmp = ch[leftIdx];
        ch[leftIdx] = ch[rightIdx];
        ch[rightIdx] = tmp;
        return Integer.parseInt(new String(ch));

    }

    // O(n^2) runtime
    public int maximumSwap1(int num) {
        String s = Integer.toString(num);
        int left = 0, right = s.length() - 1;
        char[] ch = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            left = i;
            right = s.length() - 1;
            int max = right;
            while (left < right) {
                if (ch[max] < ch[--right]) {
                    max = right;
                }

            }
            if (ch[left] < ch[max]) {
                char temp = ch[left];
                ch[left] = ch[max];
                ch[max] = temp;
                return Integer.parseInt(new String(ch));
            }

        }
        return num;
    }
}
