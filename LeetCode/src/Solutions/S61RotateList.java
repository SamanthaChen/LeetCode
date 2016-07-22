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
	/*˼·��1�����������ȣ�����ԭ����tail
	 * 2�����е�len-k�ĵط��Ͽ�����������ͷ��posthead
	 * 3��tail�ӵ�ԭ����head������posthead
	 * ��Ҫ��������
	 * **/
    public static ListNode rotateRight(ListNode head, int k) {
    	if(head==null || head.next==null || k<=0) return head;
    	//����list����
    	ListNode fakehead = new ListNode(0);
    	fakehead.next = head;
    	ListNode tail = fakehead;
    	int len = 0;
    	while(tail.next!=null){
    		tail = tail.next;
    		len++;
    	}
    	//Ѱ���µ�ͷ
    	int count = len-k%len;
    	if(count<=0) return head;
    	//���Ǵ�һ���������ͷ����ʼ���ǲ�Ȼ���
    	head = fakehead;
    	while(count>0){
    		head = head.next;
    		count--;
    	}
    	//���Ӻ��沿��
    	tail.next = fakehead.next;
    	fakehead.next = head.next;
    	head.next = null;
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
