package leetcode;

public class RotateImage48 {
    public static void main(String[] args) {
        RotateImage48 ri = new RotateImage48();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        ri.rotate(matrix);
        System.out.println(matrix);
    }

    public void rotate(int[][] matrix) {
        int col = matrix[0].length;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                int m1 = matrix[i][j];
                int m2 = matrix[j][i];
                matrix[i][j] = m2;
                matrix[j][i] = m1;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int m = matrix[i][j];
                int n = matrix[i][col - 1 - j];
                matrix[i][j] = n;
                matrix[i][col - 1 - j] = m;
            }
        }
    }

    public void swap(int[][] matrix, int i, int j) {

    }
}
