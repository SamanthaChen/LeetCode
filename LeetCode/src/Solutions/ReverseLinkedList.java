package Solutions;

import DataStructual.ListNode;

public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
    	//�����汾(�ӵڶ���ָ�뿪ʼ���ǵģ����벻�����)
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
    public ListNode reverseList2(ListNode head){
    	//�ݹ�汾,�ݹ�Ľ�ָ��ת���ٺ���
        return reverse(head,null);

    }
    public ListNode reverse(ListNode head,ListNode newhead){
        //�����������ת�ú����������һ����
        if(head == null) return newhead;
        ListNode next = head.next; 
        head.next = newhead;//ָ��ת��
        return reverse(next,head);//����ƶ�
    }
    public ListNode reverseList3(ListNode head){
         //�����汾(�ӵ�1��ָ�뿪ʼ���ǵģ�)
         if(head == null || head.next == null) return head;
         ListNode newhead = null;
         while(head!=null){
             ListNode next = head.next;
             head.next = newhead;//�ı�ָ�뷽��
             newhead = head;//ָ�����
             head = next;
         }
         return newhead;
    }
    
    ///2016.7.21����һ���ҿ������ĵݹ�ķ���
	//�ݹ�ת������
	//�ݹ�ķ���
	public static ListNode reverseListNew(ListNode head){
		if(head==null || head.next == null) return head;
		ListNode newtail = head.next;
		ListNode newhead = reverseList (head.next);
		
		head.next =null;
		newtail.next = head;
		return newhead;
		
	}
   }
