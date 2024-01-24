package questions.hard;

public class TrappingRainWater {
    public static void main(String[] args) {
        TrappingRainWater trw = new TrappingRainWater();
        //trw.trap()
    }

    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int maxLeft = height[left], maxRight = height[right];
        int water = 0;
        while (left < right) {
            if (maxLeft < maxRight) {
                water += maxLeft - height[left];
                maxLeft = Math.max(maxLeft, height[++left]);
            } else {
                water += maxRight - height[right];
                maxRight = Math.max(maxRight, height[--right]);
            }


        }
        return water;
    }
}
