package Solutions;

import java.util.List;

public class S132PalindromePartitionII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aaabaa";
//		System.out.println(isPalindrome(s));

		System.out.println(minCut(s));
	}
    //˼·1��
    // �жϻ�����һ������dp[i][j] .���ĵ�ת�Ʒ����ǣ� dp[i][j] =true -->( (j-i<=1) || dp[i+1][j-1]==true) && s.charAt(i)==s.charAt(j) 
    // ����С����һ��һά����cut[i]��ʾ��cut[i]��ʾ��i��len����С���ʼֵ��len-1-j��ת�Ʒ����ǣ�
    //     cut[i] = min(cut[i],cut[j+1]+1) && dp[i][j]==true Ҳ����i~j�ǻ��ģ�����i~j��һ�ξͺ� j~len-1��cut[j+1]
    //     ���cut[0]Ӧ�þ�����Сֵ��������Ҫ�Ӻ���滮��ǰ��
    // cut���������������1����ʼֵcut[i]=len-1-i 2����j=len-1ʱ������i-j�ǻ��ģ���cut[i]Ӧ����0
    
    public static int minCut(String s) {
        if(s==null || s.length()<=1) return 0;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int[] cut = new int[len];
        //��ʼ��
        for(int i = 0; i<len; i++)
            cut[i] = len-1-i;
        //dp
        for(int i = len-1; i>=0; i--){
            for(int j = i; j<len; j++){
                //����i-j�ǻ���
                if( (j-i<=1 || dp[i+1][j-1]==true) && s.charAt(i)==s.charAt(j)){
                    dp[i][j]=true;
//                    cut[i] = Math.min(cut[i],cut[j+1]+1);
                    //��Ϊi��j�ǻ��ģ�����j=len-1ʱ��cut[i]=0
                    if(j==len-1) cut[i]=0;
                    else cut[i]=Math.min(cut[i],cut[j+1]+1);
                }
            }
        }
        return cut[0];
    }
}
