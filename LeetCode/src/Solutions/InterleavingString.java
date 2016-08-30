package Solutions;

public class InterleavingString {

	public static void main(String[] args) {
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		System.out.println(isInterleave(s1,s2,s3));

	}
//	思路：动态规划
//	假设dp[i][j]表示s1[0~i-1] s2[0~j-1]都在长度为i+j-1的s3中则求dp[i][j]分为以下几种情况
//	1、s3[i+j-1]=s1[i-1] 并且 dp[i-1][j]=true，dp[i][j]=true 
//	2、s3[i+j-1]=s2[j-1] 并且 dp[i][j-1]=true，dp[i][j]=true 
	//设置两个指针走一遍n+m是错的，因为可能出现匹配s1的某个字符和忽略可能本来是匹配s2的字符的导致出错，
	//所以应该两个for循环所有可能情况都考虑一遍
    public static boolean isInterleave(String s1, String s2, String s3) {
 
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if(len1+len2!=len3) return false;
        
        boolean[][] dp = new boolean[len1+1][len2+1];
  
        for(int i=0;i<=len1;i++){
        	for(int j=0;j<=len2;j++){
        		if(i==0&&j==0) 
        			dp[i][j]=true;//认为边界是空字符串构成，true
        		else if(i==0){
        			dp[i][j] = (s3.charAt(i+j-1)==s2.charAt(j-1) && dp[i][j-1]);
        		}else if(j==0){
        			dp[i][j] = (s3.charAt(i+j-1)==s1.charAt(i-1) && dp[i-1][j]);
        		}else{//s1 和s2的字符可能都和s3的字符相等，不能只考虑一个而忽略另一个的可能性
        			dp[i][j] = (s3.charAt(i+j-1)==s2.charAt(j-1) && dp[i][j-1]) || (s3.charAt(i+j-1)==s1.charAt(i-1) && dp[i-1][j]);
        		}

        	}
        }
        
        return dp[len1][len2];
        
    }

}
