package Test;

import java.util.ArrayList;
import java.util.List;

import DataStructual.ListNode;

public class test3 {
	
	public static void main(String[] args){
		int[] nums = {1,2,3,4,5};
		ListNode head = Array2List(nums);
		ListNode res = copyList(head);
		res.print();
	}
	//S21�ϲ����������
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
		
		return l2;
		
	}
	//дһ�����������
	public static ListNode copyList(ListNode head){
		if(head==null) return null;
		if(head.next == null) return new ListNode(head.val);
		ListNode newhead = new ListNode(head.val);
		ListNode old = newhead;
		head = head.next;
		while(head!=null){
			ListNode p = new ListNode(head.val);
			newhead.next = p;
			newhead = newhead.next;
			head = head.next;
		}
		return old;
		
	}
    //�ȼ���һ��m��n���Ƿ��������ģ�
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null || head.next==null || m==n) return head;
        int count = n-m+1;
        ListNode oldhead = new ListNode(0);
        oldhead.next = head;
        //�Ƚ�ָ���ƶ�������λ��
        ListNode pre = oldhead;
        while(m>1){
            pre = head;
            head = head.next;
            --m;
        }
        //�ٷ�תһ���м��
        ListNode oldpre = pre;
        ListNode nxt;
        while(count>=1){
            nxt = head.next;
            head.next = pre;
            pre = head;
            head = nxt;
            --count;
        }
        //�ٴ���һ�����Ӳ���
        oldpre.next.next = head;
        oldpre.next = pre;
        return oldhead.next;
        
        
    }
	//�ݹ�ת������
	//�ݹ�ķ���
	public static ListNode reverseList(ListNode head){
		if(head==null || head.next == null) return head;
		ListNode newtail = head.next;
		ListNode newhead = reverseList(head.next);
		
		head.next =null;
		newtail.next = head;
		return newhead;
		
	}
	//�ǵݹ�ķ���
	public static ListNode reverseList2(ListNode head){
		if(head == null || head.next == null) return head;
		//�Ѻ����ָ��������ת����
		ListNode pre = null;
		ListNode next;
		while(head!=null){
			next = head.next;
			head.next =pre;//��ǰָ����ǰָ
			pre = head;//�����ƶ�
			head = next;
		}
		return pre;
		
		
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
