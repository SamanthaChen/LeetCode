package JulyAlgotithm;

import java.util.ArrayList;
import java.util.List;

/*
 * 2010年中兴面试题
	编程求解：
	输入两个整数 n 和 m，从数列1，2，3.......n 中 随意取几个数,
	使其和等于 m ,要求将其中所有的可能组合列出来。
 * */
public class SumofNumbers {

	public static void main(String[] args) {
		List<List<Integer>> res = sumofNumbers(10,10);
		for(List<Integer> l : res){
			for(int e : l){
				System.out.print(e+" ");
			}
			System.out.println("");
		}

	}
	//思路1：类似于0-1背包问题
	//递归= f(n,m) =  f(n-1,m-n) 加n
	//		或者f(n-1,m) 不加n
	public static List<List<Integer>> sumofNumbers(int n, int m){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		helper(n,m,res,new ArrayList<Integer>());
		return res;
	}
	 
	public static void helper(int n, int m, List<List<Integer>> res, List<Integer> list){
		
		//递归终止条件
		
		if(n<=0 || m<=0)
			return;
		
		
		if(m==n){
			print(list);
			System.out.print(n);
			System.out.println("");
//			res.add(new ArrayList<Integer>(list));
		}

		//加入n的
		list.add(n);
		helper(n-1,m-n,res,list);
		//不加n
		list.remove(list.size()-1);	
		helper(n-1,m,res,list);
	}
	
	public static void print(List<Integer> list){
		for(int l: list)
			System.out.print(l+" ");
	}


}