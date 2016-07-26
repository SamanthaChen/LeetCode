package Solutions;

public class BestTimetoBuyandSellStockIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {1,2};
		System.out.println(maxProfit(prices));
	}
	   //�ⷨһ����iΪ�ֽ��߷ֱ����ǰ��ͺ����profit
    // public int maxProfit(int[] prices) {
    //     //�߽����
    //  int n = prices.length;
    //     if(n<2) return 0;
    //     int[] pre_profit = new int[n];
    //     int[] post_profit = new int[n];
        
    //     //��ǰ����
    //     int min_price = prices[0];
    //     for(int i = 1 ; i < n; i++){
    //         min_price = Math.min(min_price, prices[i]);
    //         pre_profit[i] = Math.max(pre_profit[i-1], prices[i]-min_price);
    //     }
    //     //�Ӻ���ǰ
    //     int max_price = prices[n-1];
    //     for(int i = n-2 ; i >= 0; i--){
    //         max_price = Math.max(max_price, prices[i+1]);
    //         post_profit[i] = Math.max(post_profit[i+1], max_price-prices[i]);
    //     }
    //     //�����ּ����������
    //     int ans = 0;
    //     for(int i = 1; i < n; i++){
    //         ans = Math.max(ans, pre_profit[i]+post_profit[i]);
    //     }
    //     return ans;
    // }
    //�ⷨ2��O(1)�ռ�
    public static int maxProfit(int[] prices) {
    
        int buy1 = Integer.MIN_VALUE;
        int buy2 = Integer.MIN_VALUE;
        int sell1 = 0;
        int sell2 = 0;
        for(int price : prices){
            sell2 = Math.max(sell2, buy2+price);
            buy2 = Math.max(buy2, sell1-price);
            sell1 = Math.max(sell1, buy1+price);
            buy1 = Math.max(buy1, -price);
        }
        return sell2;
    }
}
