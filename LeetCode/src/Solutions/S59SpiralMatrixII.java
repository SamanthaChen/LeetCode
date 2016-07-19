package Solutions;

public class S59SpiralMatrixII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=5;
		int[][] matrix = generateMatrix(n);
		String s = "";
		for(int i=0; i <n ; i++){
			for(int j=0; j<n; j++){
				s += matrix[i][j]+"\t";
			}
			s += "\n";
		}
		System.out.println(s);

	}
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if(n < 1) return matrix;
        int top = 0;
        int bottom = n-1;
        int left = 0;
        int right = n-1;
        int k=1;
        while(k<=n*n){
            for(int j = left; j<=right; j++) matrix[top][j]=k++;
            top++;
            for(int i= top; i<=bottom; i++) matrix[i][right]=k++;
            right--;
            if(right<left) break;
            for(int j = right; j >= left; j--) matrix[bottom][j]=k++;
            bottom--;
            
            if(bottom<top) break;
            for(int i = bottom; i>=top; i-- ) matrix[i][left]=k++;
            left++;
        }
        return matrix;
    }

}
