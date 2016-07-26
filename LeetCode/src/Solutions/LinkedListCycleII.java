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
    ��һ��˼·�����軷��ʼ�ط�������C��slow���뻷��S���루Sֻ�������ģ��ڻ����棩����slow����C+S�ľ��롣
    ��fasterһ����2�����ߵ�·����slow��������ͬʱfast��slow��һ������ʱ��Ӧ�ñ�slow������һ��ԲȦcycle�ľ��롣
    ���Եõ� d(fast)-d(slow) = c+s = cycle
    ��slow����cycle-s����һ����ͷ��ʼ����C��������Ӧ����C��������Ϊcycle-s=c
    **/
    public static ListNode detectCycle(ListNode head) {
        ListNode slow  = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){//��һ������
                while(head!=slow){
                    head = head.next;
                    slow = slow.next;
                }
                return head;
            }
        }
        return null;
    }
	//����������������
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
