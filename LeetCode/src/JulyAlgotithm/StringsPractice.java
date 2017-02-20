package JulyAlgotithm;

public class StringsPractice {

	public static void main(String[] args) {
		String s = "abaccdeffdb";//输出应该是b
//		System.out.println(firstSingleChar(s));
	}
	/*
	 * 找到第一个只出现一次的字符
	 * (看到有的说百度的要求不用for while 循环，怎么实现？)
	 * 思路：用hashmap（或者两个数组，一个记录字符位置，一个记录出现次数）
	 * **/
	public char firstSingleChar(String s){
		int[] pos = new int[26];//记录位置的
		int[] frequncy = new int[26];//记录频率的
		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			frequncy[c-'a'] ++;
			if(pos[c-'a']<= i) pos[c-'a']= i;//记录第一次出现的位置
		}
		int index = Integer.MAX_VALUE;
		char c = 'a';
		for(int i=0;i<26;i++){
			if(frequncy[i]==1 && pos[i]<index){
				index = pos[i];
				c = (char) (i+'a');
			}
		}
		return c;
	}
}
