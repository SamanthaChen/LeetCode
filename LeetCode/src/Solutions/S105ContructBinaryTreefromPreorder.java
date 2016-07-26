package Solutions;

import java.util.ArrayList;
import java.util.List;


import Solutions.S94BinaryTreeInorderTravelsal;
import Solutions.S145BinaryTreePostorderTraversal;

import DataStructual.TreeNode;

public class S105ContructBinaryTreefromPreorder {

	public static void main(String[] args) {

		int[] pre = {1,2,4,5,10,11,3,6,13,7};
		int[] in = {4,2,10,5,11,1,6,13,3,7};
		
		TreeNode root = buildTree(pre,in);
		
		List<Integer> prelist = S144BinaryTreePreorderTravelsal.preorderTraversal(root);
		System.out.println("先序遍历：");
		prelist.forEach(e->{System.out.print(e+" " );});
		System.out.println("");
		
		List<Integer> inlist = S94BinaryTreeInorderTravelsal.inorderTraversal(root);
		System.out.println("中序遍历：");
		inlist.forEach(e->{System.out.print(e+" " );});
		System.out.println("");
		

	}
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
    	
		return helper(0,0,inorder.length-1,preorder,inorder);
        
    }
    //需要三个数字，prestart 确定根在inorder中的位置，然后将inorder 剖开
    //变成左右子树，然后再对左右子树递归建立树。因此还需要给出左右子树分别的范围
    //instart，inend
    public static TreeNode helper(int prestart,int instart,int inend, int[] preorder, int[] inorder){
    	//递归结束条件
    	if(prestart>preorder.length-1 || instart>inend) return null;
    	TreeNode root = new TreeNode(preorder[prestart]);
    	//找到根节点在inorder中对应的位置
    	int i=0;
    	for(;i<inorder.length;i++){
    		if(inorder[i]==preorder[prestart])
    			break;
    	}
    	root.left = helper(prestart+1,instart,i-1,preorder,inorder);
    	//右子树开始位置应该=左子树开始位置+左子树长度
    	root.right = helper(prestart+1+i-instart,i+1,inend,preorder,inorder);
    	return root;
    }

}
