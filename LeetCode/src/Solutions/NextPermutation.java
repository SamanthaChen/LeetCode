package Solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NextPermutation {

	public static void main(String[] args) {
		
		int[] nums = {1,3,2};
		
		for(int i : nums) 
			System.out.print(i+" ");
		System.out.println("");
		nextPermutation(nums);
		for(int i : nums) 
			System.out.print(i+" ");

	}
	//思路，从后面开始找第一个a[i]<a[i+1]的位置，
	//将a[i]和后面第一个比它大的互相交换
	//将 i+1~n进行翻转（因为没有交换之前他们应该是降序排的）
    //边界情况 321-> 123
    public static void nextPermutation(int[] nums) {
    	if(nums.length<=1) return;
    	//第一个升序的位置是i-1
    	int i;
    	for(i=nums.length-1;i>0;i--){
    		if(nums[i-1]<nums[i]){
    			break;
    		}
    	}
    	//如果搜完了都是降序排的，全部翻转
    	if(i==0) 
    		reverse(nums,0,nums.length-1);
    	else{
    		//找到第一个大于nums[i]的数
    		int j;
    		for(j=nums.length-1 ; j>i ;j-- ){
    			if(nums[i-1]<nums[j]) break;
    		}
    		//交换两个数
    		int tmp = nums[i-1];
    		nums[i-1] = nums[j];
    		nums[j] = tmp;
    		//后面的进行翻转
    		reverse(nums,i,nums.length-1);
    		
    	}
    }
   
    public static void reverse(int[] nums,int from, int to){
    	while(from<to){
    		int tmp = nums[from];
    		nums[from] = nums[to];
    		nums[to] = tmp;
    		from++;
    		to--;
    	}
    }

}
