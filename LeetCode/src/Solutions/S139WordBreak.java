package Solutions;

import java.util.HashSet;
import java.util.Set;

public class S139WordBreak {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aaaaaaa";
		Set<String> dict = new HashSet<String>();
		dict.add("aaa");
		dict.add("aaaa");
//		System.out.println(dict.contains(a));
		System.out.println(wordBreak(s,dict));
		
	}
    //˼·1����� 2^n - 1 ���Ӽ�
    //˼·2��
    public static boolean wordBreak(String s, Set<String> wordDict) {

    	boolean[] f = new boolean[s.length()+1];
    	f[0] = true;
    	for(int i=1; i <= s.length(); i++){//�ַ�����λ��
    		for(int j=0; j < i; j++){
    			if(f[j] && wordDict.contains(s.substring(j, i))){
    				f[i]=true;
    				break;
    			}
    		}
    	}
        return f[s.length()];
    }

}
