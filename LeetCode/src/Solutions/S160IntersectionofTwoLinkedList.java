package Solutions;

import java.util.HashSet;

import DataStructual.ListNode;

public class S160IntersectionofTwoLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a1 = new ListNode(1);
		ListNode a3 = new ListNode(3);
//		ListNode a5 = new ListNode(5);
//		ListNode a7 = new ListNode(7);
//		ListNode a9 = new ListNode(9);
//		ListNode a11 = new ListNode(11);
//		ListNode a13 = new ListNode(13);
//		ListNode a15 = new ListNode(15);
//		ListNode a17 = new ListNode(17);
//		ListNode a19 = new ListNode(19);
//		ListNode a21 = new ListNode(21);
		a1.next = a3;
//		a3.next = a5;
//		a5.next = a7;
//		a9.next = a11;
//		a11.next = a13;
//		a13.next = a15;
//		a15.next = a17;
//		a17.next = a19;
//		a19.next = a21;
		ListNode b1 = new ListNode(2);
		ListNode res = getIntersectionNode(a1,b1);
		System.out.println(res.val);
		
		
		
	}
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //�����������ʣ��᲻�����ظ������֣����� a1,a2,b1,a3,b1,b2,b3 �� b1,b2,b3���ܼ�⵽��һ��b1����Ϊ�غ��ˣ�
        //�ⷨ1��2ms
        // int lenA = Listlength(headA);
        // int lenB = Listlength(headB);
        // ListNode a = headA;
        // ListNode b = headB;
        //�Ȱѳ��ȳ���ָ���Ƶ���̵ĳ�ʼλ����ͬ�ĵط�
        // if(lenA>lenB){
        //     int  n = lenA-lenB;
        //     while(n>0){
        //         a = a.next;
        //         n--;
        //     }
        // }else{
        //     int  n = lenB-lenA;
        //     while(n>0){
        //         b = b.next;
        //         n--;
        //     } 
        // }
        // //Ȼ��ʼ����Ƚ�
        // while(a!=null){
        //     if(a == b) return a;
        //     else{
        //         a = a.next;
        //         b = b.next;
        //     }
        // }
        // return null;
        
        //�ⷨ2�������һЩ��(3ms)
        ListNode a = headA;
        ListNode b = headB;
        while(a!=b){
            a =   a == null ? headB:a.next;
            b =   b == null ? headA:b.next;
        }
        return a;
        
    }
    public int Listlength(ListNode head){
        int res = 0;
        while(head!=null){
            res += 1;
            head = head.next;
        }
        return res;
    }
}
