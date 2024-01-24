package questions.medium;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        ContainerWithMostWater cmw = new ContainerWithMostWater();
        int i = cmw.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(i);
    }

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;

        int max = Integer.MIN_VALUE;
        while (left < right) {

            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return max;
    }
}
