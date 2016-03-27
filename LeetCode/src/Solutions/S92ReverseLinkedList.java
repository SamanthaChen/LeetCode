package Solutions;

import DataStructual.ListNode;

public class S92ReverseLinkedList {
	  public static ListNode reverseBetween(ListNode head, int m, int n) {
	        if(head == null || m==n || head.next == null) return head;
	        ListNode pre = new ListNode(0);
	        pre.next = head;
	        for(int i = 0; i<m-1 ; i++) pre = pre.next;
	        ListNode oldPre = pre;
	        ListNode start = pre.next;
	        ListNode back = null;
	        for(int i = 0; i<=n-m ;i++){
	        	back = start.next;
	        	start.next = pre;
	        	pre = start;
	        	start = back;
	        }
	        oldPre.next.next = back;
	        oldPre.next = pre;
	        
//	        if(m == 1) return pre;
	        return head;
	 
	    }
	  public static void main(String[] args) {
//		  ListNode node1 = new ListNode(1);
//		  ListNode node2 = new ListNode(2);
//		  ListNode node3 = new ListNode(3);
//		  ListNode node4 = new ListNode(4);
//		  ListNode node5 = new ListNode(5);
//		  node1.next = node2;
//		  node2.next = node3;
//		  node3.next = node4;
//		  node4.next = node5;
//		  reverseBetween(node1,2,4);
		  
		  ListNode node3 = new ListNode(3);
		  ListNode node5 = new ListNode(5);
		  node3.next = node5;
		  print(node3);
		  print(reverseBetween(node3,1,2));
	  }
	  public static void print(ListNode n){
		  while(n!=null){
			  System.out.println(n.val);
			  n=n.next;
		  }
	  }
}
