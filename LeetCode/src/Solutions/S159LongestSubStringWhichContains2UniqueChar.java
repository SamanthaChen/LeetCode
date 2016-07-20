package Solutions;

import java.util.HashMap;

public class S159LongestSubStringWhichContains2UniqueChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ababacbaccc";//{abcbbbbcccbdddadacb，bcbbbbcccb，10}
		System.out.println(lengthOfLongestSubstringTwoDistinct(s));
	}
	//思路跟之前的最长不重复子串类似，用一个map存频率，如果第三个元素加进来就把start指针后移第一个元素的count个位置
	public static int lengthOfLongestSubstringTwoDistinct(String s) {
		
		if(s==null || s.length()<=1 ) return s.length();
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		int start = 0;
		int res = 0;
		for(int i = 0; i<s.length(); i++){
			char a = s.charAt(i);
			//更新map
			if(map.containsKey(a)){
				map.put(a, map.get(a)+1);
			}else
				map.put(a,1);
			
			if(map.size()>2) //第三个元素加进来，需要更新一下res，把star右移，
				res = Math.max(res, i-start);
			
			//移除
			while(map.size()>2){
				char c = s.charAt(start);//子串的第一个字母
				int count = map.get(c);
				if(count>1){
					map.put(c,count-1);
				}else
					map.remove(c);
				start++;//指针后移
			}
			
		}
		res = Math.max(res, s.length()-start);
		return res;
		
	}

}
