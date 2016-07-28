package Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {
		int[] nums = {1,2,3};
		List<List<Integer>> res = permute2(nums);
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
	 * 思路1：假设数字是{1,2,3}。首先是{{1}}，2有两个插入位置，复制一个{1}把2插入
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
    /*
     * 思路2:递归对两个元素进行交换
     * **/
    public static List<List<Integer>> permute2(int[] nums){
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	helper(nums,0,res);
    	return res;

    }
    /*递归
     * **/
    public static void helper(int nums[],int start,List<List<Integer>> res ){
    	//递归结束条件
    	if(start>= nums.length){
    		System.out.println("递归结束：");
    		res.add(array2List(nums));
    	}
    	for(int i=start;i<nums.length;i++){
    		swap(start,i,nums);
//    		String s1 = array2List(nums).toString();
//    		System.out.println("前：");
//    		System.out.println("S:" +start+" i:"+ i+" nums:"+ s1);
    		helper(nums,start+1,res);
//    		String s2 = array2List(nums).toString();
//    		System.out.println("后：");
//    		System.out.println("S:" +start+" i:"+ i+" nums:"+ s2);
    		swap(start,i,nums);
    	}
    }
    /*
     * 交换
     * **/
    public static void swap(int i, int j, int[] a){
    	int temp = a[i];
    	a[i] = a[j];
    	a[j] = temp;
    }
    /*
     * 数组变成list（基本类型的数组不能用Arrays.toList）
     * **/
    public static List<Integer> array2List(int[] nums){
    	List<Integer> list = new ArrayList<Integer>();
    	for(int i:nums)list.add(i);//这里是自动装箱了，int自动变成Integer
    	return list;
    }

}
