package Solutions;

import DataStructual.ListNode;

public class S148SortList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,5};
		ListNode l = Array2List(nums);
		ListNode res = sortList(l);
		if(res!=null) res.print();
		else System.out.println("null");
	}
	/*
	 * �������������Ҫ��O(nlog(n))ʱ���O(1)�ռ�
	 * **/
    public static ListNode sortList(ListNode head) {
    	
		return head;
    }
	/*
	 * ����������������
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
