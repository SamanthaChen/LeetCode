package Solutions;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5};
		List<List<Integer>> res = permute(nums);
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
	 * ˼·������������{1,2,3}��������{{1}}��2����������λ�ã�����һ��{1}��2����
	 * {{1,2}��{2,1}}��������3������������λ�ã�ԭ���ĳ�Աÿ����������������3
	 * 
	 * **/
    public static List<List<Integer>> permute(int[] nums) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(nums.length<1) return null;
    	List<Integer> list = new ArrayList<Integer>();
    	list.add(nums[0]);
    	res.add(list);
    	
    	for(int i=1;i<nums.length;i++){//ѭ������ʣ�µ�Ԫ��
    		List<List<Integer>> current = new ArrayList<List<Integer>>();
    		//ѭ������λ��
    		for(int j =0; j<=i;j++){
    			//�б���ÿ��Ԫ�ظ���j��
    			for(List<Integer> l : res){
    				List<Integer> newl = new ArrayList<Integer>(l);
    				newl.add(j, nums[i]);
    				current.add(newl);
    			}
    		}
    		res = current;//Ϊ�´θ�����׼��
    	}
    	
		return res;
        
    }

}
