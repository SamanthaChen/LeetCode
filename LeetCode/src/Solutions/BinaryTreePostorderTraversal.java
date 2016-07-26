package Solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import DataStructual.TreeNode;

public class BinaryTreePostorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 * 二叉树后续遍历
	 * **/
	//递归的方法
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<Integer>();
//        if(root==null) return list;
//        list.addAll(postorderTraversal(root.left));
//        list.addAll(postorderTraversal(root.right));
//        list.add(root.val);
//        return list;
//    }
    //递归采用子函数
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<Integer>();
//        if(root==null) return list;
//        postorderHelper(list,root);
//        return list;
//    }
//    public void postorderHelper(List<Integer> list, TreeNode root){
//    	if(root==null) return;
//    	postorderHelper(list,root.left);
//    	postorderHelper(list,root.right);
//    	list.add(root.val);
//    }
    	
	//非递归
	//采用类似先序遍历的方法（根左右），但是插入顺序是反的，然后就可以实现左右根
  public static List<Integer> postorderTraversal(TreeNode root) {
	  LinkedList<Integer> list = new LinkedList<Integer>();
	  if(root==null) return list;
	  Stack<TreeNode> stack = new Stack<TreeNode>();
	  while(!stack.isEmpty() || root!=null){
		  TreeNode cur = stack.pop();
		  list.addFirst(root.val);
		  if(cur.left!=null){
			  stack.push(cur.left);
		
		  }else{
			  TreeNode node = stack.pop();
			  root = node.left;
		  }
	  } 
	  return list;
  }
	
}
