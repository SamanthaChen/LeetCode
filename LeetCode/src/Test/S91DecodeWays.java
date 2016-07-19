package Test;

public class S91DecodeWays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numDecodings("10"));

	}
    public static int numDecodings(String s) {
        //˼·��:����f(i)��ʾ��0����i�������ɵ��ַ����ı����������i������һ������f(i)=f(i-1)��Ҳ�������i-1�ַ�����һ������f(i)=f(i-2)
        //����0<(i-1,i)<27 f(i)=f(i-1)+f(i-2) ,���� f(i) = f(i-1)
        //���Ǳ��뿼��һЩ����Ϊ0�����
        if(s == null || s.length()==0) return 0;
        if(s.charAt(0)=='0') return 0;
        int n = s.length();
        
        int[] f = new int[n+1];//Ϊ�˰�������=2�����
        f[0] = 1;
        f[1] = 1;
        int tmp;
        for(int i = 2; i<=n ; i++){
        	 //��鵱ǰ�ַ��ǲ���'0'  
            tmp = Integer.parseInt(s.substring(i-1,i));  
            if(tmp!=0) {              
                f[i] = f[i-1];  
            }  
            //��鵱ǰ�ַ���ǰһ���ַ������һ���Ƿ���1-26֮��  
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
