package Solutions;

public class PowerofFour {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char a = 'a';
		int a2 = Character.getNumericValue(a);
		System.out.println(a2+"\t"+(a-'a'));
	}
    public boolean isPowerOfFour(int num) {
        //传统方法，除以4看余数(2ms 22.59%)
        // if(num<1) return false;//边界条件
        // while(num%4==0 ) num = num/4 ;
        // return (num>0 && num == 1);
        
        //在power of 2 中利用 num & （num-1）判断是不是2的倍数，这里需要把是2 倍数但不是4的倍数的数字去掉，4的倍数在奇数出现1
        return num>0  &&  (num & (num-1))==0 &&  (num & 0x555555)!=0 ;
        
    }
}
