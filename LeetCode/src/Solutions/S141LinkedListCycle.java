package Solutions;

import java.util.HashSet;

public class S141LinkedListCycle {

	 //Definition for singly-linked list.
	 public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean hasCycle(ListNode head) {
        //错误的方法：用val判断而不是用ListNode，val可以重复的（11ms 3.14%）
        if(head==null || head.next == null) return false;//边界条件
        HashSet<ListNode> set = new HashSet<ListNode>();
        while(head.next!=null){
            set.add(head);
            if(set.contains(head.next)) {
                return true;
            }
            else{
                head = head.next;
            }
        }
        return false;
    }

}
