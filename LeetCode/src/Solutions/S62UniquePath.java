package Solutions;

public class S62UniquePath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //解法：花费O(m*n)时间
    // public int uniquePaths(int m, int n) {
    //     if(m<1 || n<1) return 0;
    //     int[][] f = new int[m][n];
    //     //第一行和第一列初始化一下
    //     for(int i=0; i< m; i++) f[i][0]=1;
    //     for(int j=0; j< n; j++) f[0][j]=1;
    //     for(int i=1; i< m; i++){
    //         for(int j=1; j< n; j++){
    //             f[i][j] = f[i-1][j] + f[i][j-1];
    //         }
    //     }
    //     return f[m-1][n-1];
    // }
    
    //简化的解法：不用二维数组，用一个一位数组,一行一行的扫进行添加
    public int uniquePaths(int m, int n){
        int[] current = new int[n];
        for(int i = 0 ; i < n ; i++ ) current[i] = 1 ;
     
        for(int i = 1; i < m ; i++){
            for(int j = 1; j < n; j++){
                current[j] += current[j-1];
            }
        }
        return current[n-1];
        
    }

}
