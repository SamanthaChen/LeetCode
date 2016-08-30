package Test;

import java.util.ArrayList;
import java.util.List;

import DataStructual.TreeNode;

public class PathSumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	helper(root,sum,res,new ArrayList<Integer>());
    	return res;
    }
    public void helper(TreeNode root, int sum, List<List<Integer>> res, List<Integer> list ){
    	if(root==null) return;
    	list.add(root.val);
    	if(root.left==null && root.right==null && root.val ==sum) {
    		res.add(new ArrayList<Integer>(list));
    	}else{
    		helper(root.left,sum-root.val,res,list);
    		helper(root.right,sum-root.val,res,list);
    	}
    	list.remove(list.size()-1);
    }

}
