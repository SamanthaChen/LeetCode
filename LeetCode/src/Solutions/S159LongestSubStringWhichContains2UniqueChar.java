package Solutions;

import java.util.HashMap;

public class S159LongestSubStringWhichContains2UniqueChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ababacbaccc";//{abcbbbbcccbdddadacb��bcbbbbcccb��10}
		System.out.println(lengthOfLongestSubstringTwoDistinct(s));
	}
	//˼·��֮ǰ������ظ��Ӵ����ƣ���һ��map��Ƶ�ʣ����������Ԫ�ؼӽ����Ͱ�startָ����Ƶ�һ��Ԫ�ص�count��λ��
	public static int lengthOfLongestSubstringTwoDistinct(String s) {
		
		if(s==null || s.length()<=1 ) return s.length();
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		int start = 0;
		int res = 0;
		for(int i = 0; i<s.length(); i++){
			char a = s.charAt(i);
			//����map
			if(map.containsKey(a)){
				map.put(a, map.get(a)+1);
			}else
				map.put(a,1);
			
			if(map.size()>2) //������Ԫ�ؼӽ�������Ҫ����һ��res����star���ƣ�
				res = Math.max(res, i-start);
			
			//�Ƴ�
			while(map.size()>2){
				char c = s.charAt(start);//�Ӵ��ĵ�һ����ĸ
				int count = map.get(c);
				if(count>1){
					map.put(c,count-1);
				}else
					map.remove(c);
				start++;//ָ�����
			}
			
		}
		res = Math.max(res, s.length()-start);
		return res;
		
	}

}
