package Solutions;

public class MinimumPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{1,2},{1,1}};
		System.out.println(minPathSum(grid));
	}
	
    //��S62�������뷨��
    //f(m,n)�ǵ����(m,n)�����·������f(m,n)=min(f(m-1,n),f(m,n-1))+grid[m][n]
    
    // public int minPathSum(int[][] grid) {
    //     if(grid == null) return 0;
    //     int m = grid.length;
    //     int n = grid[0].length;
    //     int[][] f = new int[m][n];
    //     //��ʼ��һ�£�
    //     f[0][0] = grid[0][0];
    //     for(int  i = 1 ; i < m; i++) f[i][0] = f[i-1][0]+grid[i][0];
    //     for(int j = 1 ; j < n; j++) f[0][j] = f[0][j-1]+grid[0][j];
    //     //
    //     for(int i = 1 ; i < m ; i++){
    //         for(int j = 1 ; j < n; j++ ){
    //             f[i][j] = Math.min(f[i-1][j],f[i][j-1]) + grid[i][j];
    //         }
    //     }
    //     return  f[m-1][n-1];
    // }
    
    //�Ľ��棬ֻ��һ��һλ����
    public static int minPathSum(int[][] grid) {
        if(grid == null) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] f = new int[n];
        f[0] = grid[0][0];
        for(int i = 1 ; i < n ; i++)   f[i] = f[i-1]+grid[0][i]; //����ߵĳ�ʼ����
        for(int i = 1 ; i < m ; i++){
            f[0] += grid[i][0]; //������ĳ�ʼ����
            for(int j = 1 ; j < n; j++ ){
                f[j] = Math.min(f[j-1],f[j]) + grid[i][j];
            }
        }
        return f[n-1];
        
    }

}
