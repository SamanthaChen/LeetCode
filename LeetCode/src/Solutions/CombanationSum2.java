package Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombanationSum2 {

	public static void main(String[] args) {
		int[] nums = {10, 1, 2, 7, 6, 1, 5};
		int target = 8;
		List<List<Integer>> res = combinationSum2(nums, target);
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
    public static List<List<Integer>> combinationSum2(int[] nums, int target) {
		
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	Arrays.sort(nums);
    	backtrack(nums,target,res,new ArrayList<Integer>(), 0);
    	
		return res;
        
    }
    public static void backtrack(int[] nums,int remain, List<List<Integer>> res,List<Integer> list, int start) {
    	if(remain<0) return;
    	else if(remain == 0){
    		res.add(new ArrayList<Integer>(list));
    	}else{
    		for(int i=start;i<nums.length;i++){
    			//筛掉重复的
    			if(i>start && nums[i]==nums[i-1])continue;
    			list.add(nums[i]);
    			backtrack(nums,remain-nums[i],res,list,i+1);
    			list.remove(list.size()-1);
    		}
    	}
    
    }

}
