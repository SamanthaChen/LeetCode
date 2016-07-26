package Solutions;

public class uniquePathsWithObstacles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] nums = {{0,0},{1,1},{0,0}};
		int res = uniquePathsWithObstacles(nums);
		System.out.println(res);
	}
    //˼·����Unique path �Ĺ���,dp[i-1]��Ӧ��ߵĸ��ӣ�δ���µ�dp[i]��Ӧ����ĸ���
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] =1;

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n ; j++){
                if(obstacleGrid[i][j]==1) dp[j]=0;
                else {
                    if(j>0)  dp[j] += dp[j-1];
                }
            }
        }
        return dp[n-1];
        
    }
}
