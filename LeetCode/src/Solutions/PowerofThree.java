package Solutions;

public class PowerofThree {
    public boolean isPowerOfThree(int n) {
        
    //循环的方法(击败73.48%)
    // if(n>1){
    //   while(n%3 == 0 ) n /= 3;//若能被3整除，则一直循环，否则  
    // }
    
    // return n==1;
    
    //递归的方法(run time error)
    // if( n == 1) return true;
    // if( n< 1) return false;
    // return n%3 == 0 ? isPowerOfThree(n/3) : false;
    
    //java中所有数字都是带符号的,没有unsigned,int在java中是固定的32bits,表示的范围为-2^31到2^31-1(2,147,483,647)
    //3^20 = 3,486,784,401 3^19=1,162,261,467(击败54%)
    return (n>0 && 1162261467%n == 0);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
