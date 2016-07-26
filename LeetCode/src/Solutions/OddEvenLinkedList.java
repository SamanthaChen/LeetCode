package Solutions;

import DataStructual.ListNode;

public class OddEvenLinkedList {

	public static ListNode oddEvenList(ListNode head) {
		//属于一碰到偶数就往一个存储的偶数链后面加的方法,通俗做法（即奇数和偶数是乱序的，不是像题目给的正序的。。）
		if(head == null || head.next == null) return head;

		ListNode even = new ListNode(0);//存储偶数
		ListNode evenHead = even;
		ListNode pre = new ListNode(0);//为链表添加一个新的头
		ListNode oldHead = pre;//存储老的链表头
		pre.next = head;
		while(head != null){
			if(head.val % 2 == 0) {//偶数的情况
				evenHead.next = head;//偶数链指向head
				evenHead = evenHead.next;//偶数链指针后移
				pre.next = head.next;//奇数头直接指向这个偶数的下一个数1->3
				//pre保持不变,head后移
				head = head.next;

			}else{
				//碰到奇数直接后移
				pre = head;
				head = head.next;
			}
		}//while循环完了，最后pre指针指向最后一个奇数
		pre.next = even.next;//pre接到第一个偶数
		return oldHead.next;

		// }
		//		//题目给的特殊情况的
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
