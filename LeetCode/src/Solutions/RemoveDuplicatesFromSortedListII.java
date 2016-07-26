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
	 * ˼·���������ź������������ظ���������������
	 * **/
    public static ListNode deleteDuplicates(ListNode head) {
    	if(head==null || head.next==null) return head;
    	ListNode newhead = new ListNode(0);
    	newhead.next = head;
    	ListNode pre = newhead;
    	while(head!=null){
    		//��head�ͺ���һ������ȣ�headָ����ƣ�preָ�벻��
    		while(head.next!=null && head.val == head.next.val){
    			head = head.next;
    		}
    		if(pre.next==head){//�������
    			pre = head;
    		}else{//���ظ�Ԫ�ص������ֱ��ָ����һ�����ظ�������
    			pre.next = head.next;
    		}
    		head = head.next;
    	}
		return newhead.next;
        
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
