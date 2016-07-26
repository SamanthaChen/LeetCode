package Solutions;

import java.util.Comparator;
import java.util.PriorityQueue;

import DataStructual.ListNode;

public class MergekSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n1 = {1,3,5,7};
		int[] n2 = {2,4,6,8};
		int[] n3 = {-6,-1,0,9};
		ListNode l1 = Array2List(n1);
		ListNode l2 = Array2List(n2);
		ListNode l3 = Array2List(n3);
		ListNode[] ll = {l1,l2,l3};
		ListNode res = mergeKLists(ll);
		res.print();
		
  
	}
	/*
	 * 思路： 用优先队列实现
	 * **/
    public static ListNode mergeKLists(ListNode[] lists) {
    	if(lists == null || lists.length == 0) return null;
    	//匿名内部类 ,自己实现的排序方式是按照链表头的value进行排序
    	PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
    		public int compare(ListNode l1, ListNode l2){
    			return Integer.compare(l1.val, l2.val);
    		}
    	});
    	//把list[] 里面每个链表的头加入队列里面，这样每次取值的时候都会先取小的出来
    	for(ListNode l : lists) {//非常值得注意的是这里面的list都会有可能是空的
    		if(l!=null) queue.offer(l);
    	}
    	//开始往一个新的队列里面添加吧
    	ListNode newhead = new ListNode(0);
    	ListNode p = newhead;
    	while(!queue.isEmpty()){
    		ListNode n  = queue.poll();
    		p.next = n;
    		p = p.next;
    		if(n.next!=null) queue.offer(n.next);//更新queue
    	}
    	return newhead.next;
        
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
