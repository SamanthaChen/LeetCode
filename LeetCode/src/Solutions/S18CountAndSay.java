package Solutions;

import java.util.HashMap;
import java.util.Map;

public class S18CountAndSay {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(countAndSay(1111123));
	}
    public static String countAndSay(int n) {
        String s = n+"";
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0 ; i < s.length(); i++ ){
            if(map.containsKey(s.charAt(i)-'0')){
                map.put(s.charAt(i)-'0',map.get(s.charAt(i)-'0')+1);
            }else{
                map.put(s.charAt(i)-'0',1);
            }
        }
        String res = "";
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            String temp = entry.getValue() == 1 ?  String.valueOf(entry.getKey()) :  String.valueOf(entry.getValue())+String.valueOf(entry.getKey()) ;
            res += temp;
        }
        return res;
        
    }
}
