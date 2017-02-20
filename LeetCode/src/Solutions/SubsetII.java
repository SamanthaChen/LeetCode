package Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetII {

	public static void main(String[] args) {
		int[] nums = {1,2,2,2};
		List<List<Integer>> res = subsetsWithDup(nums);
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
	 * ˼·���������������Ȼ��ÿ����ӵ�ʱ��Ƚ�һ�¸�ǰ��һ��Ԫ���Ƿ���ͬ
	 * 2�����Ƿ��ظ������
	 * **/
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	Arrays.sort(nums);//����
    	backtrack(nums,res,new ArrayList<Integer>(), 0);
    	return res;
    }
    public static void backtrack(int[] nums, List<List<Integer>> res, ArrayList<Integer> list,int start){
    	res.add(new ArrayList<Integer>(list));
    	for(int i=start;i<nums.length;i++){
    		if(i>start && nums[i]==nums[i-1]) continue;//���Ե��ظ���,���ǻ��˵�ʱ������������ظ���
    		list.add(nums[i]);
    		backtrack(nums,res,list,i+1);
    		list.remove(list.size()-1);
    		
    	}
    }
    

}
