package JulyAlgotithm;

import DataStructual.ListNode;

public class Intersectionod2LinkedList {

	public static void main(String[] args) {
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		
		ListNode c1 = new ListNode(4);
		ListNode c2 = new ListNode(5);
		ListNode c3 = new ListNode(6);
		
		ListNode b1 = new ListNode(7);
		ListNode b2 = new ListNode(8);
		ListNode b3 = new ListNode(9);
		
		a1.next=a2; a2.next=c1; c1.next=c2; c2.next=c3;
		b1.next=b2; b2.next=b3; b3.next=c1; 
		a1.print(); b1.print();
		ListNode res = getIntersectionNode2(a1,b1);
		res.print();

	}
	/*思路1：先求两个链表长度，从对齐的地方开始依次往后找相交的
	 * **/
	public static ListNode getIntersectionNode(ListNode head1, ListNode head2){
		ListNode p1 = head1;
		ListNode p2 = head2;
		int len1 = getLength(head1);
		int len2 = getLength(head2);
		if(len1>len2){
			int k = len1-len2;
			while(k > 0){
				p1 = p1.next;
				k--;
			}
		}else{
			int k = len2-len1;
			while(k > 0){
				p2 = p2.next;
				k--;
			}
		}
		while(p1!=null && p1!=p2 ){
			p1=p1.next;
			p2=p2.next;
		}
		return p1;
		
	}
	public static int getLength(ListNode p){
		int n = 0;
		while(p!=null){
			n++;
			p=p.next;
		}
		return n;
	}
	
	/*
	 * 思路2:这个方法在有环的时候不能用
	 * **/
	public static ListNode getIntersectionNode2(ListNode head1, ListNode head2){
		ListNode p1 = head1;
		ListNode p2 = head2;
		while(p1!=p2){
			p1 = p1 == null ? head2 : p1.next;
			p2 = p2 == null ? head1 : p2.next;
		}
		return p1;
	}
	

}
