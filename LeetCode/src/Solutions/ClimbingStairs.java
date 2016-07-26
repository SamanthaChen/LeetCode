package Solutions;

public class ClimbingStairs {
    public int climbStairs(int n) {
    //(用动态规划)
      if(n <= 0 ) return 0;
      if(n == 1) return 1;
      if(n == 2) return 2;
      int[] ways = new int[n];
      ways[0] = 1;
      ways[1] = 2;
      for(int i = 2; i <n ; i++ ){
          ways[i] = ways[i-1]+ways[i-2];
      }
      return ways[n-1];
  
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
