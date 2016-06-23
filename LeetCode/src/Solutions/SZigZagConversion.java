package Solutions;

public class SZigZagConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convert("PAYPALISHIRING", 3));
	}
    public static String convert(String s, int numRows) {
        //思路1：用numRows个StringBuilder来存，按照String的索引 (12ms 52%)
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++) sb[i] = new StringBuilder();//初始化
        int len = s.length();
        int index = 0;
        while(index<len){
            //先添加列
            for(int i = 0; i < numRows && index < len; i++) sb[i].append(s.charAt(index++));
            //再添加中间对角线的部分
            for(int j = numRows-2; j > 0 && index < len; j--) sb[j].append(s.charAt(index++));
        }
        
        //将numRows个sb整理成一个
        for(int i = 1; i < numRows; i++){
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
        
        
    }

}
