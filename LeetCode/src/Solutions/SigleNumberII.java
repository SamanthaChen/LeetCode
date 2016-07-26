package Solutions;

public class SigleNumberII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,2,3,1,2,2};
		System.out.println(singleNumber(nums));
//		System.out.println(2&1);
//		System.out.println(1&1);
	}
    public static int singleNumber(int[] nums) {
        //思路1：一个32位的数组O(1)?空间，最后再对3取余，生下来的就是出现不到三次的(出现两次和出现一次结果一样吗)
        //时间应该是O(32*n)=O(n)
//        int[] digits = new int[32];
//        for(int i = 0; i < 32; i++){
//            for(int j = 0; j < nums.length; j++){
//                digits[i] += (nums[j]>>i) & 1;
//            }
//        }
//        int res = 0;
//        for(int i = 0; i < 32 ; i++){
//        	int digit = digits[i]%3 > 0 ? 1 : 0;//防止出现2次的情况
//            res +=   digit << i;
//        }
//        
//        return res;
    	  int one = 0, two = 0;  
    	  int n = nums.length;
    	  for (int i = 0; i < n; i++){  
    	        two |= nums[i] & one;//two 积累值  
    	        one ^= nums[i];//one不断求反  
    	        int t = one & two;//第三次的时候one和two都保留了该位的值  
    	        one &= ~t;//清零出现三次的该位的值  
    	        two &= ~t;  
    	  }  
    	  return one;  
    }
}
