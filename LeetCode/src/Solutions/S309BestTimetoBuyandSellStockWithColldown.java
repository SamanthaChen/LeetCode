package Solutions;

public class S309BestTimetoBuyandSellStockWithColldown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {1,2,4,5,3,2,1};
		System.out.println(maxProfit(prices));

	}    
	public static int maxProfit(int[] prices) {
        // ����˼·����̬�滮�Ĺؼ���1����ʾ״̬2���Ƶ�ת�Ʒ���
        // buy[i]��ʾ���һ��״̬��buy��ʱ���õ����Ч��
        // buy[i]=max(reset[i-1]-price,buy[i-1])
        // sell[i]=max(buy[i-1]-price,sell[i-1])
        // reset[i]=max(sell[i-1],reset[i-1])
        // ���׵õ�reset[i]=sell[i-1],���̿��Լ�
        // buy[i]=max(sell[i-2]-price,buy[i-1])
        // sell[i]=max(buy[i-1]+price,sell[i-2])
        //����iֵ������i-1����i-2�����ֻ��O(1)�ռ�
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
