package DataStructual;
/**
 * Definition for singly-linked list.
 * ������ṹ��Ϊ�˷������Է�������Ϊpublic
 * */

public class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int x){ val = x;}
	//��ӡ������ķ���
	public void print(){
		ListNode n =this;
		  while(n!=null){
			  System.out.print(n.val+"->");
			  n=n.next;
		  }
		  System.out.println();
	}
}
