package Solutions;

import DataStructual.ListNode;

public class ReverseLinkedListI {
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
	  //2016.7.21 新写的
	    public static ListNode reverseBetweenNew(ListNode head, int m, int n) {
	        if(head==null || head.next==null || m==n) return head;
	        int count = n-m+1;
	        ListNode oldhead = new ListNode(0);
	        oldhead.next = head;
	        //先将指针移动到给定位置
	        ListNode pre = oldhead;
	        while(m>1){
	            pre = head;
	            head = head.next;
	            --m;
	        }
	        //再翻转一下中间的
	        ListNode oldpre = pre;
	        ListNode nxt;
	        while(count>=1){
	            nxt = head.next;
	            head.next = pre;
	            pre = head;
	            head = nxt;
	            --count;
	        }
	        //再处理一下连接部分
	        oldpre.next.next = head;
	        oldpre.next = pre;
	        return oldhead.next;
	        
	        
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
