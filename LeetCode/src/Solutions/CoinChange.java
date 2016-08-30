package Solutions;
/*
 * �����Ŀ����Ӳ�һ�������ٷ���������Ǯ�����п�����������һ����
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
	//��̬�滮 
	//dp[i]��ʾ�ܺ�Ϊi��Ӳ�һ���������conis={a,b,c,...}
	//dp[amount] = Min (dp[diff] +1, dp[amount] )
	
    public static int coinChange(int[] coins, int amount) {
    	if(amount<=0 || coins==null || coins.length==0) return 0;
    	
    	int[] dp = new int[amount+1];
    
    	for(int i=1;i<=amount;i++){
    		dp[i] = Integer.MAX_VALUE;
    		for(int coin : coins){
    			if(coin<=i && dp[i-coin]!=Integer.MAX_VALUE){//��û������Χ�����Ի�
    					dp[i] = Math.min(dp[i],dp[i-coin]+1);
    			}
    			//������Χ��ֱ�ӿ�����һ��
    		}
    	}
    	
    	return dp[amount]==Integer.MAX_VALUE ? -1 : dp[amount];
    	
    }
    
    public static void helper(int[] coins,int end,int remain,int res){
    	//�ݹ��������
    	if(remain==0){
    		res++;
    	}
    	if(remain<0 || end<0){
    		return;
    	}
    	for(int i=end; i>=0; i--){
    		//����öӲ��
    		if(coins[i]<=remain){
    			helper(coins,i,remain-coins[i],res);//����i-1��Ϊһö�����ö��
    			
    		}else{//����
    			if(i>0){
    				helper(coins,i-1,remain,res);
    			}else
    				return;
    		}
    	}
    }
}
