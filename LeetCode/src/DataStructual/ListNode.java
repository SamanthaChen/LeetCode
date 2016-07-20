package DataStructual;
/**
 * Definition for singly-linked list.
 * 单链表结构，为了方便属性方法都设为public
 * */

public class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int x){ val = x;}
	//
	public String toString(){
		return String.valueOf(val);
	}


	//根据数组生成链表
	public ListNode (int[] nums){
		
		ListNode root = this;
		for(int i =0; i<nums.length;i++){
			ListNode n = new ListNode(nums[i]);
			root.next = n;
			root = root.next;
		}
		
	}
	//打印单链表的方法
	public void print(){
		ListNode n =this;
		  while(n!=null){
			  System.out.print(n.val+"->");
			  n=n.next;
		  }
		  System.out.println();
	}

}
