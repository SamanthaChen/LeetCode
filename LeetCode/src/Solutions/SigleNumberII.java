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
        //˼·1��һ��32λ������O(1)?�ռ䣬����ٶ�3ȡ�࣬�������ľ��ǳ��ֲ������ε�(�������κͳ���һ�ν��һ����)
        //ʱ��Ӧ����O(32*n)=O(n)
//        int[] digits = new int[32];
//        for(int i = 0; i < 32; i++){
//            for(int j = 0; j < nums.length; j++){
//                digits[i] += (nums[j]>>i) & 1;
//            }
//        }
//        int res = 0;
//        for(int i = 0; i < 32 ; i++){
//        	int digit = digits[i]%3 > 0 ? 1 : 0;//��ֹ����2�ε����
//            res +=   digit << i;
//        }
//        
//        return res;
    	  int one = 0, two = 0;  
    	  int n = nums.length;
    	  for (int i = 0; i < n; i++){  
    	        two |= nums[i] & one;//two ����ֵ  
    	        one ^= nums[i];//one������  
    	        int t = one & two;//�����ε�ʱ��one��two�������˸�λ��ֵ  
    	        one &= ~t;//����������εĸ�λ��ֵ  
    	        two &= ~t;  
    	  }  
    	  return one;  
    }
}
