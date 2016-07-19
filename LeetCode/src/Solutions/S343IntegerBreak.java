package Solutions;

public class S343IntegerBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(integerBreak(3));
	}
    public static int integerBreak(int n) {
        //分成尽可能多的3乘积会最大，如果不限于整数的话，分成尽可能多的e=2.718...会最大
        //不能拆大于4 的因子，其中 4=2*2 
        if( n ==  1) return 0;
        if( n == 2 ) return 1;
        if( n == 3 ) return 2;
        
        int res = 1;
        while(n > 4){
            res = res * 3;
            n = n-3;
        }
        res = res * n;

        return res;
            
        
        
    }
}
