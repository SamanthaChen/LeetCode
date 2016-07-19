package Solutions;

public class S10RegularMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "aaa";
		String b = "a*a";
//		System.out.println(a.substring(1));
		System.out.println(isMatch(a,b));
	}
    //思路：分为两种情况(*的前面必须有字符)
    //1.第1个字符不是*,匹配第0个后直接考虑1开始的子串
    //2.第1个字符是*
    public static boolean isMatch(String s, String p) {     
    if(p.length()==0) return s.length()==0;
    //特殊情况
    if(p.length()==1){
        if(s.length()<=0) return false;
        if(p.charAt(0)!='.' && p.charAt(0)!=s.charAt(0)) return false;
        else return isMatch(s.substring(1),p.substring(1));//
    }
    //case1:第2个字符不是*
    if( p.charAt(1)!='*' ) {
    	//1.考虑p长度大于s s.length()<1 
    	
        if(s.length()<1 || (p.charAt(0)!='.' && p.charAt(0)!=s.charAt(0))) return false; 
        else
            return isMatch(s.substring(1),p.substring(1));
    } 
    //case2:第二个字符是*，但是假如第一个是.？
    else{

        //case2.1:一个字符+*也可以等于0
        if(isMatch(s,p.substring(2)) ) return true;
        //case2.2:
        int i = 0;
        while(i<s.length() && s.charAt(i)==p.charAt(0) ){
        	if(isMatch(s.substring(i+1),p.substring(2))) return true;
            i++;
        }
        return i==s.length() ? isMatch("",p.substring(2)) :  isMatch(s.substring(i),p.substring(2)) ;
        
        
    }  }

}
