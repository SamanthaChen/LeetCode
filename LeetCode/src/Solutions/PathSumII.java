package Solutions;

import java.util.ArrayList;
import java.util.List;

import DataStructual.TreeNode;

public class PathSumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,4};
		List<TreeNode> list = new ArrayList<TreeNode>();
		for(int i=0;i<nums.length;i++)
			list.add(new TreeNode(nums[i]));
		
		list.get(5).left=list.get(4);
		list.get(5).right=list.get(8);
		
		list.get(4).left=list.get(11);
		
		list.get(8).left=list.get(13);
		list.get(8).right=list.get(16);//第2个4
		
		list.get(11).left=list.get(7);
		list.get(11).right=list.get(2);
		
		list.get(16).right=list.get(1);
		
		TreeNode root = list.get(5);
		List<List<Integer>> res = pathSum(root,22);
		for(List<Integer> l : res){
			for(int e :l){
				System.out.print(e+" ");
			}
			System.out.println("");
		}
	}
	
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	List<Integer> list = new ArrayList<Integer>();
    	if(root == null) return res;
    	helper(res,list,root,sum);
    	return res;	
    		
    }
    public static void helper(List<List<Integer>> res, List<Integer> list, TreeNode root,int sum){
    	//递归停止条件
    	if(root==null) return;
    	
    	list.add(root.val);
    	//访问到叶节点了
    	if(root.left == null && root.right == null && root.val == sum){
    		res.add(new ArrayList<Integer>(list));
    	}else{
        	//不是叶节点
        	helper(res, list, root.left,sum-root.val);
        	helper(res, list, root.right,sum-root.val);
    	}
    	//返回上一层之前把这一层最后一个数删掉
    	list.remove(list.size()-1);

    }

}
