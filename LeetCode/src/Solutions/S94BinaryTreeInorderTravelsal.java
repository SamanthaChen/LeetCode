package Solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import DataStructual.TreeNode;

public class S94BinaryTreeInorderTravelsal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 * 中序遍历，左根右
	 * **/
	//递归，不借用子函数
//    public static List<Integer> inorderTraversal(TreeNode root) {
//    	List<Integer> list = new ArrayList<Integer>();
//    	if(root==null) return list;
//    	list.addAll(inorderTraversal(root.left));
//    	list.add(root.val);
//    	list.addAll(inorderTraversal(root.right));
//    	return list;
//    }
	
	//递归，借用子函数
//	public static List<Integer> inorderTraversal(TreeNode root) {
//    	List<Integer> list = new ArrayList<Integer>();
//    	if(root==null) return list;
//    	inorderHelper(list,root);
//    	return list;
//	}
//	public static void inorderHelper(List<Integer> list,TreeNode root){
//		if(root==null) return;
//		inorderHelper(list,root.left);
//		list.add(root.val);
//		inorderHelper(list,root.right);
//	}
	//用栈，非递归
	//只有当左孩子是空的时候才访问,还需要set判断是否已经访问过了
//	public static List<Integer> inorderTraversal(TreeNode root){
//    	List<Integer> list = new ArrayList<Integer>();
//    	if(root==null) return list;
//    	Stack<TreeNode> stack = new Stack<TreeNode>();
//    	Set<TreeNode> set = new HashSet<TreeNode>();//用这个集合判断是不是已经访问过了
//    	stack.push(root);
//    	while(!stack.isEmpty()){
//    		
//    		TreeNode node = stack.peek();
//
//    		//只有当左孩子是空的时候才访问,还需要判断是否已经访问过了
//    		if(node.left==null || (set.contains(node.left))){
//    			stack.pop();
//    			list.add(node.val);
//    			set.add(node);
//    		}
//    		
//    		if(node.left!=null && !set.contains(node.left)) stack.push(node.left);
//    		else if (node.right!=null && !set.contains(node.right)) stack.push(node.right);
//    	
//    	}
//    	return list;
//	}
	
	//用栈，非递归
	//不需要额外空间
	public static List<Integer> inorderTraversal(TreeNode root){
		List<Integer> list =  new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(root!=null || !stack.isEmpty()){
			while(root!=null){//沿着左边入栈
				stack.push(root);
				root = root.left;
			}
			//左子树入栈完了，访问根节点，右子树的左子树入栈
			//假如右子树为空，上面的while不会执行就直接访问根节点了
			root = stack.pop();
			list.add(root.val);
			root = root.right;
		}
		return list;
		
	}
}
