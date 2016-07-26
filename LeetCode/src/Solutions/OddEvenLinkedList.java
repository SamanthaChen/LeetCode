package Solutions;

import DataStructual.ListNode;

public class OddEvenLinkedList {

	public static ListNode oddEvenList(ListNode head) {
		//����һ����ż������һ���洢��ż��������ӵķ���,ͨ����������������ż��������ģ���������Ŀ��������ġ�����
		if(head == null || head.next == null) return head;

		ListNode even = new ListNode(0);//�洢ż��
		ListNode evenHead = even;
		ListNode pre = new ListNode(0);//Ϊ�������һ���µ�ͷ
		ListNode oldHead = pre;//�洢�ϵ�����ͷ
		pre.next = head;
		while(head != null){
			if(head.val % 2 == 0) {//ż�������
				evenHead.next = head;//ż����ָ��head
				evenHead = evenHead.next;//ż����ָ�����
				pre.next = head.next;//����ͷֱ��ָ�����ż������һ����1->3
				//pre���ֲ���,head����
				head = head.next;

			}else{
				//��������ֱ�Ӻ���
				pre = head;
				head = head.next;
			}
		}//whileѭ�����ˣ����preָ��ָ�����һ������
		pre.next = even.next;//pre�ӵ���һ��ż��
		return oldHead.next;

		// }
		//		//��Ŀ�������������
//		        if(head != null){
//		            ListNode odd = head, even = head.next, evenHead = even;
//		            while(even !=null && even.next != null){
//		                odd.next = even.next;
//		                even.next = odd.next.next;
//		                odd = odd.next;
//		                even = even.next;
//		            }
//		            odd.next = evenHead;
//		        }
//		    
//		        return head;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  ListNode node1 = new ListNode(1);
		  ListNode node2 = new ListNode(2);
		  ListNode node3 = new ListNode(3);
		  ListNode node4 = new ListNode(4);
		  ListNode node5 = new ListNode(5);
		  //1->2->4->3->5
		  node1.next = node2;
		  node2.next = node4;
		  node4.next = node3;
		  node3.next = node5;
		  node1.print();
		  oddEvenList(node1);
		  node1.print();
		  
	}

}
