package Solutions;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

	public static void main(String[] args) {

		String res = getPermutation(8,8590);
		System.out.println(res);
		
	}
	//思路：做过nextpermutation就明白了这个字典序
	//主要思路在于将问题进行分解，分解成为子问题
	
    public String getPermutation(int n, int k) {
    	
    	//结果
    	StringBuilder sb = new StringBuilder();
    	List<Integer> nums = new ArrayList<Integer>();
    	//首先建立一个排列组合数的查找表,方便后面查找
    	int[] factorial = new int[n+1];
    	int sum = 1;
    	factorial[0] =1;
    	for(int i=1; i<=n; i++){
    		sum *= i;
    		factorial[i]=sum;
    	}
    	//再建一个数子的列表，方便后面查找
    	for(int i=1; i<=n; i++){
    		nums.add(i);
    	}
    		
        //下面开始将问题分解
    	k--;//因为问题是从0开始的
    	for(int i=1; i<=n; i++){
    		int index = k/factorial[n-i];
    		sb.append(String.valueOf(nums.get(index)));
    		nums.remove(index);
    		k -= index*factorial[n-i];
    	}
    	return String.valueOf(sb);//本来是sb.toString
    }



}
