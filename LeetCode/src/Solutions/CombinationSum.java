package Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		int[] nums = {2,3,6,7};
		int target = 7;
		List<List<Integer>> res = combinationSum(nums, target);
		//lambda���ʽ��ӡ�б�
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
	 * ˼·���õݹ�Ļ��ݷ�������Ԫ�ص����п��ܵ���ϣ����ǵÿ����ظ���������subsetII
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
            		backtrack(nums,target-nums[i],res,list,i);//����i+1����Ϊ�������ظ���Ԫ��
            		list.remove(list.size()-1);
    			}
    			
    		}
        	
    	}
    	
}
