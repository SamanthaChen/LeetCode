package Solutions;

public class BestTimetoBuyamdSellStockII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int maxProfit(int[] prices) {
        //����˼·��ֻҪ��һ���ǰһ����������һ���ܻ�������
        
        int ans = 0;
        for(int i = 0; i < prices.length-1 ; i++){
            if(prices[i+1]>prices[i]) ans += prices[i+1] - prices[i];
        }
        return ans;
    }

}
