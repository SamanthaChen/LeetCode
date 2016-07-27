package Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import DataStructual.TreeNode;

public class PathSum {

	public static void main(String[] args) {
		int[] nums = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		List<TreeNode> list = new ArrayList<TreeNode>();
		for(int i=0;i<nums.length;i++)
			list.add(new TreeNode(nums[i]));
		
		list.get(5).left=list.get(4);
		list.get(5).right=list.get(8);
		
		list.get(4).left=list.get(11);
		
		list.get(8).left=list.get(13);
		list.get(8).right=list.get(5);
		
		list.get(11).left=list.get(7);
		list.get(11).right=list.get(2);
		
		list.get(5).right=list.get(0);
		
		TreeNode root = list.get(5);
		System.out.println(hasPathSum(root,22));
		

	}
	//递归的方法
//    public static boolean hasPathSum(TreeNode root, int sum) {
//        if(root == null)
//        	return false;
//        if(root.left ==null && root.right==null)
//        	return root.val == sum;
//        return (hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val));
//      
//    }
    //非递归的方法，用广度优先，当找到叶节点时候判断是否满足
    //用两个队列，一个存当前的路径，一个存经过该路径的和
    public static boolean hasPathSum(TreeNode root, int sum){
        if(root == null)
        	return false;
        
        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        LinkedList<Integer> values = new LinkedList<Integer>();
        
        nodes.add(root);
        values.add(root.val);
        
        while(!nodes.isEmpty()){
        	TreeNode p = nodes.poll();
        	int pval = values.poll();
        	if(p.left==null && p.right==null && pval==sum) 
        		return true;
        	if(p.left!=null){
        		nodes.add(p.left);
        		values.add(pval+p.left.val);
        	}
        	if(p.right!=null){
        		nodes.add(p.right);
        		values.add(pval+p.right.val);
        	}
        	
        }
        return false;
    }

}
