package Solutions;

public class Numberof1Bits {
    public int hammingWeight(int n) {
        
        //�Լ�д�ģ�ֻ����5%
        // String str = Integer.toBinaryString(n);
        // int res = 0;
        // for(int i = 0; i < str.length() ; i++  ){
        //     if(str.charAt(i) == '1') res++;
        // }
        // return res;
        
        //���� ��λ �� ��λ�� ��˼�� ,����13%
        int res = 0;
        while(n != 0){
            res = res + (n & 1); 
            n = n >>> 1; //�޷�������һλ
        }
        return res;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
