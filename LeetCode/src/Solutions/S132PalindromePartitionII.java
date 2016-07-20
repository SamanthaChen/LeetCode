package Solutions;

import java.util.List;

public class S132PalindromePartitionII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aaabaa";
//		System.out.println(isPalindrome(s));

		System.out.println(minCut(s));
	}
    //思路1：
    // 判断回文用一个矩阵dp[i][j] .回文的转移方程是： dp[i][j] =true -->( (j-i<=1) || dp[i+1][j-1]==true) && s.charAt(i)==s.charAt(j) 
    // 而最小割用一个一维数组cut[i]表示，cut[i]表示从i到len的最小割，起始值是len-1-j。转移方程是：
    //     cut[i] = min(cut[i],cut[j+1]+1) && dp[i][j]==true 也就是i~j是回文，所以i~j切一次就好 j~len-1是cut[j+1]
    //     因此cut[0]应该就是最小值，但是需要从后面规划到前面
    // cut的两个特殊情况：1、起始值cut[i]=len-1-i 2、当j=len-1时候，由于i-j是回文，则cut[i]应该是0
    
    public static int minCut(String s) {
        if(s==null || s.length()<=1) return 0;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int[] cut = new int[len];
        //初始化
        for(int i = 0; i<len; i++)
            cut[i] = len-1-i;
        //dp
        for(int i = len-1; i>=0; i--){
            for(int j = i; j<len; j++){
                //假设i-j是回文
                if( (j-i<=1 || dp[i+1][j-1]==true) && s.charAt(i)==s.charAt(j)){
                    dp[i][j]=true;
//                    cut[i] = Math.min(cut[i],cut[j+1]+1);
                    //因为i到j是回文，所以j=len-1时候cut[i]=0
                    if(j==len-1) cut[i]=0;
                    else cut[i]=Math.min(cut[i],cut[j+1]+1);
                }
            }
        }
        return cut[0];
    }
}
