package JulyAlgotithm;
/*
 * ��Ŀ��
 * 3���ҳ�������Ψһ���ظ�Ԫ��
1-1000���ں���1001��Ԫ�ص������У�ֻ��Ψһ��һ��Ԫ��ֵ�ظ���������ֻ����һ�Ρ�
 ÿ������Ԫ��ֻ�ܷ���һ�Σ����һ���㷨�������ҳ�����
 ���ø����洢�ռ䣬�ܷ����һ���㷨ʵ�֣�
 * **/
import DataStructual.ListNode;

public class FindOnlyDuplicateNum {
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7,8,9,10,11,1};
		findDuplicate(nums);
		
	}
	//�������
	//���費�ظ���N-2��������������B���ظ�������A
	//��������������A^A^B��������1~N-1�����������A^B
	//��������������õ�A
	public static void findDuplicate(int[] nums){
		int res = 0;
		for(int i=0;i<nums.length;i++){
			res ^= nums[i];
		}
		for(int i =1;i<nums.length;i++){
			res ^= i;
		}
		System.out.println(res);
	}
	
}
