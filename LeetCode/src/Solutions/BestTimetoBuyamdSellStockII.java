package Solutions;

public class BestTimetoBuyamdSellStockII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int maxProfit(int[] prices) {
        //分析思路：只要后一项比前一项大，这个差距就一定能换成利润
        
        int ans = 0;
        for(int i = 0; i < prices.length-1 ; i++){
            if(prices[i+1]>prices[i]) ans += prices[i+1] - prices[i];
        }
        return ans;
    }

}
