package JulyAlgotithm;
/*
 * 题目：
 * 3、找出数组中唯一的重复元素
1-1000放在含有1001个元素的数组中，只有唯一的一个元素值重复，其它均只出现一次。
 每个数组元素只能访问一次，设计一个算法，将它找出来；
 不用辅助存储空间，能否设计一个算法实现？
 * **/
import DataStructual.ListNode;

public class FindOnlyDuplicateNum {
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7,8,9,10,11,1};
		findDuplicate(nums);
		
	}
	//采用异或
	//假设不重复的N-2个数组的异或结果是B，重复的数是A
	//这个数组异或结果是A^A^B而正常的1~N-1个数异或结果是A^B
	//这两部分异或结果得到A
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
