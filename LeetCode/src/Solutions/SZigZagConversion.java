package Solutions;

public class SZigZagConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convert("PAYPALISHIRING", 3));
	}
    public static String convert(String s, int numRows) {
        //˼·1����numRows��StringBuilder���棬����String������ (12ms 52%)
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++) sb[i] = new StringBuilder();//��ʼ��
        int len = s.length();
        int index = 0;
        while(index<len){
            //�������
            for(int i = 0; i < numRows && index < len; i++) sb[i].append(s.charAt(index++));
            //������м�Խ��ߵĲ���
            for(int j = numRows-2; j > 0 && index < len; j--) sb[j].append(s.charAt(index++));
        }
        
        //��numRows��sb�����һ��
        for(int i = 1; i < numRows; i++){
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
        
        
    }

}
