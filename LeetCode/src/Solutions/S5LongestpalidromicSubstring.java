package Solutions;

public class S5LongestpalidromicSubstring {


    private static int lo;
    private static int maxlen;//相当于全局变量？
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "bb";
		System.out.println(longestPalindrome(s));
	}
   
    /**
     * 第一种方法：从中心向两边扩张
     * */
//    public static  String longestPalindrome(String s) {
//        int n = s.length();
//	    if(n<2) return s;
//	    for(int i = 0; i < n; i++){
//	        helper(s,i,i);
//	        helper(s,i,i+1);
//	     
//	    }
//	    return s.substring(lo,lo+maxlen);
//   }
//   
//   public static void helper(String s, int begin, int end){
//       while(begin>=0 && end < s.length() && s.charAt(begin) == s.charAt(end)){
//           begin--;
//           end++;
//       }
//       if(maxlen<end-begin-1){
//           maxlen = end-begin-1;
//           lo = begin+1;
//       }
//   }
	
	/**
	 * 第二种方法：动态规划的思想
	 * */
    //思路1：用动态规划，O(n^2)时间和空间
    //转移方程是 : 
    //  dp(i,j)=1 是指 i开头j结尾的子串是回文
    //  dp(i,j)=1 条件是： dp(i+1,j-1) && s.charAt(i)==s.charAt(j)
     
//    public static String longestPalindrome(String s) {
//        //临界条件
//        if(s==null || s.length()<=1) return s;
//        int len = s.length();
//        //动态规划的初始方程
//        boolean[][] dp = new boolean[len][len];
//        int maxlen = 1;
//        String longest = null;
//        for(int l=0; l<len; l++){//l是子串的长度
//            for(int i=0; i+l<len;i++){//i是开始的坐标
//                int j=i+l;
//                //判断一下是不是回文，是的话，更新dp、maxlen和longest
//                //这里注意加入转移方程的初始条件，就是dp[i][i]=0 以及 dp[i][i+1]=0(s.charAt(i)==s.charAt(i+1))
//                if(((j-i)<=1  || dp[i+1][j-1]==true ) && s.charAt(i)==s.charAt(j)){
//                    dp[i][j]=true;
//                    if(j-i+1>maxlen){
//                        maxlen = j-i+1;
//                        longest = s.substring(i,j+1);
//                    }
//                }
//                    
//            }
//        }
//        return longest;
//        
//    }
	
	
    //思路2 ： 从中心向两边扩张，O(n^2)时间和O(1)空间
    //中心的选取有2n-1种，确认回文串有o(n)的时间 所以是O((2n-1)*n)
   
     
    public static String longestPalindrome(String s) {
        
        if(s==null || s.length()<=1) return s;
        int start = 0;
        int end = 0;
        
        for(int i = 0; i<s.length(); i++){
            int len1 = expandPalindrome(s,i,i);
            int len2 = expandPalindrome(s,i,i+1);
            int len = Math.max(len1,len2);
            if(len>end-start+1){
                start = i-(len-1)/2;
                end = i+len/2 ;
            }
            
        }
        return s.substring(start,end+1);
        
    }
    //这个方法返回从中心开始扩张的最长回文串
    public static int expandPalindrome(String s, int l, int r){
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return r-l-1;
    }


}
