package Solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NextPermutation {

	public static void main(String[] args) {
		
		int[] nums = {1,3,2};
		
		for(int i : nums) 
			System.out.print(i+" ");
		System.out.println("");
		nextPermutation(nums);
		for(int i : nums) 
			System.out.print(i+" ");

	}
	//˼·���Ӻ��濪ʼ�ҵ�һ��a[i]<a[i+1]��λ�ã�
	//��a[i]�ͺ����һ��������Ļ��ཻ��
	//�� i+1~n���з�ת����Ϊû�н���֮ǰ����Ӧ���ǽ����ŵģ�
    //�߽���� 321-> 123
    public static void nextPermutation(int[] nums) {
    	if(nums.length<=1) return;
    	//��һ�������λ����i-1
    	int i;
    	for(i=nums.length-1;i>0;i--){
    		if(nums[i-1]<nums[i]){
    			break;
    		}
    	}
    	//��������˶��ǽ����ŵģ�ȫ����ת
    	if(i==0) 
    		reverse(nums,0,nums.length-1);
    	else{
    		//�ҵ���һ������nums[i]����
    		int j;
    		for(j=nums.length-1 ; j>i ;j-- ){
    			if(nums[i-1]<nums[j]) break;
    		}
    		//����������
    		int tmp = nums[i-1];
    		nums[i-1] = nums[j];
    		nums[j] = tmp;
    		//����Ľ��з�ת
    		reverse(nums,i,nums.length-1);
    		
    	}
    }
   
    public static void reverse(int[] nums,int from, int to){
    	while(from<to){
    		int tmp = nums[from];
    		nums[from] = nums[to];
    		nums[to] = tmp;
    		from++;
    		to--;
    	}
    }

}
