package Solutions;

public class S72EditDistance {
	public static void main(String[] args){
		String w1 = "abcde";
		String w2 = "abc";
		System.out.println(minDistance(w1,w2));
	}
	/*
	 * 思路：
	 * 
	 * **/
    public static int minDistance(String word1, String word2) {
    	int len1 = word1.length();
    	int len2 = word2.length();
    	int[][] dp = new int[len1+1][len2+1];
    	//初始化dp
    	for(int i = 0;i<=len1;i++){
    		dp[i][0]=i;	
    	}
    	for(int j=0;j<=len2;j++){
    		dp[0][j]=j;
    	}
    	int tmp=0;
    	for(int i=0;i<len1;i++){
    		char w1 = word1.charAt(i);
    		for(int j=0;j<len2;j++){
    			char w2 = word2.charAt(j);
    			if(w1==w2){
    				dp[i+1][j+1]=dp[i][j];	
    			}else{
    				tmp = Math.min(dp[i+1][j],dp[i][j+1]);
    				dp[i+1][j+1] = Math.min(dp[i][j],tmp)+1; 
    			}
    		}
    	}
    	
		return dp[len1][len2];
        
    }
}
