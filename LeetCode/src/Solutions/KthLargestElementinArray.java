package Solutions;

public class KthLargestElementinArray {

	public static void main(String[] args) {
		int[] nums = {1,2};
		System.out.println(findKthLargest(nums,1));
	}
	/*
	 * 思路1：用快排
	 * 网址https://discuss.leetcode.com/topic/14597/solution-explained 说明了先随机化数组
	 * 会保证O(n)
	 * **/
	
	//下面这个写的太多了，换一个简练的
    public static int findKthLargest1(int[] nums, int k) {
        return helper(nums,0,nums.length-1,nums.length-k);//因为数组从0开始
    }
    public static int helper(int[] nums,int low, int high, int k){
    	//迭代终止条件
    	int pivotloc = partition(nums,low,high);
    	if(pivotloc==k) 
    		return nums[pivotloc];
    	else if(k<pivotloc){
    		return helper(nums,low,pivotloc-1,k);
    	}else if(k>pivotloc){
    		return helper(nums,pivotloc+1,high,k);
    	}
    	return 0;
    }
    public static int partition(int[] nums, int low, int high){
    	int pivot = nums[low];
    	while(low<high){
    		while(low<high && nums[high]>=pivot) high--;
    		nums[low]=nums[high];
    		while(low<high && nums[low]<=pivot) low++;
    		nums[high] =nums[low];
    	}
    	nums[low]=pivot;
    	return low;
    }
    
    public static int findKthLargest(int[] nums, int k) {
    	k = nums.length-k;
    	int low = 0;
    	int high = nums.length-1;
    	while(low < high){
        	int pivotloc = partition(nums,low,high);
        	if(pivotloc==k) 
        		break;
        	else if(k<pivotloc){
        		high = pivotloc-1;
        	}else if(k>pivotloc){
        		low = pivotloc+1;
        	}
    	}
    	return nums[k];//注意这里当然不能nums[low]
    }
}
