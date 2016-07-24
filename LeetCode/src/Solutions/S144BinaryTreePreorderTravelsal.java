package Solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import DataStructual.TreeNode;

public class S144BinaryTreePreorderTravelsal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,5,6,7};
		TreeNode root = new TreeNode(nums);
		List<Integer> res = preorderTraversal(root);
		res.forEach(e->{System.out.println(e+" ");});
		
	}
	/*
	 * 树的先序遍历，递归，采用递归子函数
	 * **/
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<Integer>();
//        preorderHelper(list,root);
//		return list;    
//    }
//    public static void preorderHelper(List<Integer> list,TreeNode root){
//    	if(root==null) return;
//    	list.add(root.val);
//    	preorderHelper(list,root.left);
//    	preorderHelper(list,root.right);
//    }
	/*
	 * 树的先序遍历，递归，不采用子函数
	 * **/
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<Integer>();
//        if(root==null) return list;
//        list.add(root.val);
//        list.addAll(preorderTraversal(root.left));
//        list.addAll(preorderTraversal(root.right));
//        return list;    
//    }
	/*
	 * 树的先序遍历，非递归，采用栈
	 * **/
	public static List<Integer> preorderTraversal(TreeNode root){
		List<Integer> list = new ArrayList<Integer>();
		if(root==null) return list;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(root);
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			list.add(node.val);
			if(node.right!=null) stack.push(node.right); 
			if(node.left!=null) stack.push(node.left); 
		}
		return list;
	}

}
