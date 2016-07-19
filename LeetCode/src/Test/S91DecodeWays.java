package Test;

public class S91DecodeWays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numDecodings("10"));

	}
    public static int numDecodings(String s) {
        //思路是:假设f(i)表示从0到第i个数构成的字符串的编码次数。则i可能是一个个体f(i)=f(i-1)，也可能与第i-1字符构成一个编码f(i)=f(i-2)
        //则若0<(i-1,i)<27 f(i)=f(i-1)+f(i-2) ,否则 f(i) = f(i-1)
        //但是必须考虑一些可能为0的情况
        if(s == null || s.length()==0) return 0;
        if(s.charAt(0)=='0') return 0;
        int n = s.length();
        
        int[] f = new int[n+1];//为了包括进来=2的情况
        f[0] = 1;
        f[1] = 1;
        int tmp;
        for(int i = 2; i<=n ; i++){
        	 //检查当前字符是不是'0'  
            tmp = Integer.parseInt(s.substring(i-1,i));  
            if(tmp!=0) {              
                f[i] = f[i-1];  
            }  
            //检查当前字符和前一个字符组合在一起是否在1-26之间  
            if(s.charAt(i-2)!='0') {  
                tmp = Integer.parseInt(s.substring(i-2,i));  
                if(tmp>0&&tmp<=26) {  
                   f[i] += f[i-2];  
                }  
            }  
        }
        return f[n];
        
        
    }
}
