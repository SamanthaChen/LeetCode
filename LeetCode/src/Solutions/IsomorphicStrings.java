package Solutions;

import java.util.HashMap;

public class IsomorphicStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isIsomorphic("paper","title") ? "T" : "F" );
	}
    public static boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return false;
        //����hashMap
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        for(int i = 0; i<s.length(); i++){
                char a = s.charAt(i);
                char b = t.charAt(i);
                if(map.containsKey(a)){//
                    if (map.get(a)!=b) return false;
                    else continue;
                }else{
                    if(map.containsValue(b)) return false;
                    else map.put(a,b);
                }
        }
        
        //����һ������䵱Map�Ĺ��ܣ�����256λ��ASCII
//        int[] m = new int[512];//ǰ256��s�ģ���256��t��
////        for(int i = 0; i<s.length(); i++){
////            if(m[s.charAt(i)]!=m[t.charAt(i)+256]) return false;
////            m[s.charAt(i)] = m[t.charAt(i)+256] = i+1;
////        }
        
        
        return true;
    }
}
