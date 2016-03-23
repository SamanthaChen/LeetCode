package Solutions;

import DataStructual.ListNode;

public class S83RemoveDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);//添加一个新的头
        dummy.next = head;
        ListNode pre = dummy;
        while(head != null && head.next!=null ){
            while( head.next!=null && head.val == head.next.val) head = head.next;
                pre.next = head;
                pre = head;
                head = head.next;
        }    
 
        return dummy.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
