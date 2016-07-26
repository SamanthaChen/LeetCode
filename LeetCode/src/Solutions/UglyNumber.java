package Solutions;

public class UglyNumber {

    public boolean isUgly(int num) {
        //发现除了7 1,2,3,4,5,6,8,9都是ugly number
        if(num <= 0) return false;
        if(num == 1) return true;
        while(num%2 == 0) num = num/2;//能被2整除
        while(num%3 == 0) num = num/3;;//能被3整除
        while(num%5 == 0) num = num/5;//能被5整除
        //已经除完了所有可能,结果是1说明已经被2,3,5整除，否则返回假
        return num == 1;
        
        //递归
//        if(num<=0)return false;
//        if(num==1)return true;
//        if(num%2==0) return isUgly(num/2);
//        if(num%3==0) return isUgly(num/3);
//        if(num%5==0) return isUgly(num/5);
//        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
