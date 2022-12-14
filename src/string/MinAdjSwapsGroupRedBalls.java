package string;

import java.util.ArrayList;
import java.util.List;

public class MinAdjSwapsGroupRedBalls {
    public static void main(String[] args) {
        MinAdjSwapsGroupRedBalls mn = new MinAdjSwapsGroupRedBalls();
        System.out.println(mn.minSwaps("WWRWWWRWR"));
    }

    public int minSwaps(String s) {
        List<Integer> positions = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R')
                positions.add(i);
        }
        if (positions.size() == 0)
            return count;
        int median = positions.size() / 2;
        for (int i = 0; i < positions.size(); i++) {
            if (i != median)
                count += Math.abs(positions.get(i) - positions.get(median)) - 1;//-Math.abs(median-i);

        }
        return count;
    }
}
