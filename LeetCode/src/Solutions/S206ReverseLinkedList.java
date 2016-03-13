package Solutions;

import DataStructual.ListNode;

public class S206ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        ListNode cur = head.next;//保存head的后面一个数
        if(cur == null) return head;
        head.next = null;//保存完了将第一个数后面指针指向空
        ListNode post = cur.next;//保存head的后面第二个数

        while(post!=null){
            cur.next = head;//将指针转变方向
            head = cur;
            cur = post;//指针后移
            post = cur.next;//指针后移
            
        }
        cur.next = head;
        head = cur;
        return head;
    }
}
