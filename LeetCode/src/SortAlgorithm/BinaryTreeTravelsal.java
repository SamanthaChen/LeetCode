package SortAlgorithm;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 * ����ʵ��һ�����������
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
 *  �ȸ���1,2,4,5,10,11,3,6,13,7
 *  �и���4,2,10,5,11,1,6,13,3,7
 *  �����4,10,11,5,2,13,6,7,3,1
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
		
		TreeNode root = list.get(1);//1�Ǹ��ڵ�
		
		List<Integer> res = postorderTravelsal(root);
		res.forEach(e->{System.out.print(e+" ");});
		
	}
	//������� (�ȸ���1,2,4,5,10,11,3,6,13,7)
//	public static List<Integer> preorderTravelsal(TreeNode root){
//		List<Integer> list = new ArrayList<Integer>();
//		if(root==null) return list;
//		Stack<TreeNode> stack = new Stack<TreeNode>();
//		TreeNode p = root;
	//�������ջ���������Ѿ����ʹ���Ԫ��
//		while(!stack.isEmpty() || p!=null){
//			if(p!=null){
//				list.add(p.val);//�ȷ��ʣ�����ջ����ջ��Ϊ�˺������Һ���
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
//		//��������������ǻ�û���ʹ���Ԫ��
//		while(!stack.isEmpty()){
//			TreeNode p = stack.pop();
//			list.add(p.val);
//			if(p.right!=null) stack.add(p.right);
//			if(p.left!=null) stack.add(p.left);
//		}
//		return list;
//	}

	
	//�������(�и���4,2,10,5,11,1,6,13,3,7)
//	public static List<Integer> inorderTravelsal(TreeNode root){
//		List<Integer> list = new ArrayList<Integer>();
//		if(root==null) return list;
//		Stack<TreeNode> stack = new Stack<TreeNode>();
//		TreeNode p = root;
//		//ջ��������δ�����ʵ�Ԫ��
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
//		//ջ��������δ�����ʵ�Ԫ��
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

	//��������������4,10,11,5,2,13,6,7,3,1��
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
