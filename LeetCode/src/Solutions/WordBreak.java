package Solutions;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "leetcodeonlinejudge";
		String[] d= {"leet","code","online","judge"};
		Set<String> dict = new HashSet<String>();
		Collections.addAll(dict, d);
		
//		System.out.println(dict.contains(a));
		System.out.println(wordBreak(s,dict));
		
	}
    //˼·1����� 2^n - 1 ���Ӽ�
    //˼·2����̬�滮
    public static boolean wordBreak(String s, Set<String> wordDict) {

    	boolean[] f = new boolean[s.length()+1];
    	f[0] = true;
    	for(int i=1; i <= s.length(); i++){//�ַ�����λ��
    		for(int j=0; j < i; j++){
    			String sub = s.substring(j,i);
    			if(f[j] && wordDict.contains(sub)){
    				f[i]=true;
    				break;
    			}
    		}
    	}
        return f[s.length()];
    }

}
