package Test;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

	public static void main(String[] args) {
		String s = "aab";

		List<List<String>> res = partition(s);
		//lambda输出二维list
		res.forEach((list)->{list.forEach((e)->{System.out.print(e+"\t");}); 
												System.out.println("");});
	}
	/*
	 * 思路：用回溯法，递归添加是回文的元素
	 * **/
	public  static List<List<String>> partition(String s) {
		
		List<List<String>>  res = new ArrayList<List<String>>();
		backtrack(s,res,new ArrayList<String>());
		return res;
	}
	public static void backtrack(String s, List<List<String>> res, List<String> list){
		//递归终止条件
		if(s.length()==0){
			res.add(new ArrayList<String>(list));
		}else{
			for(int i=1;i<=s.length();i++){
				String sub = s.substring(0,i);
				if(isPalidrome(sub)){
					list.add(sub);
					backtrack(s.substring(i),res,list);
					list.remove(list.size()-1);
				}
			}
		}
	}
	/*
	 * 判断是不是回文
	 * **/
	public static boolean isPalidrome(String s){
		if(s.length()==0) return false;
		int left = 0;
		int right = s.length()-1;
		while(left<right){
			if(s.charAt(left)!=s.charAt(right))
				return false;
			left++;
			right--;
		}
		return true;
	}

}
