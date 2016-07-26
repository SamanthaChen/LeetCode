package Solutions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class PermutationII {

	public static void main(String[] args) {
		int[] nums = {1,1,2};
		List<List<Integer>> res = permuteUnique(nums);
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
	 * ˼·������permutation1��˼·��������һ��set������ӽ����ظ���Ԫ��
	 * **/
    public static List<List<Integer>> permuteUnique(int[] nums) {
    	
    	Set<List<Integer>> res = new HashSet<List<Integer>>();//��set
    	if(nums.length<1) return null;
    	
    	res.add(new ArrayList<Integer>());//�Ȳ���һ���յ�
    	for(int i=0;i<nums.length;i++){
    		Set<List<Integer>> current = new HashSet<List<Integer>>();
    		for(int j=0;j<=i;j++){//��j������λ��,ԭ����ÿ��Ԫ����Ҫ����j��
    			for(List<Integer> l : res){
    				List<Integer> newl = new ArrayList<Integer>(l);
    				newl.add(j, nums[i]);
    				current.add(newl);
    			}
    		}
    		res = current;
    	}
    	//��set���list
    	return new ArrayList<List<Integer>>(res);
    }
}
