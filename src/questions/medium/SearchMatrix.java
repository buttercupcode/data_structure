package questions.medium;

public class SearchMatrix {
    public static void main(String[] args) {
        SearchMatrix sm = new SearchMatrix();
        //int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int[][] matrix = new int[][]{{1, 3, 5}};
        boolean b = sm.searchMatrix(matrix, 1);
        System.out.println(b);
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        int row = matrix.length;
        int col = matrix[0].length;
        int low = 0, high = row - 1, mid = low;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (target < matrix[mid][0]) {
                high = mid - 1;
            } else if (target > matrix[mid][col - 1])
                low = mid + 1;
            else if (target >= matrix[mid][0] && target <= matrix[mid][col - 1]) {
                break;
            }
        }
        if (low > high)
            return false;
        int i = 0, j = col - 1;
        while (i <= j) {
            int n = i + (j - i) / 2;
            if (target == matrix[mid][n])
                return true;
            else if (target > matrix[mid][n]) {
                i = n + 1;
            } else if (target < matrix[mid][n]) {
                j = n - 1;
            }
        }
        return false;

    }
    // findRow
    //public boolean findRow(int[][] matrix, int )

}
