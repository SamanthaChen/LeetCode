package Solutions;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5};
		List<List<Integer>> res = permute(nums);
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
	 * 思路：假设数字是{1,2,3}。首先是{{1}}，2有两个插入位置，复制一个{1}把2插入
	 * {{1,2}，{2,1}}。接着是3，有三个插入位置，原来的成员每个复制两个，插入3
	 * 
	 * **/
    public static List<List<Integer>> permute(int[] nums) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(nums.length<1) return null;
    	List<Integer> list = new ArrayList<Integer>();
    	list.add(nums[0]);
    	res.add(list);
    	
    	for(int i=1;i<nums.length;i++){//循环数组剩下的元素
    		List<List<Integer>> current = new ArrayList<List<Integer>>();
    		//循环插入位置
    		for(int j =0; j<=i;j++){
    			//列表中每个元素复制j次
    			for(List<Integer> l : res){
    				List<Integer> newl = new ArrayList<Integer>(l);
    				newl.add(j, nums[i]);
    				current.add(newl);
    			}
    		}
    		res = current;//为下次复制做准备
    	}
    	
		return res;
        
    }

}
