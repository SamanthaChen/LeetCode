package Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetII {

	public static void main(String[] args) {
		int[] nums = {1,2,2,2};
		List<List<Integer>> res = subsetsWithDup(nums);
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
	 * 思路：将数组进行排序，然后每次添加的时候比较一下跟前面一个元素是否相同
	 * 2、看是否重复在添加
	 * **/
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	Arrays.sort(nums);//排序
    	backtrack(nums,res,new ArrayList<Integer>(), 0);
    	return res;
    }
    public static void backtrack(int[] nums, List<List<Integer>> res, ArrayList<Integer> list,int start){
    	res.add(new ArrayList<Integer>(list));
    	for(int i=start;i<nums.length;i++){
    		if(i>start && nums[i]==nums[i-1]) continue;//忽略掉重复的,就是回退的时候不往里面添加重复的
    		list.add(nums[i]);
    		backtrack(nums,res,list,i+1);
    		list.remove(list.size()-1);
    		
    	}
    }
    

}
