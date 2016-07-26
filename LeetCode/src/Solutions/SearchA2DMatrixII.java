package Solutions;

public class SearchA2DMatrixII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean searchMatrix(int[][] matrix, int target) {
        //从右上角开始查找吧
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = n-1;
        while(i<=m-1 && j >=0){
            if(target==matrix[i][j]) return true;
            else if(target<matrix[i][j]) j--;
            else if(target>matrix[i][j]) i++;
        }
        return false;
    }

}
