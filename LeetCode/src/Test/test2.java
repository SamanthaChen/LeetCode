package Test;

import java.util.Scanner;

import DataStructual.ListNode;

public class test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		 String input = "1 fish 2 fish red fish blue fish";
	    int[] nums = {1,2,3,4,5,6,7,8,9,10};
	  
	    ListNode l1 = new ListNode(nums);
	   
	    l1.print();
	}

	//根据数组生成链表
	public static ListNode  Creat(int[] nums){
		ListNode root = new ListNode(0);
		ListNode old = root;
		for(int i =0; i<nums.length;i++){
			ListNode n = new ListNode(nums[i]);
			root.next = n;
			root = root.next;
		}
		return old.next;
	}

}
