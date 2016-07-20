package DataStructual;
/**
 * Definition for singly-linked list.
 * ������ṹ��Ϊ�˷������Է�������Ϊpublic
 * */

public class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int x){ val = x;}
	//
	public String toString(){
		return String.valueOf(val);
	}


	//����������������
	public ListNode (int[] nums){
		
		ListNode root = this;
		for(int i =0; i<nums.length;i++){
			ListNode n = new ListNode(nums[i]);
			root.next = n;
			root = root.next;
		}
		
	}
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
