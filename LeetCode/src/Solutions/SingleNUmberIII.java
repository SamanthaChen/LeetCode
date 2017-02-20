package Solutions;

public class SingleNUmberIII {

	public static void main(String[] args) {
		int[] nums = {-1,0};
		
		int[] res=singleNumber(nums);
		for(int i:res) System.out.println(i+" ");

	}
	   public static int[] singleNumber(int[] nums) {
	        int[] ans = new int[2]; 
	        int res = 0;
	        for(int i:nums) res ^= i;//全部异或得到那两个字符异或的结果
	        //获得最低位为1的位置
	        res = res & (-res);
	        //根据res的结果将字符划分为两组 
	       
	                //异或结果是该位置是1，该位置产生分歧

	                for(int n:nums){
	                    
	                    if((n & res ) == 1){
	                        ans[0] ^= n;
	                    }else{
	                        ans[1] ^= n;
	                    }
	                }
	                
	           
	        return ans;
	    } 

}
