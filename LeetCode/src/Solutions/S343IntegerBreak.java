package Solutions;

public class S343IntegerBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(integerBreak(3));
	}
    public static int integerBreak(int n) {
        //�ֳɾ����ܶ��3�˻��������������������Ļ����ֳɾ����ܶ��e=2.718...�����
        //���ܲ����4 �����ӣ����� 4=2*2 
        if( n ==  1) return 0;
        if( n == 2 ) return 1;
        if( n == 3 ) return 2;
        
        int res = 1;
        while(n > 4){
            res = res * 3;
            n = n-3;
        }
        res = res * n;

        return res;
            
        
        
    }
}
