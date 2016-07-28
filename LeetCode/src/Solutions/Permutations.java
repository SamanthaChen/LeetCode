package Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {
		int[] nums = {1,2,3};
		List<List<Integer>> res = permute2(nums);
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
	 * ˼·1������������{1,2,3}��������{{1}}��2����������λ�ã�����һ��{1}��2����
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
    /*
     * ˼·2:�ݹ������Ԫ�ؽ��н���
     * **/
    public static List<List<Integer>> permute2(int[] nums){
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	helper(nums,0,res);
    	return res;

    }
    /*�ݹ�
     * **/
    public static void helper(int nums[],int start,List<List<Integer>> res ){
    	//�ݹ��������
    	if(start>= nums.length){
    		System.out.println("�ݹ������");
    		res.add(array2List(nums));
    	}
    	for(int i=start;i<nums.length;i++){
    		swap(start,i,nums);
//    		String s1 = array2List(nums).toString();
//    		System.out.println("ǰ��");
//    		System.out.println("S:" +start+" i:"+ i+" nums:"+ s1);
    		helper(nums,start+1,res);
//    		String s2 = array2List(nums).toString();
//    		System.out.println("��");
//    		System.out.println("S:" +start+" i:"+ i+" nums:"+ s2);
    		swap(start,i,nums);
    	}
    }
    /*
     * ����
     * **/
    public static void swap(int i, int j, int[] a){
    	int temp = a[i];
    	a[i] = a[j];
    	a[j] = temp;
    }
    /*
     * ������list���������͵����鲻����Arrays.toList��
     * **/
    public static List<Integer> array2List(int[] nums){
    	List<Integer> list = new ArrayList<Integer>();
    	for(int i:nums)list.add(i);//�������Զ�װ���ˣ�int�Զ����Integer
    	return list;
    }

}
