package Solutions;

import DataStructual.ListNode;

public class S19RemoveNthNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //O��ͨ�ķ����Ǳ���һ�飬�ҳ����ȣ�����len-n��λ��ɾ���ͺ�
        //one pass��Ҫ��������ָ�룬����һ���ߵ�βʱ��ڶ����պò�n��λ��
        //Ϊ�˷�ֹ [1],1 ���������Ҫ�Լ����һ��ͷ������д���߽��жϣ�
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode faster = start;
        ListNode slower = start;
        for(int i = 1; i <= n+1; i++){
            faster = faster.next;
        }
        while(faster!=null){
            faster = faster.next;
            slower = slower.next;
        }
        slower.next = slower.next.next;
        return start.next;
    

    }

}
