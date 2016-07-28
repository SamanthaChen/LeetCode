package Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		int[] nums = {2,3,6,7};
		int target = 7;
		List<List<Integer>> res = combinationSum(nums, target);
		//lambda表达式打印列表
		res.forEach((list)->{
			System.out.print("[");
			list.forEach( (e)->{
				System.out.print(e+" ");
			});
			System.out.print("]");
			System.out.println("");
		});

	}
	/*
	 * 思路：用递归的回溯法，考虑元素的所有可能的组合，但是得考虑重复，类似于subsetII
	 * **/
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	Arrays.sort(candidates);
    	backtrack(candidates,target,res,new ArrayList<Integer>(), 0);
    	
		return res;
        
    }
    public static void backtrack(int[] nums,int target, List<List<Integer>> res,List<Integer> list, int start) {
    	
    		if(target<0) return;
    		else if(target == 0){
    			res.add(new ArrayList(list));
    		}else{
    			for(int i=start;i<nums.length;i++){
    				list.add(nums[i]);
            		backtrack(nums,target-nums[i],res,list,i);//不是i+1是因为可以有重复的元素
            		list.remove(list.size()-1);
    			}
    			
    		}
        	
    	}
    	
}
