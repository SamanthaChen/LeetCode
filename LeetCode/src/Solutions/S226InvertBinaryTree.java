package Solutions;

import DataStructual.TreeNode;

public class S226InvertBinaryTree {
	public TreeNode invertTree(TreeNode root){
		if(root == null) return root;
		TreeNode temp = root.left;
		root.left = invertTree(root.right);
		root.right = invertTree(temp);
		return root;
		
	}
}
