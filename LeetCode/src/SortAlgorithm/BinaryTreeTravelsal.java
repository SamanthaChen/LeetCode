package SortAlgorithm;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 * 重新实现一遍二叉树遍历
 * **/
import DataStructual.TreeNode;
public class BinaryTreeTravelsal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*		 
 * 		   1
 * 		 /   \
 *		2	  3
 *     / \   /  \  
 *    4	  5  6  7
 *       / \  \
 *      10 11 13  
 *      
 *  先根：1,2,4,5,10,11,3,6,13,7
 *  中跟：4,2,10,5,11,1,6,13,3,7
 *  后跟：4,10,11,5,2,13,6,7,3,1
 * **/
		int[] nums = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		List<TreeNode> list = new ArrayList<TreeNode>();
		for(int i=0;i<nums.length;i++)
			list.add(new TreeNode(nums[i]));
		
		list.get(1).left=list.get(2);
		list.get(1).right=list.get(3);
		
		list.get(2).left=list.get(4);
		list.get(2).right=list.get(5);
		
		list.get(3).left=list.get(6);
		list.get(3).right=list.get(7);
		
		list.get(5).left=list.get(10);
		list.get(5).right=list.get(11);
		
		list.get(6).right=list.get(13);
		
		TreeNode root = list.get(1);//1是根节点
		
		List<Integer> res = postorderTravelsal(root);
		res.forEach(e->{System.out.print(e+" ");});
		
	}
	//先序遍历 (先根：1,2,4,5,10,11,3,6,13,7)
//	public static List<Integer> preorderTravelsal(TreeNode root){
//		List<Integer> list = new ArrayList<Integer>();
//		if(root==null) return list;
//		Stack<TreeNode> stack = new Stack<TreeNode>();
//		TreeNode p = root;
	//这个方法栈里面存的是已经访问过的元素
//		while(!stack.isEmpty() || p!=null){
//			if(p!=null){
//				list.add(p.val);//先访问，再入栈，入栈是为了后面找右孩子
//				stack.add(p);
//				p=p.left;
//			}else{
//				TreeNode p1= stack.pop();
//				p=p1.right;
//			}
//		}
//		return list;
//	}
//	public static List<Integer> preorderTravelsal(TreeNode root){
//		List<Integer> list = new ArrayList<Integer>();
//		if(root==null) return list;
//		Stack<TreeNode> stack = new Stack<TreeNode>();
//		
//		stack.push(root);
//		//这个方法里面存的是还没访问过的元素
//		while(!stack.isEmpty()){
//			TreeNode p = stack.pop();
//			list.add(p.val);
//			if(p.right!=null) stack.add(p.right);
//			if(p.left!=null) stack.add(p.left);
//		}
//		return list;
//	}

	
	//中序遍历(中跟：4,2,10,5,11,1,6,13,3,7)
//	public static List<Integer> inorderTravelsal(TreeNode root){
//		List<Integer> list = new ArrayList<Integer>();
//		if(root==null) return list;
//		Stack<TreeNode> stack = new Stack<TreeNode>();
//		TreeNode p = root;
//		//栈里面存的是未被访问的元素
//		while(!stack.isEmpty() || p!=null){
//			if(p!=null){
//				stack.push(p);
//				p=p.left;
//			}else{
//				TreeNode n = stack.pop();
//				list.add(n.val);
//				p=n.right;
//			}
//		}
//		return list;
//		
//	}
	
//	public static List<Integer> inorderTravelsal(TreeNode root){
//		List<Integer> list = new ArrayList<Integer>();
//		if(root==null) return list;
//		Stack<TreeNode> stack = new Stack<TreeNode>();
//		TreeNode p = root;
//		//栈里面存的是未被访问的元素
//		while(!stack.isEmpty() || p!=null){
//			while(p!=null){
//				stack.add(p);
//				p=p.left;
//			}
//			TreeNode n = stack.pop();
//			list.add(n.val);
//			p = n.right;
//		}
//		return list;
//		
//	}

	//后序遍历（后跟：4,10,11,5,2,13,6,7,3,1）
	public static List<Integer> postorderTravelsal(TreeNode root){
		LinkedList<Integer> list = new LinkedList<Integer>();
		if(root==null) return list;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		while(!stack.isEmpty() || p!=null){
			if(p!=null){
				list.addFirst(p.val);
				stack.add(p);
				p=p.right;
			}else{
				TreeNode p1 = stack.pop();
				p = p1.left;
			}
		}
		return list;
		
	}
	

}
