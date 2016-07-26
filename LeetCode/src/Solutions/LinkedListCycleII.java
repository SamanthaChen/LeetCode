package Solutions;

import DataStructual.ListNode;

public class LinkedListCycleII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,1,2,3,4,5};
		ListNode l = Array2List(nums);
		l.next.next=l;
		ListNode res = detectCycle(l);
		System.out.println(l.val);
		
	}
    /*
    理一下思路：假设环开始地方坐标是C，slow距离环有S距离（S只能是正的，在环里面），则slow走了C+S的距离。
    而faster一次走2步，走的路程是slow的两倍，同时fast与slow第一次相遇时候应该比slow多走了一个圆圈cycle的距离。
    可以得到 d(fast)-d(slow) = c+s = cycle
    则slow再走cycle-s，另一个从头开始走了C步后两个应该在C相遇，因为cycle-s=c
    **/
    public static ListNode detectCycle(ListNode head) {
        ListNode slow  = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){//第一次相遇
                while(head!=slow){
                    head = head.next;
                    slow = slow.next;
                }
                return head;
            }
        }
        return null;
    }
	//根据数组生成链表
	public static ListNode  Array2List(int[] nums){
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
