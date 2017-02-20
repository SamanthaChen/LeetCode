package Solutions;
/*
 * 这个题目是求硬币换零的最少方法，求换零钱的所有可能性是另外一个题
 * **/
import java.util.Arrays;
import java.util.Comparator;

public class CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = {1,2,5};
		int amount = 11;
		System.out.println(coinChange(coins,amount));
	}
	//动态规划 
	//dp[i]表示总和为i的硬币换法，假设conis={a,b,c,...}
	//dp[amount] = Min (dp[diff] +1, dp[amount] )
	
    public static int coinChange(int[] coins, int amount) {
    	if(amount<=0 || coins==null || coins.length==0) return 0;
    	
    	int[] dp = new int[amount+1];
    
    	for(int i=1;i<=amount;i++){
    		dp[i] = Integer.MAX_VALUE;
    		for(int coin : coins){
    			if(coin<=i && dp[i-coin]!=Integer.MAX_VALUE){//还没超出范围，可以换
    					dp[i] = Math.min(dp[i],dp[i-coin]+1);
    			}
    			//超出范围的直接考虑下一个
    		}
    	}
    	
    	return dp[amount]==Integer.MAX_VALUE ? -1 : dp[amount];
    	
    }
    
    public static void helper(int[] coins,int end,int remain,int res){
    	//递归结束条件
    	if(remain==0){
    		res++;
    	}
    	if(remain<0 || end<0){
    		return;
    	}
    	for(int i=end; i>=0; i--){
    		//用这枚硬币
    		if(coins[i]<=remain){
    			helper(coins,i,remain-coins[i],res);//不是i-1因为一枚可以用多次
    			
    		}else{//不用
    			if(i>0){
    				helper(coins,i-1,remain,res);
    			}else
    				return;
    		}
    	}
    }
}
