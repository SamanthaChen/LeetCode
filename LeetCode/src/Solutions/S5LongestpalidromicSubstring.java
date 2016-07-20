package Solutions;

public class S5LongestpalidromicSubstring {


    private static int lo;
    private static int maxlen;//�൱��ȫ�ֱ�����
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "bb";
		System.out.println(longestPalindrome(s));
	}
   
    /**
     * ��һ�ַ���������������������
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
	 * �ڶ��ַ�������̬�滮��˼��
	 * */
    //˼·1���ö�̬�滮��O(n^2)ʱ��Ϳռ�
    //ת�Ʒ����� : 
    //  dp(i,j)=1 ��ָ i��ͷj��β���Ӵ��ǻ���
    //  dp(i,j)=1 �����ǣ� dp(i+1,j-1) && s.charAt(i)==s.charAt(j)
     
//    public static String longestPalindrome(String s) {
//        //�ٽ�����
//        if(s==null || s.length()<=1) return s;
//        int len = s.length();
//        //��̬�滮�ĳ�ʼ����
//        boolean[][] dp = new boolean[len][len];
//        int maxlen = 1;
//        String longest = null;
//        for(int l=0; l<len; l++){//l���Ӵ��ĳ���
//            for(int i=0; i+l<len;i++){//i�ǿ�ʼ������
//                int j=i+l;
//                //�ж�һ���ǲ��ǻ��ģ��ǵĻ�������dp��maxlen��longest
//                //����ע�����ת�Ʒ��̵ĳ�ʼ����������dp[i][i]=0 �Լ� dp[i][i+1]=0(s.charAt(i)==s.charAt(i+1))
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
	
	
    //˼·2 �� ���������������ţ�O(n^2)ʱ���O(1)�ռ�
    //���ĵ�ѡȡ��2n-1�֣�ȷ�ϻ��Ĵ���o(n)��ʱ�� ������O((2n-1)*n)
   
     
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
    //����������ش����Ŀ�ʼ���ŵ�����Ĵ�
    public static int expandPalindrome(String s, int l, int r){
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return r-l-1;
    }


}
