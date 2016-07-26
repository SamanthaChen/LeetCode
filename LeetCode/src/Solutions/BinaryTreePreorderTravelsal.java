package Solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import DataStructual.TreeNode;

public class BinaryTreePreorderTravelsal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,5,6,7};
		TreeNode root = array2Tree(nums);
		
//		List<Integer> res = preorderTraversal(root);
//		res.forEach(e->{System.out.println(e+" ");});
		
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
	
	
	/*
	 * 根据数组来创建树
	 * **/
	public static TreeNode array2Tree(int[] nums){
		LinkedList<TreeNode> nodelist = new LinkedList<TreeNode>();
		//将数组的每个元素都转换成树节点,并用一个表存
		for(int nodeindex = 0; nodeindex<nums.length;nodeindex++)
			nodelist.add(new TreeNode(nums[nodeindex]));
		//建立父节点与子节点的联系
		for(int parentindex = 0;parentindex<=nums.length/2-1;parentindex++){
			TreeNode parent = nodelist.get(parentindex);
			parent.left = nodelist.get(2*parentindex+1);//左孩子
			//需要考虑右孩子可能不存在的情况
			if(2*parentindex+2<nums.length){
				parent.right = nodelist.get(2*parentindex+2);//左孩子
			}
		}
		return nodelist.get(0);
		
	}

}
