package JulyAlgotithm;
/*
 * LeetCode #6
 * 
 * **/
public class RegularExpressionMatching {

	public static void main(String[] args) {
//		System.out.println(isMatch("","J*Smi.."));
	}
	/*
	 * 这个解法是认为 *和其前面的字符匹配一个到多个字符
	 * **/
	//注意 s==null 与 s =="" 不同，为了保险还是用s.length==0
	public static boolean isMatch2(String s, String p){
		if(s.length()==0 && p.length()==0) return true;
		if(p.length()==1 && p.charAt(0)=='*') return true;
		
		if(s.length()==0 && p.length()!=0|| (s.length()!=0 && p.length()==0) )
				return false;
		if(p.charAt(0)!='*'){
			if(s.charAt(0)==p.charAt(0) || p.charAt(0)=='.'){
				return isMatch(s.substring(1),p.substring(1));
			}else{
				return false;
			}
		}else{
			if(s.charAt(0)!= p.charAt(1)){
				return isMatch(s.substring(1),p);
			}else{
				return isMatch(s.substring(1),p.substring(2));
			}
		}
		
		
		
	}
	
	/*
	 * 这个解法才是LeetCode上面题的解答
	 * 1.*和前面的字符需要两个成组比较
	 * **/
	public static boolean isMatch(String s, String p){
		if(p.isEmpty()) 
			return s.isEmpty();
		
		//p的长度为1，肯定不用考虑*
		if(p.length()==1 || p.charAt(1)!='*'){
			if(s.isEmpty() ||  p.charAt(0)!='.' || p.charAt(0)!=s.charAt(0)){
				return false;
			}else{
				return isMatch(s.substring(1),p.substring(1));
			}
		}
		
		//长度>=2 考虑p.charAt(1)==*
		//把s中等于p.charAt(0)的匹配完
		while(!s.isEmpty() && (p.charAt(0)=='.' || p.charAt(0)==s.charAt(0))){
			if(isMatch(s,p.substring(2)))//*可能匹配空
					return true;
			s = s.substring(1);
		}
		return isMatch(s,p.substring(2));
	}

		
	

}
