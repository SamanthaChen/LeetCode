package Solutions;

import java.util.HashMap;
import java.util.HashSet;

public class S3LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args){
		String s = "dvdf";
		System.out.println( lengthOfLongestSubstring(s));
	}
    //思路1，用一个set（没有考虑重复的元素可能出现在中间导致失败）
    //思路2，用一个map，存储最后一次发现该字母的地方
    public static int lengthOfLongestSubstring(String s) {
        if(s.length()<=1) return s.length();
        HashMap<Character, Integer>  map = new HashMap<Character, Integer> ();
        int res = 0;
        for(int left = 0, right = 0; right< s.length(); right++){
            char a = s.charAt(right);
            if(map.containsKey(a)){
                left = Math.max(left, map.get(a)+1);
            }
            map.put(a,right);
            res = Math.max(res, right-left+1);
        }
        return res;
    }

}
