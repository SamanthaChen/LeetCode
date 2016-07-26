package Solutions;

public class RotateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,5,6};
//		rotate(nums,1);
		reverse(nums,0,5);
		for(int i = 0; i<nums.length; i++){
			System.out.print(nums[i]+" ");
		}
	}
    public static void rotate(int[] nums, int k) {
        
        
        //思路1：开辟一个新的空间储存需要旋转的数字(1ms 13.50%)
        // int len = nums.length;
        // int step = k % len;// 考虑k可能很大的情况
        // int[] temp = new int[step];
        // for(int i = 0; i < step; i++){
        //     temp[i] = nums[len-step+i];
        // }
        // for(int j = len-1; j-step>-1; j--){
        //     nums[j] = nums[j-step];
        // }
        // for(int i = 0; i < step; i++){
        //     nums[i] = temp[i];
        // }
        
        //思路2：采用三次反转第一次[123765]第二次[4321765]第三次[5671234]
        if(nums == null && nums.length<2) return; 
        int len = nums.length;
        int step = k % len;
        reverse(nums,len-step,len-1);
        reverse(nums,0,len-step-1);
        reverse(nums,0,len-1);
    }
    
    public static void reverse(int[] nums, int n, int m){
        int temp = 0;
        while(n<m){
            temp = nums[n];
            nums[n] = nums[m];
            nums[m]=temp;
            n++;
            m--;
        }
    }

}
