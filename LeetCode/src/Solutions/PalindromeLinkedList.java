package Solutions;

import java.util.Stack;

import DataStructual.ListNode;

public class PalindromeLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(1);
//		ListNode n5 = new ListNode(1);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
//		n4.next = n5;

		n1.print();
		System.out.println(isPalindrome(n1) == true ? "T" : "F" );
		
		

	}
    public static boolean isPalindrome(ListNode head) {
        //����˼�룺��ǰ�벿�ִ���ջ�������벿�ֽ��бȽ�
        //���ǵ÷�������ż���������
    
        if(head == null || head.next == null) return true;
        Stack<Integer> stack = new Stack<Integer>();
        ListNode pre = head;
        ListNode post = head;
        while( post!=null && post.next != null ){
            stack.add(pre.val);
            pre = pre.next;
            post = post.next.next;
        }
        if(post!=null) pre = pre.next;//˵��������������pre�����м��Ǹ���������벿�� 
        while(!stack.isEmpty()){
            int val = stack.pop();
            if(pre.val != val) return false;
            pre = pre.next;
        }
        return true;
        
    }
}
