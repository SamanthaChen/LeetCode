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
	 * ˼·�ܼ򵥣���������������
	 * ����������head����С��x�Ķ�����head1
	 * ����x�Ķ���head2 ���������һ�������
	 * **/
    public static ListNode partition(ListNode head, int x) {
    	if(head==null || head.next == null) return head;
    	ListNode smallhead = new ListNode(0);
    	ListNode bighead  =  new ListNode(0);
    	ListNode s = smallhead;
    	ListNode b = bighead;
    	//�ֳ�����
    	while(head!=null){
    		ListNode nxt = head.next;//����һ�£���ñ��޸�
    		if(head.val<x){
    			smallhead.next = head;
    			smallhead = head;
    			bighead.next = null;//��ֹ������ָ��һ���ڵ�
    		}else{
    			bighead.next = head;
    			bighead = head;
    			bighead.next = null;
    		}
    		head = nxt;
    	}
    	//�ٽ�����
    	smallhead.next = b.next;
        return s.next;
    }
	//����������������
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
