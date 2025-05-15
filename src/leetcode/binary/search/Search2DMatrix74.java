package leetcode.binary.search;

public class Search2DMatrix74 {
    public static void main(String[] args) {
        Search2DMatrix74 s = new Search2DMatrix74();
        int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};

        System.out.println(s.searchMatrixLinear(matrix, 3));


        System.out.println(s.searchMatrixLinear(matrix,13));

        System.out.println(s.searchMatrixLinear(new int[][]{{1},{3},{5}},4));
        System.out.println(s.searchMatrixLinear(new int[][]{{-8,-7,-5,-3,-3,-1,1},{2,2,2,3,3,5,7},{8,9,11,11,13,15,17},{18,18,18,20,20,20,21},{23,24,26,26,26,27,27},{28,29,29,30,32,32,34}},-5));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high= m-1;
        while(low<=high){
            int mid = (low+high)/2;
            int[] row = matrix[mid];
            if(row[0]==target || row[n-1]==target)
                return true;
            else if(target > row[0] && target < row[n-1]){
                // run binary in this row
                int rowL = 0;
                int rowH = n-1;
                while(rowL <= rowH){
                    int rowM = (rowL+rowH)/2;
                    if(target == row[rowM])
                        return  true;
                    else if(target > row[rowM])
                        rowL=rowM+1;
                    else if(target < row[rowM])
                        rowH= rowM-1;
                }
                return false;

            } else if (target< row[0]){
                high = mid-1;
            }else if(target> row[n-1]){
                low= mid+1;
            }
        }
        return false;
    }


    public boolean searchMatrixLinear(int[][] matrix, int target){
        int m = matrix.length, n = matrix[0].length;
        int low = 0 , high = m*n-1;
        int pivotIdx,pivotElement;
        while(low<=high){
            pivotIdx= (low+high)/2;
            pivotElement = matrix[pivotIdx/n][pivotIdx%n];
            if(target== pivotElement)
                return  true;
            else if (target> pivotElement) {
                low=pivotIdx+1;


            }
            else{
                high = pivotIdx-1;
            }
        }

        return  false;
    }
}
