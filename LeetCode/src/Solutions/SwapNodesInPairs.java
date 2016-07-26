package Solutions;

import DataStructual.ListNode;

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        
        //�Լ�д�ģ�ѭ���ǵݹ飨13.35%��
        // if( head == null || head.next == null) return head;
        // ListNode first,second;
        // ListNode dummy = new ListNode(0);//���һ���µ�ͷ
        // ListNode pre = dummy;
        // dummy.next = head;
        // while(head != null && head.next != null){
        //     first = head;
        //     second = head.next;
        //     head = second.next;//�����������
        //     pre.next =second;//0->2
        //     second.next = first;//2->1
        //     first.next = head;//0->2->1->3->4
        //     pre = first;
        // }
        // return dummy.next ;
        
        //�ݹ�ķ���(13.35%)
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
