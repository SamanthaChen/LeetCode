package Solutions;

import java.util.Stack;

import DataStructual.TreeNode;

public class S101SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
    //     采用递归，递归的检查左右子树对应位置是否是一样的(1ms,22.55%)
    //     if(root == null) return true;
    //     return isMirror(root.left, root.right);
    // }
    // public boolean isMirror(TreeNode left,TreeNode right){
    //     if(left == null && right == null) return true;
    //     if(left ==null || right == null) return false;
    //     if(left.val == right.val) 
    //         return isMirror(left.left,right.right) && isMirror(left.right,right.left);
    //     return false;
    // }
    
    //非递归的方法，采用栈（3ms，6%）
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        if(root.left == null || root.right == null) return false;
    
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root.left);
        stack.push(root.right);
        while(!stack.empty()){
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();
            if(left.val != right.val) return false;
 

            if(left.left == null){
                if(right.right!=null) return false;
            }
            if(left.left!=null){
                if(right.right == null) return false;
                stack.push(left.left);
                stack.push(right.right);
            }
            if(left.right==null){
                if(right.left != null) return false;
            }
            if(left.right!=null){
                if(right.left == null) return false;
                stack.push(left.right);
                stack.push(right.left);
            }
                
        }
        return true;
    }//isSy
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
