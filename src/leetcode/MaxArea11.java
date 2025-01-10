package leetcode;

public class MaxArea11 {
    public static void main(String[] args) {
        MaxArea11 mx = new MaxArea11();
        int out;
        out = mx.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(out);

        out = mx.maxArea(new int[]{1, 1});
        System.out.println(out);

    }

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            int a = Math.min(height[right], height[left]) * (right - left);
            max = Math.max(max, a);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

}
