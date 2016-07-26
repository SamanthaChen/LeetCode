package Solutions;

public class isPowerofTwo {
	   public boolean isPowerOfTwo(int n) {
	        //循环的方法（19.36%）
	        // if( n<1 ) return false;//边界条件别忘记
	        // while( n%2 == 0) n /= 2;
	        // return (n>0 && n == 1);
	        
	        //利用int最大数的方法
	        // return ( n>0 && (n==1 || Math.pow(2,32)%n == 0)) ;
	        
	        //2的幂说明换为二进制只有一位是1,若为偶数，n按位与n-1是0，否则是1（19.36%）
	        if(n<1) return false;
	        return (n & (n-1)) == 0 ? true:false;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
