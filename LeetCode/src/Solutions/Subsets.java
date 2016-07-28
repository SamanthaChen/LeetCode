package Solutions;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {
		int[] nums = {1};
		List<List<Integer>> res = subsets2(nums);
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
	//思路，递归的回溯法解决
	//i从0到n-1 每次加每次从i开始依次添加后面的元素
    public static List<List<Integer>> subsets(int[] nums) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	backtrack(nums,res,new ArrayList<Integer>(),0);
		return res;
    	
    }
    public static void backtrack(int[] nums, List<List<Integer>> res, List<Integer> list ,int start){
    	//递归结束条件
    	res.add(new ArrayList<Integer>(list));//必须重新拷贝一个
    	for(int i=start;i<nums.length;i++){
    		list.add(nums[i]);
    		backtrack(nums,res,list,i+1);
    		list.remove(list.size()-1);//把出栈前的最后一个元素删掉
    	}
    }
    /*
     * 数组变成list（基本类型的数组不能用Arrays.toList）
     * **/
    public static List<Integer> array2List(int[] nums){
    	List<Integer> list = new ArrayList<Integer>();
    	for(int i:nums)list.add(i);//这里是自动装箱了，int自动变成Integer
    	return list;
    }
    /*
     * 思路2：用一个二进制位数表示第i位是否在集合中
     * **/
    public static List<List<Integer>> subsets2(int[] nums) {
    	List<List<Integer>>  res = new ArrayList<List<Integer>>(); 
    	int n = nums.length;
    	double b = Math.pow(2,n);
    	for(int i=0;i<b;i++){//一共有0~2n+1个子集
    		List<Integer> list = new ArrayList<Integer>(); 
    		for(int j=0;j<n;j++){//循环
    			int bit = i>>j &1;
    			if(bit == 1){
    				list.add(nums[j]);
    			}
    		}
    		res.add(list);
    	}
    	return res;
    }
    
}
