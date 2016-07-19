package Solutions;

public class S73SetMatrixZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //思路1：一边遍历一边置为0会影响后面的判断，所以用额外空间记录一下
    //用一个m+n数组记录(2ms 26%)
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if(matrix==null || m<=0 ) return;
        int n = matrix[0].length;
        boolean[] pos = new boolean[m+n];
        //第一遍遍历，记录0的位置
        for(int i = 0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]==0){
                    pos[i]=true;
                    pos[j+m]=true;
                }
            }
        }
        //第二遍遍历，置为0
        for(int i = 0; i<m; i++){
            for(int j=0; j<n; j++){
                if(pos[i]==true || pos[m+j]==true) matrix[i][j]=0;
            }
        }
    }

}
