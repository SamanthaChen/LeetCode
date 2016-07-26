package Solutions;

public class Numberof1Bits {
    public int hammingWeight(int n) {
        
        //自己写的，只击败5%
        // String str = Integer.toBinaryString(n);
        // int res = 0;
        // for(int i = 0; i < str.length() ; i++  ){
        //     if(str.charAt(i) == '1') res++;
        // }
        // return res;
        
        //利用 移位 和 按位与 的思想 ,击败13%
        int res = 0;
        while(n != 0){
            res = res + (n & 1); 
            n = n >>> 1; //无符号右移一位
        }
        return res;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
