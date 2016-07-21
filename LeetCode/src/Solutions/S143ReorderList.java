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
	 * ˼·��1�����ҵ��м�ڵ�
	 * 2���Ѻ�벿�ֽ��з�ת
	 * 3��ǰ�벿�ֺͺ�벿�ֽ�������
	 * */
	public static void reorderList(ListNode head){
		if(head == null || head.next == null) return;
		ListNode oldhead = head;
		//�Ƚ�ָ���ƶ����м� 
		ListNode slower = head;
		ListNode faster = head;
//		int count = 0;//��¼һ�µ��м��м���Ԫ��
		while(faster!=null && faster.next!=null){
			slower = slower.next;
			faster = faster.next.next;
		}
		//�����м�ڵ����ڵ�λ�ý��з�ת 
		ListNode pre = null;
		ListNode nxt;
		while(slower!=null){
			nxt = slower.next;//���һ��
			slower.next = pre;//ָ�뷭ת
			pre = slower;//��ǰһ��
			slower = nxt;//����
		}
		//�������ֽ������
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
