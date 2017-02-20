package Solutions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class PermutationII {

	public static void main(String[] args) {
		int[] nums = {1,1,2};
		List<List<Integer>> res = permuteUnique(nums);
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
	 * 思路：利用permutation1的思路，但是用一个set来避免加进来重复的元素
	 * **/
    public static List<List<Integer>> permuteUnique(int[] nums) {
    	
    	Set<List<Integer>> res = new HashSet<List<Integer>>();//用set
    	if(nums.length<1) return null;
    	
    	res.add(new ArrayList<Integer>());//先插入一个空的
    	for(int i=0;i<nums.length;i++){
    		Set<List<Integer>> current = new HashSet<List<Integer>>();
    		for(int j=0;j<=i;j++){//有j个插入位置,原来的每个元素需要复制j次
    			for(List<Integer> l : res){
    				List<Integer> newl = new ArrayList<Integer>(l);
    				newl.add(j, nums[i]);
    				current.add(newl);
    			}
    		}
    		res = current;
    	}
    	//把set变成list
    	return new ArrayList<List<Integer>>(res);
    }
}
