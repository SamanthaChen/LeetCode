package Solutions;
import java.util.Stack;

import DataStructual.ListNode;

public class S2AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {2,4};
		ListNode l1 = CreatListNodeFromArray(nums1);
		int[] nums2 = {5,6,4};
		ListNode l2 = CreatListNodeFromArray(nums2);
		ListNode res = addTwoNumbers(l1,l2);
		res.print();
		
	}
    //思路1
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	if(l1==null || l2==null) return l1==null? l2 : l1;
    	ListNode p1 = l1;
    	ListNode p2 = l2;
    	ListNode newhead  = new  ListNode(0);
    	ListNode p3 = newhead;//存结果的
    	int carry = 0;
    	while(p1!=null || p2!=null){
    		if(p1!=null){
      			carry += p1.val;
        		p1 = p1.next;
    		}
    		if(p2!=null){
    			carry += p2.val;
        		p2 = p2.next;
    		}    		
    		p3.next = new ListNode(carry%10);
    		p3 = p3.next;
    		carry = carry/10;
    		 
    	}
    	//最后一位的进位也要考虑
    	if(carry==1) p3.next = new ListNode(1);
    	return newhead.next;
    	
    	

        
    }
	//根据数组生成链表
	public static ListNode  CreatListNodeFromArray(int[] nums){
		ListNode root = new ListNode(0);
		ListNode old = root;
		for(int i =0; i<nums.length;i++){
			ListNode n = new ListNode(nums[i]);
			root.next = n;
			root = root.next;
		}
		return old.next;
	}
    

}
