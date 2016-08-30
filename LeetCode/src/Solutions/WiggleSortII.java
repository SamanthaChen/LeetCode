package Solutions;

import java.util.Arrays;

public class WiggleSortII {

	public static void main(String[] args) {
		int[] nums = {1,2,2,1,2,1,1,1,1,2,2,2};
		wiggleSort(nums);
		for(int i:nums)System.out.print(i+" ");
		
	}
	/*
	 * 思路:存在这样一个规律
	 * i%2==1,nums[i]>nums[i-1]
	 * i%2==0 nums[i]<nums[i-1]
	 * **/
    public static void wiggleSort(int[] nums) {
    	
    	for(int i=1;i<nums.length;i++){
    		int j = i+1;
    		if(i%2==1 && nums[i]<nums[i-1]){
    			swap(nums,i,i-1);
    		}
    		if(i%2==0 && nums[i]>nums[i-1]){
    			swap(nums,i,i-1);
    		}
    	}
    	
        
    }
    public static void swap(int[] nums, int a, int b){
    	int temp=nums[a];
    	nums[a]=nums[b];
    	nums[b]=temp;
    }

}
