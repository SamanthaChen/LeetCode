package Solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import DataStructual.TreeNode;

public class FlattenBinaryTreeroLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		List<TreeNode> list = new ArrayList<TreeNode>();
		for(int i=0;i<nums.length;i++)
			list.add(new TreeNode(nums[i]));
		
		list.get(1).left=list.get(2);
		list.get(1).right=list.get(5);
		
		list.get(2).left=list.get(3);
		list.get(2).right=list.get(4);
		
//		list.get(5).left=list.get(6);
		list.get(5).right=list.get(6);
		

		
		TreeNode root = list.get(1);//1是根节点
	}
	//提示：变平的链表明显是按照先序排列的
    public void flatten(TreeNode root) {
    
    	TreeNode p = root;
    	Stack<TreeNode> stack = new  Stack<TreeNode>();
    	while(!stack.isEmpty() || p!=null){
    		if(p.right!=null) 
    			stack.push(p.right);
    		if(p.left!=null){
    			p.right = p.left;
    			p.left =null;
    		}else if(!stack.isEmpty()){
    			TreeNode n = stack.pop();
    			p.right = n;
    		}
    		p = p.right;//指针往后移
    	}
    	
    }


}
