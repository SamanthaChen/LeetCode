package Solutions;

public class SortColors {

	public static void main(String[] args) {
		
		int[] nums = {2,1};
		
		for(int i:nums) System.out.print(i+" ");
		System.out.println("");
		sortColors(nums);
		
		for(int i:nums) System.out.print(i+" ");
		System.out.println("");
		

	}
    public static void sortColors(int[] nums) {
        if(nums==null || nums.length==0) return;
        int left = 0;
        int current = 0;//得从0开始，考虑{0,1}
        int right = nums.length-1;
        while(current<=right){
            if(nums[current]==0){
                swap(nums,current,left);
                left++;
                current++;
            }else if(nums[current]==1){
                current++;
            }else if(nums[current]==2){
                swap(nums,current,right);
                right--;
            }
        }
    }
    public static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

}
