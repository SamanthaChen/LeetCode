package Solutions;

public class S53MaximumSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-2,1,-3,4,-1,2,1,-5,6};
		System.out.println(maxSubArray(nums));
	}
    //˼·������a[i..j]������������У������i<=k<=j��a[i..k]һ�����ڵ���0�����˼·����һ��ǰ׺�������������У�
    //�������ӵ�������������ͼ����� ,����ǰ׺����Ϊ0
   // public int maxSubArray(int[] nums) {

   //   int leftpositive = 0;
   //   int max_sub = Integer.MIN_VALUE;
   //   for(int i = 0; i < nums.length; i++){
   //       max_sub = Math.max(leftpositive + nums[i],max_sub);
   //       leftpositive = Math.max(0,leftpositive+nums[i]);
   //   }
   //   return max_sub;
   // }
   
   //˼·2���ֲ������ȫ�����
   //��local[i + 1] = Max(local[i] + A[i], A[i]);
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
