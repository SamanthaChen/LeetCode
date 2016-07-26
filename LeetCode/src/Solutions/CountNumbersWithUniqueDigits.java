package Solutions;

public class CountNumbersWithUniqueDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countNumbersWithUniqueDigits(3));
	}
    public static int countNumbersWithUniqueDigits(int n) {
        // 分析：f(n)是长度为n的函数：
        // f(1)=10 (0~9)
        // f(2)=f(1)*9 =9*9(十位从（0~9）个数里面选1个，十位就只剩下（10-1）个)
        // f(3)=f(2)*8=9*9*8 (两位数从f(2)选，第三个数就只有(10-2)8种选择
        // ...
        // f(9)=f(8)*2
        // f(10)=f(9)*1
        // f(11)=0=f(12)=f(13)=...
        // res = f(1)+...+f(n)
        if(n<1) return 1;
        
        int res = 10;
        int uniqueNum = 9;
        int fn = 9;
        while( --n > 0 && uniqueNum > 0){
           fn =  fn * (uniqueNum);
           uniqueNum--;
           res += fn;
        }
        return res;
        
    }

}
