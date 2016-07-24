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
	 * ��������������
	 * **/
	//�ݹ飬�������Ӻ���
//    public static List<Integer> inorderTraversal(TreeNode root) {
//    	List<Integer> list = new ArrayList<Integer>();
//    	if(root==null) return list;
//    	list.addAll(inorderTraversal(root.left));
//    	list.add(root.val);
//    	list.addAll(inorderTraversal(root.right));
//    	return list;
//    }
	
	//�ݹ飬�����Ӻ���
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
	//��ջ���ǵݹ�
	//ֻ�е������ǿյ�ʱ��ŷ���,����Ҫset�ж��Ƿ��Ѿ����ʹ���
//	public static List<Integer> inorderTraversal(TreeNode root){
//    	List<Integer> list = new ArrayList<Integer>();
//    	if(root==null) return list;
//    	Stack<TreeNode> stack = new Stack<TreeNode>();
//    	Set<TreeNode> set = new HashSet<TreeNode>();//����������ж��ǲ����Ѿ����ʹ���
//    	stack.push(root);
//    	while(!stack.isEmpty()){
//    		
//    		TreeNode node = stack.peek();
//
//    		//ֻ�е������ǿյ�ʱ��ŷ���,����Ҫ�ж��Ƿ��Ѿ����ʹ���
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
	
	//��ջ���ǵݹ�
	//����Ҫ����ռ�
	public static List<Integer> inorderTraversal(TreeNode root){
		List<Integer> list =  new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(root!=null || !stack.isEmpty()){
			while(root!=null){//���������ջ
				stack.push(root);
				root = root.left;
			}
			//��������ջ���ˣ����ʸ��ڵ㣬����������������ջ
			//����������Ϊ�գ������while����ִ�о�ֱ�ӷ��ʸ��ڵ���
			root = stack.pop();
			list.add(root.val);
			root = root.right;
		}
		return list;
		
	}
}
