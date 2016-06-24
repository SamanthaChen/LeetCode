package Solutions;

public class S8StringtoInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(myAtoi("123456"));
	}
    public static int myAtoi(String str) {
        
        //需要考虑的四个问题：
        //1、字符串前面的空格 2、非法输入 3、正负号 4、溢出
        //空串
        if(str.length()<1) return 0;
        int sign = 1;
        int res = 0;
        int index = 0;
        //处理字符前面的空格
        while(str.charAt(index)==' ' && index < str.length()) index++;
        //处理正负号
        if(str.charAt(index)=='+' || str.charAt(index)=='-'){
            sign = str.charAt(index)=='+' ? 1 : -1 ;
            index++;
        }
        //转换字符
        while( index < str.length()) {
            int digit = str.charAt(index)-'0';
            if(digit<0 || digit > 9) break;//处理非法字符
            
            //处理溢出，(res*10可能会溢出，以及digit超过0-9的范围)
            if(Integer.MAX_VALUE/10 < res || Integer.MAX_VALUE/10 == res && Integer.MAX_VALUE %10 < digit)
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            
            res = res*10+digit;
            index++;
        }
        res = res*sign;

        return res;
    }

}
