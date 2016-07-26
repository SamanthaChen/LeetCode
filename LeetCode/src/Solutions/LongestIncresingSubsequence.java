package Solutions;

public class LongestIncresingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,3,6,7,9,4,10,5,6};
		int res = lengthOfLIS(a);
		System.out.println(res);
	}
    //��һ�ֽⷨ����� O(n*n)
    //dp[i]����a[i]��β���LIS
    //״̬����dp[i]=max{dp[j]+1} 1=< j < i <n ���� a[i]<a[j]��С��ʼ��̬�滮�Ϳ���
	  public static int lengthOfLIS(int[] a) {
	        if(a == null || a.length == 0) return 0;
	        int n = a.length;
	        int[] dp =  new int[n];
	        dp[0]=1;
	        int maxlis = 1;
	        for(int i = 1; i<n ;i++){//
	            dp[i]=1;
	            for(int j = 0; j<i ; j++){
	                if(a[i]>a[j]){
	                    if(dp[i]<dp[j]+1) dp[i] = dp[j]+1;//�洢���ֵ
	                }
	            }
	            if(dp[i]>maxlis) maxlis=dp[i];
	        }
	        return maxlis;
	    }
    public static void printA(int[] a){
    	for(int i = 0; i < a.length;i++) System.out.print(a[i]+"\t");
    	System.out.println("");
    	
    }

}
