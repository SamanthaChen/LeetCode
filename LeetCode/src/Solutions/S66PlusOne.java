package Solutions;

public class S66PlusOne {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for(int i=len-1;i>=0;i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;//尽早返回.第一位是1的情况也包含在这里，后面不用写了
            }
            else digits[i]=0;//9+1变为0 
        }
       //说明进位已经进到第一位，否则直接就已经返回了
        int[] num = new int[len+1];
        num[0]=1;
        return num;
      
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
