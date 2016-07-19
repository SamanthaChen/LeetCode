package Solutions;

public class S5LongestpalidromicSubstring {


    private static int lo;
    private static int maxlen;//相当于全局变量？
    
    public static  String longestPalindrome(String s) {
        int n = s.length();
	    if(n<2) return s;
	    for(int i = 0; i < n; i++){
	        helper(s,i,i);
	        helper(s,i,i+1);
	     
	    }
	    return s.substring(lo,lo+maxlen);
   }
   
   public static void helper(String s, int begin, int end){
       while(begin>=0 && end < s.length() && s.charAt(begin) == s.charAt(end)){
           begin--;
           end++;
       }
       if(maxlen<end-begin-1){
           maxlen = end-begin-1;
           lo = begin+1;
       }
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "dabcba";
		System.out.println(longestPalindrome(s));
	}
   
}
