package Solutions;

import java.util.ArrayList;
import java.util.List;

import DataStructual.TreeNode;

public class LowestCommonAncestorofaBinaryTree {

	public static void main(String[] args) {
//		*		 
//		 * 		   1
//		 * 		 /   \
//		 *		2	  3
//		 *     / \   /  \  
//		 *    4	  5  6  7
//		 *       / \  \
//		 *      10 11 13  
//		 *      
//		 *  �ȸ���1,2,4,5,10,11,3,6,13,7
//		 *  �и���4,2,10,5,11,1,6,13,3,7
//		 *  �����4,10,11,5,2,13,6,7,3,1
//		 * **/
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
				
				TreeNode res =lowestCommonAncestor(root,list.get(4),list.get(5)); 
				System.out.print(res.val);

	}
	//˼·1�������ⷨ
	
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	
    	if(root==null || p==null || q==null) return null;
    	if(root==p || root == q) return root;
    	TreeNode left = lowestCommonAncestor(root.left,p,q);
    	TreeNode right = lowestCommonAncestor(root.right,p,q);
    	if(left!=null && right!=null) return root;//����ߺ����ұ߶��ֱ��ҵ��� p ��q������ڵ���LCA
    	else if(left!=null) return left; //�ұ��Ҳ���P��q���������
    	else if(right!=null) return right;//����Ҳ���p��q�����ұ���
    	else
    		return null;
    }

}
