package Solutions;

import java.util.Comparator;
import java.util.PriorityQueue;

import DataStructual.ListNode;

public class MergekSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n1 = {1,3,5,7};
		int[] n2 = {2,4,6,8};
		int[] n3 = {-6,-1,0,9};
		ListNode l1 = Array2List(n1);
		ListNode l2 = Array2List(n2);
		ListNode l3 = Array2List(n3);
		ListNode[] ll = {l1,l2,l3};
		ListNode res = mergeKLists(ll);
		res.print();
		
  
	}
	/*
	 * ˼·�� �����ȶ���ʵ��
	 * **/
    public static ListNode mergeKLists(ListNode[] lists) {
    	if(lists == null || lists.length == 0) return null;
    	//�����ڲ��� ,�Լ�ʵ�ֵ�����ʽ�ǰ�������ͷ��value��������
    	PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
    		public int compare(ListNode l1, ListNode l2){
    			return Integer.compare(l1.val, l2.val);
    		}
    	});
    	//��list[] ����ÿ�������ͷ����������棬����ÿ��ȡֵ��ʱ�򶼻���ȡС�ĳ���
    	for(ListNode l : lists) {//�ǳ�ֵ��ע������������list�����п����ǿյ�
    		if(l!=null) queue.offer(l);
    	}
    	//��ʼ��һ���µĶ���������Ӱ�
    	ListNode newhead = new ListNode(0);
    	ListNode p = newhead;
    	while(!queue.isEmpty()){
    		ListNode n  = queue.poll();
    		p.next = n;
    		p = p.next;
    		if(n.next!=null) queue.offer(n.next);//����queue
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
