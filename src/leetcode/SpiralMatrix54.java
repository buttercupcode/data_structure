package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix54 {
    public static void main(String[] args) {
        SpiralMatrix54 s = new SpiralMatrix54();
        List<Integer> integers =
                new ArrayList<>();
        //integers= s.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});

        integers = s.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});
        for (int i : integers) {
            System.out.println(i);
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0, bottom = matrix.length;
        int left = 0, right = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        while (top < bottom && left < right) {
            for (int j = left; j < right; j++) {
                res.add(matrix[top][j]);
            }
            top++;
            for (int i = top; i < bottom; i++) {
                res.add(matrix[i][right - 1]);
            }
            right--;
            if (left >= right || top >= bottom)
                break;
            for (int j = right - 1; j >= left; j--) {
                res.add(matrix[bottom - 1][j]);
            }
            bottom--;
            for (int i = bottom - 1; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left++;
        }
        return res;
    }
    /*public List<Integer> spiralOrder(int[][] matrix) {
        int row = 0, col = 1, x = 0, y = 0;
        int maxY = matrix.length-1, maxX = matrix[0].length-1, minX = 0, minY = 0, counter = 0, maxSize = (maxY + 1) * (maxX + 1);
        HashSet<String> witnessed = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        while (counter < maxSize) {
            String curr = x + "," + y;
            while (y <= maxY && !witnessed.contains(curr)) {
                counter++;
                result.add(matrix[x][y]);
                witnessed.add(curr);
                y = y==maxY? y :y + col;
                curr = x + "," + y;
            }
            row = 1;
            col = 0;
            x+=row;
            y+=col;
            curr = x + "," + y;
            while (x <= maxX && !witnessed.contains(curr)) {
                counter++;
                result.add(matrix[x][y]);
                witnessed.add(curr);
                x = x==maxX?x : x + row;
                curr = x + "," + y;
            }
            col = -1;
            row = 0;
            x+=row;
            y+=col;
            curr = x + "," + y;
            while (y >= minY && !witnessed.contains(curr)) {
                counter++;
                result.add(matrix[x][y]);
                witnessed.add(curr);
                y = y==minY? y: y + col;
                curr = x + "," + y;
            }
            col=0;
            row=-1;
            x+=row;
            y+=col;
            curr = x + "," + y;
            while (x >= minX && !witnessed.contains(curr)) {
                counter++;
                result.add(matrix[x][y]);
                witnessed.add(curr);
                x = x==minX? x: x + row;
                curr = x + "," + y;
            }
            col=1;
            row=0;
            x+=row;
            y+=col;
            curr = x + "," + y;
        }
        return result;
    }

     */

}

