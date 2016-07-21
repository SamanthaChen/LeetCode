package Solutions;
import DataStructual.ListNode;

public class S143ReorderList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2};
		ListNode l = Array2List(nums);
		reorderList(l);
		l.print();
		
	}
	/**
	 * 思路：1、先找到中间节点
	 * 2、把后半部分进行翻转
	 * 3、前半部分和后半部分进行连接
	 * */
	public static void reorderList(ListNode head){
		if(head == null || head.next == null) return;
		ListNode oldhead = head;
		//先将指针移动到中间 
		ListNode slower = head;
		ListNode faster = head;
//		int count = 0;//记录一下到中间有几个元素
		while(faster!=null && faster.next!=null){
			slower = slower.next;
			faster = faster.next.next;
		}
		//包括中间节点所在的位置进行翻转 
		ListNode pre = null;
		ListNode nxt;
		while(slower!=null){
			nxt = slower.next;//存后一个
			slower.next = pre;//指针翻转
			pre = slower;//存前一个
			slower = nxt;//后移
		}
		//将两部分结合起来
		ListNode evenhead = pre;
		ListNode evennxt;
		while(head.next!=null && evenhead.next!=null){
			nxt = head.next;
			evennxt = evenhead.next;
			head.next = evenhead;
			evenhead.next = nxt;
			head = nxt;
			evenhead = evennxt;
		}
		head =  oldhead;
		
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
