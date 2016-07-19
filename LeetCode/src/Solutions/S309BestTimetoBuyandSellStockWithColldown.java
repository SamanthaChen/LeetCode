package Solutions;

public class S309BestTimetoBuyandSellStockWithColldown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {1,2,4,5,3,2,1};
		System.out.println(maxProfit(prices));

	}    
	public static int maxProfit(int[] prices) {
        // 解题思路：动态规划的关键是1、表示状态2、推导转移方程
        // buy[i]表示最后一个状态是buy的时候获得的最大效益
        // buy[i]=max(reset[i-1]-price,buy[i-1])
        // sell[i]=max(buy[i-1]-price,sell[i-1])
        // reset[i]=max(sell[i-1],reset[i-1])
        // 容易得到reset[i]=sell[i-1],方程可以简化
        // buy[i]=max(sell[i-2]-price,buy[i-1])
        // sell[i]=max(buy[i-1]+price,sell[i-2])
        //由于i值依赖于i-1或者i-2，因此只用O(1)空间
        int pre_sell = 0;
        int sell = 0;
        int pre_buy= 0;
        int buy = Integer.MIN_VALUE;
        for(int price : prices){
            pre_buy = buy;
            buy = Math.max(pre_sell-price,pre_buy);
            pre_sell = sell;
            sell = Math.max(pre_buy+price,pre_sell);
            
            
        }
        return sell;
    }

}
