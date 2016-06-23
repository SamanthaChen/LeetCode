package Solutions;

public class S204CountPrimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	  public int countPrimes(int n) {
	        //第一种思想：遍历,计算n*power(n, 0.5) 次
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
	    
	    //第二种思想：每次记录素数的倍数为非素数，计算素数个数
	    int count = 0;
	    boolean[] notPrime = new boolean[n];
	    for(int i = 2; i < n ; i++){
	        if(notPrime[i] == false) count++;
	        for(int j = 2; i*j <n ;j++) notPrime[i*j] = true;
	    }
	    return count;
	    }

}
