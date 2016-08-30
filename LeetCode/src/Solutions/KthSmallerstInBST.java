package Solutions;

import java.util.List;
import java.util.Stack;

import DataStructual.TreeNode;

public class KthSmallerstInBST {

	public static void main(String[] args) {
//		              10
//		           6     14
//		         4   8  12
		TreeNode n1 = new TreeNode(4);
		TreeNode n2 = new TreeNode(6);
		TreeNode n3 = new TreeNode(8);
		TreeNode n4 = new TreeNode(10);
		TreeNode n5 = new TreeNode(12);
		TreeNode n6 = new TreeNode(14);
		//1 2 3 4  5  6
		//4 6 8 10 12 14
		n4.left = n2;
		n4.right = n6;
		n2.left = n1;
		n2.right = n3;
		n6.left = n5;
	
		int res = kthSmallest(n4,0);
		System.out.println(res);
	}
	
	//˼·1���������������ջ��ʱ��k-1��k==0�Ľڵ����
    public static int kthSmallest1(TreeNode root, int k) {
    	
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	while(root!=null || !stack.isEmpty()){
    		if(root!=null){
    			stack.push(root);
    			root = root.left;
    		}else{
    			TreeNode node = stack.pop();
    			if(k==1){
    				return node.val;
    			}else{
    				root=node.right;
    				k--;
    			}
    		}
    	}
    	return 0;//û�ҵ�
        
    }
	//˼·2���ö��ֲ���
    public static int kthSmallest2(TreeNode root, int k) {
   
    	int count = countNum(root.left);
    	if(k<=count){
    		return kthSmallest(root.left,k);
    	}
    	else if(k>count+1){
    		return kthSmallest(root.right,k-1-count);
    	}
    		
    	return root.val;
    		

    }
    public static int countNum(TreeNode root){
    	if(root==null) return 0;
    	return countNum(root.left)+countNum(root.right)+1;
    	
    }
    
	//˼·3��BFS ��ʵ�Ҹо�Ҳ�����������ֻ����ջ���ڼ�����ڲ����õݹ�ʵ�ֵ�
    private static int count;
    private static int number;
    public static int kthSmallest(TreeNode root, int k) {
    	count = k;
    	helper(root);
    	return number;
    }
    public static void helper(TreeNode root){
    	if(root.left!=null) helper(root.left);
    	count--;
    	if(count == 0){
    		number = root.val;
    		return;
    	}
    	if(root.right!=null)helper(root.right);
    }
}
