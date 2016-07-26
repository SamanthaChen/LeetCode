package Solutions;

import DataStructual.ListNode;

public class RemoveDuplicatesFromSortedListII {


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,2,2,2,2,2,2,2};
		ListNode l = Array2List(nums);
		ListNode res = deleteDuplicates(l);
		if(res!=null) res.print();
		else System.out.println("null");
		
	}
	/*
	 * 思路：由于是排好序的链表，因此重复的数字是连续的
	 * **/
    public static ListNode deleteDuplicates(ListNode head) {
    	if(head==null || head.next==null) return head;
    	ListNode newhead = new ListNode(0);
    	newhead.next = head;
    	ListNode pre = newhead;
    	while(head!=null){
    		//当head和后面一个数相等，head指针后移，pre指针不变
    		while(head.next!=null && head.val == head.next.val){
    			head = head.next;
    		}
    		if(pre.next==head){//正常情况
    			pre = head;
    		}else{//有重复元素的情况，直接指到第一个不重复的数字
    			pre.next = head.next;
    		}
    		head = head.next;
    	}
		return newhead.next;
        
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

}
