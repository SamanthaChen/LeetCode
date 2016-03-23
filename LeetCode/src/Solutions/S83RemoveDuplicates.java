package Solutions;

import DataStructual.ListNode;

public class S83RemoveDuplicates {
    public static ListNode deleteDuplicates(ListNode head) {
    	//自己写的
//        if(head == null || head.next == null) return head;
//        ListNode dummy = new ListNode(0);//添加一个新的头
//        dummy.next = head;
//        ListNode pre = dummy;
//        while(head != null && head.next!=null ){
//            while( head.next!=null && head.val == head.next.val) head = head.next;
//                pre.next = head;
//                pre = head;
//                head = head.next;
//        }    
// 
//        return dummy.next;
    	
    	//别人写的一个简单的三行代码
    	if(head == null || head.next == null) return head;
    	head.next = deleteDuplicates(head.next);
    	return head.val == head.next.val ? head.next : head;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  ListNode node1 = new ListNode(1);
		  ListNode node2 = new ListNode(2);
		  ListNode node3 = new ListNode(2);
		  ListNode node4 = new ListNode(4);
		  ListNode node5 = new ListNode(4);
		  //1->2->2->4->4
		  node1.next = node2;
		  node2.next = node3;
		  node3.next = node4;
		  node4.next = node5;
		  node1.print();
		  deleteDuplicates(node1).print();
	}

}
