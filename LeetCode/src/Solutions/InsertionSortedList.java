package Solutions;

import DataStructual.ListNode;

public class InsertionSortedList {

	public static void main(String[] args) {
		int[] nums = {5,4,3,2,1};
		ListNode l = Array2List(nums);
		l.print();
		ListNode res = insertionSortList(l);
		if(res!=null) res.print();
		else System.out.println("null");

	}
	/*
	 * 插入排序
	 * 
	 * **/
	 public static ListNode insertionSortList(ListNode head){
		if(head==null || head.next==null) return head;
		//思路，为了保证每次都插入到正确位置，每次寻找插入位置都从头开始找吧
		ListNode fakehead = new ListNode(0);
		ListNode cur = head;//待插入的节点
		ListNode nxt = null;//待插入的下一个节点
		ListNode pre = fakehead;//插入位置
		while(cur!=null){
			//保存下一个插入节点
			nxt = cur.next;
			//找插入位置
			while(pre.next!=null && pre.next.val<cur.val) pre = pre.next;
			//插入节点
			cur.next = pre.next;
			pre.next = cur;
			cur = nxt;//cur往后移动
			pre = fakehead;//继续从头开始找插入位置
		}
		return fakehead.next;
	}
	
	/*
	 * 根据数组生成链表
	 * **/
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

}
