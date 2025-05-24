package leetcode.array.oned.hard;

import java.util.Arrays;

public class Candy135 {
    public static void main(String[] args) {
        Candy135 c = new Candy135();
        System.out.println(c.candy(new int[]{1, 0, 2}));
        System.out.println(c.countCandies(new int[]{1, 0, 2}));
        System.out.println(c.candy(new int[]{1, 2, 2}));
        System.out.println(c.countCandies(new int[]{1, 2, 2}));
        System.out.println(c.candyM(new int[]{1, 2, 2}));
    }

    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 0)
            return 0;
        int[] right2left = new int[n];
        int[] left2right = new int[n];
        int count = 0;
        Arrays.fill(right2left, 1);
        Arrays.fill(left2right, 1);
        for (int i = 1; i < n; i++) {
            left2right[i] = ratings[i] > ratings[i - 1] ? left2right[i - 1] + 1 : left2right[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            right2left[i] = ratings[i] > ratings[i + 1] ? right2left[i + 1] + 1 : right2left[i];
        }
        for (int i = 0; i < n; i++) {
            count += Math.max(right2left[i], left2right[i]);
        }
        return count;
    }

    public int countCandies(int[] ratings) {
        int n = ratings.length;
        if (n == 0)
            return 0;
        int[] candies = new int[n];
        int count;
        Arrays.fill(candies, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        count = candies[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);

            }
            count += candies[i];
        }
        return count;
    }

    public int candyM(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        int sum = candies[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
            sum += candies[i];
        }
        return sum;
    }

}
