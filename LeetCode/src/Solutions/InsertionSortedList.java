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
	 * ��������
	 * 
	 * **/
	 public static ListNode insertionSortList(ListNode head){
		if(head==null || head.next==null) return head;
		//˼·��Ϊ�˱�֤ÿ�ζ����뵽��ȷλ�ã�ÿ��Ѱ�Ҳ���λ�ö���ͷ��ʼ�Ұ�
		ListNode fakehead = new ListNode(0);
		ListNode cur = head;//������Ľڵ�
		ListNode nxt = null;//���������һ���ڵ�
		ListNode pre = fakehead;//����λ��
		while(cur!=null){
			//������һ������ڵ�
			nxt = cur.next;
			//�Ҳ���λ��
			while(pre.next!=null && pre.next.val<cur.val) pre = pre.next;
			//����ڵ�
			cur.next = pre.next;
			pre.next = cur;
			cur = nxt;//cur�����ƶ�
			pre = fakehead;//������ͷ��ʼ�Ҳ���λ��
		}
		return fakehead.next;
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
