package Solutions;

import DataStructual.ListNode;

public class RemoveLinkedListElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(6);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(4);
		ListNode n6 = new ListNode(5);
		ListNode n7 = new ListNode(6);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n1.print();
		ListNode res = removeElements(n1,6);
		n1.print();
		

	}
    public static ListNode removeElements(ListNode head, int val) {
        ListNode n0 = new ListNode(0);
        n0.next = head;
        ListNode prior = n0;
        while(head!=null){
            if(head.val == val) prior.next = head.next;
            else prior = head;
            head = head.next;
            
        }
        return n0.next;
        
    }
    
}
