package Solutions;



import java.util.List;

import DataStructual.ListNode;
import DataStructual.TreeNode;
import Solutions.S144BinaryTreePreorderTravelsal;
public class S109ConvertSortedListoBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(3);
		ListNode l2 = new ListNode(5);
		ListNode l3 = new ListNode(8);
		l1.next = l2;l2.next=l3;
		TreeNode root = sortedListToBST(l1);
		List<Integer> res = S144BinaryTreePreorderTravelsal.preorderTraversal(root);
		res.forEach(e->{System.out.print(e+" ");});
	}
	//想法，跟Array类似，只是list的话 得按照他的顺序来
//	public static ListNode h;
//	public static TreeNode sortedListToBST (ListNode head){
//		if(head==null) return null;
//		int len = getListLen(head);
//		h = head;//必须得是一个全局变量，不然递归的时候指针不会一直往后走
//		TreeNode root = creat(0,len-1);
//		return root;
//		
//	}
//	public static TreeNode creat(int low,int high){
//		if(low>high) return null;
//		int mid = (low+high)/2;
//		TreeNode left = creat(low,mid-1);
//		TreeNode root = new TreeNode(h.val);
//		h = h.next;
//		TreeNode right = creat(mid+1,high);
//		root.left = left;
//		root.right = right;
//		return root;
//		
//	}
//	
//	public static int getListLen(ListNode head){
//		if(head==null) return 0;
//		int count = 0;
//		ListNode  p = head;
//		while(p!=null){
//			count++;
//			p = p.next;
//		}
//		return count;
//	}
	
	//第二个，也是按照Array的想法来，只是找中点用list特有的方法
	public static TreeNode sortedListToBST (ListNode head){
		if(head==null) return null;
		return toBST(head,null);
	}
	public static TreeNode toBST(ListNode head, ListNode tail){
		ListNode slow = head;
		ListNode fast = head;
		//终止条件
		if(head==tail) return null;
		while(fast!=tail && fast.next!=tail){
			slow = slow.next;
			fast = fast.next.next;
		}
		TreeNode root = new TreeNode(slow.val);
		root.left = toBST(head,slow);
		root.right = toBST(slow.next,tail);
		return root;
		
	}
}
