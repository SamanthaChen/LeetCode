package Solutions;

public class isPowerofTwo {
	   public boolean isPowerOfTwo(int n) {
	        //ѭ���ķ�����19.36%��
	        // if( n<1 ) return false;//�߽�����������
	        // while( n%2 == 0) n /= 2;
	        // return (n>0 && n == 1);
	        
	        //����int������ķ���
	        // return ( n>0 && (n==1 || Math.pow(2,32)%n == 0)) ;
	        
	        //2����˵����Ϊ������ֻ��һλ��1,��Ϊż����n��λ��n-1��0��������1��19.36%��
	        if(n<1) return false;
	        return (n & (n-1)) == 0 ? true:false;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
