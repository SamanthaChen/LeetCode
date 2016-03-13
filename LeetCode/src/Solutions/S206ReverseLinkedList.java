package Solutions;

import DataStructual.ListNode;

public class S206ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        ListNode cur = head.next;//����head�ĺ���һ����
        if(cur == null) return head;
        head.next = null;//�������˽���һ��������ָ��ָ���
        ListNode post = cur.next;//����head�ĺ���ڶ�����

        while(post!=null){
            cur.next = head;//��ָ��ת�䷽��
            head = cur;
            cur = post;//ָ�����
            post = cur.next;//ָ�����
            
        }
        cur.next = head;
        head = cur;
        return head;
    }
}
