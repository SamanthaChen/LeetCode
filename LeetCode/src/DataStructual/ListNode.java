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
		ListNode n =this;
		String s = "";
		  while(n!=null){
			  s += n.val+"->";
			  n=n.next;
		  }
		return s;
	}


	//根据数组生成链表
	public ListNode (int[] nums){
		ListNode root = this;
		ListNode old = root;
		for(int i =0; i<nums.length;i++){
			ListNode n = new ListNode(nums[i]);
			root.next = n;
			root = root.next;
		}
		this.next = old.next;
		
	}
	//根据数组生成链表
	public static ListNode  Array2List(int[] nums){
		ListNode root = new ListNode(0);
		ListNode old = root;
		for(int i =0; i<nums.length;i++){
			ListNode n = new ListNode(nums[i]);
			root.next = n;
			root = root.next;
		}
		return old.next;
		
	}

	//打印单链表的方法
	public void print(){
		ListNode n =this;
		  while(n!=null){
			  System.out.print(n.val+"->");
			  n=n.next;
		  }
		  System.out.println("");
//		  System.out.println(this.toString());
	}

}
