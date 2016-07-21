package Solutions;

import java.util.HashSet;

import DataStructual.ListNode;

public class S141LinkedListCycle {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] nums = {1,2};
//		ListNode l = Array2List(nums);
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
//		l1.next=l2;l2.next=l3;l3.next=l1;
		l1.next =l2;
		System.out.println(hasCycle2(l1));
		

	}
	//��set���ж��Ƿ��л�
    public static boolean hasCycle(ListNode head) {
        //����ķ�������val�ж϶�������ListNode��val�����ظ��ģ�11ms 3.14%��
        if(head==null || head.next == null) return false;//�߽�����
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
    //���ö���ռ�
    public static boolean hasCycle2(ListNode head) {
        if(head ==null || head.next==null) return false;
        ListNode slower = head;
        ListNode faster = head;
        while(faster!=null && faster.next!=null){
            slower =slower.next;
            faster = faster.next.next;
            if(slower == faster) return true;
        }
        return false;
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
