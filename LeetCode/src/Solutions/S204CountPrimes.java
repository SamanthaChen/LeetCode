package Solutions;

public class S204CountPrimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	  public int countPrimes(int n) {
	        //��һ��˼�룺����,����n*power(n, 0.5) ��
	    //     int count = 0;
	    //     for( int i = 2; i<n; i++){
	    //         if(isPrime(i)) count++;
	    //     }
	    //     return count;
	    // }
	    // public boolean isPrime(int num){
	    //     if( num <= 1 ) return false;
	    //     for (int i = 2; i*i <=num; i++){
	    //         if( num%i == 0 ) return false;
	    //     }
	    //     return true;
	    // }
	    
	    //�ڶ���˼�룺ÿ�μ�¼�����ı���Ϊ��������������������
	    int count = 0;
	    boolean[] notPrime = new boolean[n];
	    for(int i = 2; i < n ; i++){
	        if(notPrime[i] == false) count++;
	        for(int j = 2; i*j <n ;j++) notPrime[i*j] = true;
	    }
	    return count;
	    }

}
