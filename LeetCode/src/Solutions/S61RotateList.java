package Solutions;

import DataStructual.ListNode;

public class S61RotateList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,5};
		ListNode l = Array2List(nums);
		ListNode res = rotateRight(l,5);
		if(res!=null) res.print();
		else System.out.println("null");

	}
	/*思路：1、计算链表长度，保存原来的tail
	 * 2、运行到len-k的地方断开，保存后面的头部posthead
	 * 3、tail接到原来的head，返回posthead
	 * 需要遍历两次
	 * **/
    public static ListNode rotateRight(ListNode head, int k) {
    	if(head==null || head.next==null || k<=0) return head;
    	//计算list长度
    	ListNode fakehead = new ListNode(0);
    	fakehead.next = head;
    	ListNode tail = fakehead;
    	int len = 0;
    	while(tail.next!=null){
    		tail = tail.next;
    		len++;
    	}
    	//寻找新的头
    	int count = len-k%len;
    	if(count<=0) return head;
    	//还是从一个多出来的头部开始考虑不然会空
    	head = fakehead;
    	while(count>0){
    		head = head.next;
    		count--;
    	}
    	//连接后面部分
    	tail.next = fakehead.next;
    	fakehead.next = head.next;
    	head.next = null;
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
