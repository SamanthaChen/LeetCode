package Solutions;

import DataStructual.ListNode;

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        
        //自己写的，循环非递归（13.35%）
        // if( head == null || head.next == null) return head;
        // ListNode first,second;
        // ListNode dummy = new ListNode(0);//添加一个新的头
        // ListNode pre = dummy;
        // dummy.next = head;
        // while(head != null && head.next != null){
        //     first = head;
        //     second = head.next;
        //     head = second.next;//保存第三个数
        //     pre.next =second;//0->2
        //     second.next = first;//2->1
        //     first.next = head;//0->2->1->3->4
        //     pre = first;
        // }
        // return dummy.next ;
        
        //递归的方法(13.35%)
        if( head == null || head.next == null) return head;
        ListNode third = head.next.next;
        ListNode n = head.next;
        head.next.next = head;
        head.next = swapPairs(third);
        return n;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
