package Solutions;

public class PowerofFour {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char a = 'a';
		int a2 = Character.getNumericValue(a);
		System.out.println(a2+"\t"+(a-'a'));
	}
    public boolean isPowerOfFour(int num) {
        //��ͳ����������4������(2ms 22.59%)
        // if(num<1) return false;//�߽�����
        // while(num%4==0 ) num = num/4 ;
        // return (num>0 && num == 1);
        
        //��power of 2 ������ num & ��num-1���ж��ǲ���2�ı�����������Ҫ����2 ����������4�ı���������ȥ����4�ı�������������1
        return num>0  &&  (num & (num-1))==0 &&  (num & 0x555555)!=0 ;
        
    }
}
