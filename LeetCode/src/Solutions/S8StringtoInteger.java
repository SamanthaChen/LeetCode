package Solutions;

public class S8StringtoInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(myAtoi("123456"));
	}
    public static int myAtoi(String str) {
        
        //��Ҫ���ǵ��ĸ����⣺
        //1���ַ���ǰ��Ŀո� 2���Ƿ����� 3�������� 4�����
        //�մ�
        if(str.length()<1) return 0;
        int sign = 1;
        int res = 0;
        int index = 0;
        //�����ַ�ǰ��Ŀո�
        while(str.charAt(index)==' ' && index < str.length()) index++;
        //����������
        if(str.charAt(index)=='+' || str.charAt(index)=='-'){
            sign = str.charAt(index)=='+' ? 1 : -1 ;
            index++;
        }
        //ת���ַ�
        while( index < str.length()) {
            int digit = str.charAt(index)-'0';
            if(digit<0 || digit > 9) break;//����Ƿ��ַ�
            
            //���������(res*10���ܻ�������Լ�digit����0-9�ķ�Χ)
            if(Integer.MAX_VALUE/10 < res || Integer.MAX_VALUE/10 == res && Integer.MAX_VALUE %10 < digit)
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            
            res = res*10+digit;
            index++;
        }
        res = res*sign;

        return res;
    }

}
