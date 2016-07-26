package Solutions;

import DataStructual.ListNode;

public class SortList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {5,4,3,2,1};
		ListNode l = Array2List(nums);
		l.print();
		ListNode res = sortList(l);
		if(res!=null) res.print();
		else System.out.println("null");
	}
	/*
	 * �������������Ҫ��O(nlog(n))ʱ���O(1)�ռ�
	 * �ù鲢����ɣ��Ƚ��ʺ��������Ͻ���
	 * **/
    public static ListNode sortList(ListNode head) {
    	if(head==null || head.next==null) return head;
    	//1���ҵ��������ģ��ָ����������
    	ListNode slow = head;
    	ListNode fast = head;
    	ListNode pre = head;
    	while(fast!=null && fast.next!=null){
    		pre = slow;//�����е��ǰһ��
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	pre.next=null;//�и�������
    	//2����ǰ�������ֽ�������
    	ListNode l1 = sortList(head);
    	ListNode l2 = sortList(slow);
    	//3���������ֽ��кϲ�
    	ListNode res = mergeList(l1,l2);
    	
		return res;
    }
   
    public static ListNode mergeList(ListNode l1,ListNode l2){
    	ListNode fakehead = new ListNode(0);
    	ListNode p = fakehead;
    	while(l1!=null && l2!=null){
    		if(l1.val<=l2.val){
    			p.next=l1;
    			l1=l1.next;
    		}else{
    			p.next=l2;
    			l2=l2.next;
    		}
    		p=p.next;
    	}
    	while(l1!=null){
    		p.next=l1;
    		l1=l1.next;
    		p=p.next;
    	}
    	while(l2!=null){
    		p.next=l2;
    		l2=l2.next;
    		p=p.next;
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
