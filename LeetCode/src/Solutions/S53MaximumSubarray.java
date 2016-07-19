package Solutions;

public class S53MaximumSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-2,1,-3,4,-1,2,1,-5,6};
		System.out.println(maxSubArray(nums));
	}
    //思路：假设a[i..j]是最长公共子序列，则对于i<=k<=j，a[i..k]一定大于等于0，因此思路是找一个前缀和是正数的序列，
    //如果后面加的数能增大收益就继续加 ,否则将前缀重置为0
   // public int maxSubArray(int[] nums) {

   //   int leftpositive = 0;
   //   int max_sub = Integer.MIN_VALUE;
   //   for(int i = 0; i < nums.length; i++){
   //       max_sub = Math.max(leftpositive + nums[i],max_sub);
   //       leftpositive = Math.max(0,leftpositive+nums[i]);
   //   }
   //   return max_sub;
   // }
   
   //思路2：局部最大与全局最大
   //即local[i + 1] = Max(local[i] + A[i], A[i]);
   //global[i + 1] = Max(local[i + 1], global[i])
   public static int maxSubArray(int[] nums){
       int local = nums[0];
       int global =  nums[0];
       for(int i=1; i<nums.length; i++){
           local = Math.max(local + nums[i], nums[i]);
           global = Math.max(global,local);
       }
       return global;
       
   }
}
