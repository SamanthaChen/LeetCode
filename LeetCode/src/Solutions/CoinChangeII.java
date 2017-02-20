package Solutions;

import java.util.ArrayList;
import java.util.List;

/*
 * ��Ӳ�һ�������п�����
 * ����http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/

	��������N���ҳ�N��������Ǯ�ı�ʾ����Ǯ������S={s1,s2,s3,..sm}��ʾ��ÿ����Ǯ������Ϊ��������ж���������ķ�����

	���磬N = 4,S = {1,2,3}�����������㷽ʽ{1,1,1,1},{1,1,2},{2,2},{1,3},return 4
		N = 10,S= {2,5,3,6}����5�����㷽ʽ{2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5} return 5;
 * **/
public class CoinChangeII {

	public static void main(String[] args) {
		int[] coins = {1,2,3};
		int amount = 4;
		coinChange(coins,amount);

	}
	public static int total;
	 public static void coinChange(int[] coins, int amount){
		  	List<Integer> res = new ArrayList<Integer>();
		  	helper(coins,amount,coins.length-1, res);
		  	System.out.println("һ��"+total+"�ֻ���Ǯ�ķ�ʽ");
	    	
	 }
	 public static void helper(int[] coins, int remain, int end,List<Integer> res){
		 //�ݹ���ֹ����
		 if(remain==0){
			 for(int i:res)
				 System.out.print(i+" ");
			 System.out.println("");
			 total++;
		 }
		 if(remain<0 || end<0) return;
		 for(int i=end;i>=0; i--){
			 res.add(coins[i]);
			 helper(coins,remain-coins[i],i,res);//��Ӳ��
			 res.remove(res.size()-1);//����Ӳ��
		 }
		 
		
	 }


}
