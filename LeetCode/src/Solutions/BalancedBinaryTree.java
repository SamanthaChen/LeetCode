package Solutions;

import java.util.ArrayList;
import java.util.List;

import DataStructual.TreeNode;

public class BalancedBinaryTree {

	public static void main(String[] args) {
		int[] nums = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,4};
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
//		list.get(5).right=list.get(11);
		
//		list.get(6).right=list.get(13);
		
		TreeNode root = list.get(1);
		System.out.println(isBalanced(root));

	}
    public static boolean isBalanced(TreeNode root) {
    	if(root==null)
    		return true;
    	int left = getHeight(root.left);
    	int right = getHeight(root.right);
     
    	return Math.abs(left-right)<=1 && isBalanced(root.left) && isBalanced(root.right);
        
    }
    public static int getHeight(TreeNode root){
    	if(root==null) return 0;
    	return(Math.max(getHeight(root.left), getHeight(root.right))+1);
    	
    }
	

}
