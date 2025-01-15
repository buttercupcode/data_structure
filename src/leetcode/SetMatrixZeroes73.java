package leetcode;

import java.util.Arrays;

public class SetMatrixZeroes73 {
    public static void main(String[] args) {
        SetMatrixZeroes73 setM = new SetMatrixZeroes73();
        int[][] matrix = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setM.setZeroes(matrix);
    }

    public void setZeroes(int[][] matrix) {
        int row0 = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    if (i > 0)
                        matrix[i][0] = 0;
                    else
                        row0 = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (row0 == 0) {
            Arrays.fill(matrix[0], 0);
        }
        if (matrix[0][0] == 0) {
            for (int r = 0; r < matrix.length; r++) {
                matrix[r][0] = 0;
            }
        }
    }
}
