package Solutions;

import DataStructual.ListNode;

public class S19RemoveNthNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //O普通的方法是编译一遍，找出长度，在在len-n的位置删除就好
        //one pass需要设置两个指针，当第一个走到尾时候第二个刚好差n个位置
        //为了防止 [1],1 的情况，需要自己多加一个头，或者写个边界判断？
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode faster = start;
        ListNode slower = start;
        for(int i = 1; i <= n+1; i++){
            faster = faster.next;
        }
        while(faster!=null){
            faster = faster.next;
            slower = slower.next;
        }
        slower.next = slower.next.next;
        return start.next;
    

    }

}
