package Solutions;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {
		int[] nums = {1};
		List<List<Integer>> res = subsets2(nums);
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
	//˼·���ݹ�Ļ��ݷ����
	//i��0��n-1 ÿ�μ�ÿ�δ�i��ʼ������Ӻ����Ԫ��
    public static List<List<Integer>> subsets(int[] nums) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	backtrack(nums,res,new ArrayList<Integer>(),0);
		return res;
    	
    }
    public static void backtrack(int[] nums, List<List<Integer>> res, List<Integer> list ,int start){
    	//�ݹ��������
    	res.add(new ArrayList<Integer>(list));//�������¿���һ��
    	for(int i=start;i<nums.length;i++){
    		list.add(nums[i]);
    		backtrack(nums,res,list,i+1);
    		list.remove(list.size()-1);//�ѳ�ջǰ�����һ��Ԫ��ɾ��
    	}
    }
    /*
     * ������list���������͵����鲻����Arrays.toList��
     * **/
    public static List<Integer> array2List(int[] nums){
    	List<Integer> list = new ArrayList<Integer>();
    	for(int i:nums)list.add(i);//�������Զ�װ���ˣ�int�Զ����Integer
    	return list;
    }
    /*
     * ˼·2����һ��������λ����ʾ��iλ�Ƿ��ڼ�����
     * **/
    public static List<List<Integer>> subsets2(int[] nums) {
    	List<List<Integer>>  res = new ArrayList<List<Integer>>(); 
    	int n = nums.length;
    	double b = Math.pow(2,n);
    	for(int i=0;i<b;i++){//һ����0~2n+1���Ӽ�
    		List<Integer> list = new ArrayList<Integer>(); 
    		for(int j=0;j<n;j++){//ѭ��
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
