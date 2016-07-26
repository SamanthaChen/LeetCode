package Solutions;

import DataStructual.ListNode;

public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //（循环）开辟一个新的链表来存储合并后的链表（11.81%）
        // if(l1 == null ) return l2;
        // if(l2 == null ) return l1;
        // ListNode dummy = new ListNode(0);
        // ListNode head = dummy;
        // while(l1!= null && l2 != null){
        //     if(l1.val <= l2.val){
        //         head.next = l1;
        //         l1 = l1.next;
        //     }
        //     else{
        //         head.next = l2;
        //         l2 = l2.next;
        //     }
        //     head = head.next;
        // }
        // if( l1 == null) head.next = l2;
        // if( l2 == null) head.next = l1;
        // return dummy.next;
        
        //递归(11.81%)
        if(l1 == null ) return l2;
        if(l2 == null ) return l1;
        ListNode head;
        if(l1.val <= l2.val){
            head = l1;
            head.next = mergeTwoLists(l1.next,l2);
        }
        else{
            head = l2;
            head.next = mergeTwoLists(l1,l2.next);
        }
        return head;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
