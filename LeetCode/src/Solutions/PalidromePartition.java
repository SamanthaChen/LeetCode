package Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalidromePartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aab";
//		System.out.println(isPalindrome(s));

		List<List<String>> res = partition(s);

		res.forEach((list)->{list.forEach((e)->{System.out.print(e+"\t");}); 
												System.out.println("");});
	}
	/*
	 * 第一种解题思想：采用深度遍历 
	 * 1、首先判断str(0,i)是不是回文，是的话加入到list里面，然后取剩下的子串递归调用。递归结束的条件是子串长度为0，然后把list加入到结果中
	 * 2、不满足回文，i++ 一直到 字符串末尾
	 * 3、全部结束以后返回结果
	 * @date = 2016.7.20
	 * **/
//	public static List<List<String>> partition(String s) {
//		
//		List<List<String>>  res = new ArrayList<List<String>>(); 
//		if(s==null || s.length()==0) return res;
//		List<String> list = new ArrayList<String>();
//		addPalindrome(s,list,res);
//		return res;
//    }
//	/**
//	 * 递归添加回文串的方法
//	 * @return 
//	 * */
//	public static void addPalindrome(String s, List<String> list, List<List<String>> res){
//		//先考虑一下停止条件:传入的字符串长度为0时候就停止了,把当前的list加入结果中
//		if(s.length()==0) res.add(new ArrayList<String>(list));
//		//递归的算法
//		int len = s.length();
//		for(int i = 1; i<=len ; i++){
//			String prestr = s.substring(0,i);
//			if(isPalindrome(prestr)){
//				list.add(prestr);
//				String poststr = s.substring(i);
//				addPalindrome(poststr,list,res);
//				//为了保证后面的list不会再继续,递归回来的时候要把后面的元素先删掉
//				list.remove(list.size()-1);
//			}
//			
//		}
//	}
//	/**
//	 * 判断是否是回文的方法
//	 * */
//	public static boolean isPalindrome(String s){
//		int i = 0;
//		int j = s.length()-1;
//		while(i<=j){
//			if(s.charAt(i)==s.charAt(j)){
//				i++;
//				j--;
//			}else
//				return false;
//		}
//		return true;
//		
//	}
	
	
 	public static List<List<String>> partition(String s) {
		int len = s.length();
		@SuppressWarnings("unchecked")
		List<List<String>>[] result = new List[len + 1];
		result[0] = new ArrayList<List<String>>();
		result[0].add(new ArrayList<String>());

		boolean[][] pair = new boolean[len][len];
		for (int i = 0; i < s.length(); i++) {
			result[i + 1] = new ArrayList<List<String>>();
			for (int left = 0; left <= i; left++) {
				if (s.charAt(left) == s.charAt(i) && (i-left <= 1 || pair[left + 1][i - 1])) {
					pair[left][i] = true;
					String str = s.substring(left, i + 1);
					for (List<String> r : result[left]) {
						List<String> ri = new ArrayList<String>(r);
						ri.add(str);
						result[i + 1].add(ri);
					}
				}
			}
		}
		return result[len];
	}
	

}
