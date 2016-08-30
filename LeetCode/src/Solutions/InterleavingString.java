package Solutions;

public class InterleavingString {

	public static void main(String[] args) {
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		System.out.println(isInterleave(s1,s2,s3));

	}
//	˼·����̬�滮
//	����dp[i][j]��ʾs1[0~i-1] s2[0~j-1]���ڳ���Ϊi+j-1��s3������dp[i][j]��Ϊ���¼������
//	1��s3[i+j-1]=s1[i-1] ���� dp[i-1][j]=true��dp[i][j]=true 
//	2��s3[i+j-1]=s2[j-1] ���� dp[i][j-1]=true��dp[i][j]=true 
	//��������ָ����һ��n+m�Ǵ�ģ���Ϊ���ܳ���ƥ��s1��ĳ���ַ��ͺ��Կ��ܱ�����ƥ��s2���ַ��ĵ��³���
	//����Ӧ������forѭ�����п������������һ��
    public static boolean isInterleave(String s1, String s2, String s3) {
 
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if(len1+len2!=len3) return false;
        
        boolean[][] dp = new boolean[len1+1][len2+1];
  
        for(int i=0;i<=len1;i++){
        	for(int j=0;j<=len2;j++){
        		if(i==0&&j==0) 
        			dp[i][j]=true;//��Ϊ�߽��ǿ��ַ������ɣ�true
        		else if(i==0){
        			dp[i][j] = (s3.charAt(i+j-1)==s2.charAt(j-1) && dp[i][j-1]);
        		}else if(j==0){
        			dp[i][j] = (s3.charAt(i+j-1)==s1.charAt(i-1) && dp[i-1][j]);
        		}else{//s1 ��s2���ַ����ܶ���s3���ַ���ȣ�����ֻ����һ����������һ���Ŀ�����
        			dp[i][j] = (s3.charAt(i+j-1)==s2.charAt(j-1) && dp[i][j-1]) || (s3.charAt(i+j-1)==s1.charAt(i-1) && dp[i-1][j]);
        		}

        	}
        }
        
        return dp[len1][len2];
        
    }

}
