package Solutions;

import DataStructual.ListNode;

public class PartitionList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,4,3,2,5,2};
		ListNode l = Array2List(nums);
		ListNode res = partition(l,3);
		res.print();
	}
	/*
	 * 思路很简单，由于链表不连续的
	 * 可以做两个head，把小于x的都放在head1
	 * 大于x的都在head2 最后再连在一起就行了
	 * **/
    public static ListNode partition(ListNode head, int x) {
    	if(head==null || head.next == null) return head;
    	ListNode smallhead = new ListNode(0);
    	ListNode bighead  =  new ListNode(0);
    	ListNode s = smallhead;
    	ListNode b = bighead;
    	//分成两堆
    	while(head!=null){
    		ListNode nxt = head.next;//保存一下，免得被修改
    		if(head.val<x){
    			smallhead.next = head;
    			smallhead = head;
    			bighead.next = null;//防止两个都指向一个节点
    		}else{
    			bighead.next = head;
    			bighead = head;
    			bighead.next = null;
    		}
    		head = nxt;
    	}
    	//再接起来
    	smallhead.next = b.next;
        return s.next;
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
