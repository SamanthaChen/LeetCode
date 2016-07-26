package Solutions;
/*
 * S144BinaryTreePreorderTravelsal ���� 
 * S94BinaryTreeInorderTravelsal.inorderTraversal  ����
 * S145BinaryTreePostorderTraversal.postorderTraversal ����
 * 
 * **/
import java.util.List;

import DataStructual.TreeNode;

public class ConstructBinaryTreeFromInorderandPostorder {

	public static void main(String[] args) {
		int[] pre = {1,2,4,5,10,11,3,6,13,7};
		int[] in = {4,2,10,5,11,1,6,13,3,7};
		int[] post = {4,10,11,5,2,3,6,7,3,1};
		
		TreeNode root = buildTree(in,post);//��������ͺ�����
		
		List<Integer> inlist = BinaryTreePreorderTravelsal.preorderTraversal(root);
		System.out.println("���������");
		inlist.forEach(e->{System.out.print(e+" " );});
		System.out.println("");
		
		List<Integer> postlist = BinaryTreePostorderTraversal.postorderTraversal(root);
		System.out.println("���������");
		postlist.forEach(e->{System.out.print(e+" " );});
		System.out.println("");

	}

	//������S105
	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		return helper(0,inorder.length-1,inorder,0,postorder.length-1,postorder);
	}
	public static TreeNode helper(int instart, int inend,int[] inorder,int poststart,int postend,int[] postorder){
		//�ݹ���ֹ����
		if(poststart>postend || instart>inend) return null;
		
		TreeNode root = new TreeNode(postorder[postend]);
		//�ҵ�root��inorderλ��
		int i=0;
		for(;i<inorder.length;i++){
			if(inorder[i]==postorder[postend])
				break;
		}

		//�Һ��ӳ��� = inend -i
		//���ӳ��� = i-instart
		//�Ӻ��������ָ��Խ�磬��ǰ��ӾͲ���
		root.left = helper(instart,i-1,inorder,poststart,poststart+i-instart-1,postorder);
		root.right = helper(i+1,inend,inorder,poststart+(i-instart),postend-1,postorder);
		return root;
	}
		
	
}
