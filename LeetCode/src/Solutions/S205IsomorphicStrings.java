package Solutions;

import java.util.HashMap;

public class S205IsomorphicStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isIsomorphic("paper","title") ? "T" : "F" );
	}
    public static boolean isIsomorphic(String s, String t) {
        //用string的replace功能，算作弊吗？
        HashMap<Character,Character> map = new HashMap<Character,Character>();
        int[] visited = new int[26];//储存是否访问过
        for(int i = 0; i < s.length(); i++){
            char tt = t.charAt(i);
            char ss = s.charAt(i);
            if(!map.containsKey(tt) && visited[tt -'a'] == 0){
                map.put(tt,ss);
                t=t.replace(tt,ss);
                visited[ss-'a'] = 1;//访问过了
            }
        }
        return (t.equals(s));
    }
}
