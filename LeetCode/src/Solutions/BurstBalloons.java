package Solutions;

public class BurstBalloons {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,1,5,8};
		int res = maxCoins(nums);
		System.out.println(res);

	}
    //��һ�֣����û���+��ά���鴢����ʱ����
//    public static int maxCoins(int[] iNums) {
//        //���Ʒ���dp[left][right] = max(dp[left][i], dp[left][i]+nums[left]*nums[i]*nums[right],dp[i][right])
//        // dp[left][right]��Ϊ��ǰ�����⣺��left�͵�right֮��λ�õ������maxcoi
//        //�����Ե����ϵķ���
//        int n = 1;
//        int[] nums = new int[iNums.length+2];
//        for(int a : iNums) nums[n++] = a;
//        nums[0]=nums[n++]=1;
//        int[][] memo = new int[n][n];
//        return burst(nums,memo,0,n-1);
//    }
//    public static int burst(int[] nums, int[][] memo, int left,int right){
//        if(left + 1 == right) return 0;
//        
//        if(memo[left][right]>0) return memo[left][right]; 
//        
//        int ans = 0;
//        
//        for(int i = left+1 ; i< right; ++i){
//            ans = Math.max(ans, burst(nums,memo,left,i)+nums[left]*nums[i]*nums[right]+burst(nums,memo,i,right));
//        }
//        memo[left][right] = ans;
//        return ans;
//    }
    //�ڶ��֣���̬�滮����k=right-left, k��2 ��̬�滮��n
    public static int maxCoins(int[] iNums) {
        
        int[] nums = new int[iNums.length+2];
        int n = 1;
        for(int a : iNums) nums[n++] = a;
        nums[0] = nums[n++] = 1;
        
        int[][] dp = new int[n][n];
        for(int k = 2 ; k < n ; ++k){
            for(int left = 1; left < n-k ; ++left){
                int right = left+k;
                for(int i = left+1 ; i < right; ++i){
                    dp[left][right] = Math.max(dp[left][right], dp[left][i]+nums[left]*nums[i]*nums[right]+dp[i][right]);
                }
            }
        }
        return dp[0][n-1];
    }
	//дһ����ӡ��ά����ģ�n������m����
	public static void printArray(int[][] nums, int n , int m){
		for(int i = 0 ; i < n ; i++){
			System.out.print("[");
			for(int j = 0; j < m; j++){
				System.out.print(nums[i][j]+"\t");
				
			}
			System.out.println("]");
		}
		
	}
}
