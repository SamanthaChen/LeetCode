package Solutions;

import java.util.ArrayList;
import java.util.List;

/*
 * 求硬币换零的所有可能性
 * 来自http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/

	对于整数N，找出N的所有零钱的表示。零钱可以用S={s1,s2,s3,..sm}表示，每种零钱的数量为无穷。请问有多少种找零的方法？

	例如，N = 4,S = {1,2,3}，有四种找零方式{1,1,1,1},{1,1,2},{2,2},{1,3},return 4
		N = 10,S= {2,5,3,6}，有5中找零方式{2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5} return 5;
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
		  	System.out.println("一共"+total+"种换零钱的方式");
	    	
	 }
	 public static void helper(int[] coins, int remain, int end,List<Integer> res){
		 //递归终止条件
		 if(remain==0){
			 for(int i:res)
				 System.out.print(i+" ");
			 System.out.println("");
			 total++;
		 }
		 if(remain<0 || end<0) return;
		 for(int i=end;i>=0; i--){
			 res.add(coins[i]);
			 helper(coins,remain-coins[i],i,res);//放硬币
			 res.remove(res.size()-1);//不放硬币
		 }
		 
		
	 }


}
