package Solutions;

import java.util.LinkedList;

import DataStructual.TreeNode;

public class ConvertSortedArraytoBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//д��һ���������鳤Ϊ2����1����ĵݹ�ķ���
	//��ʵҲ���Բ��ÿ�����ô��
//    public static TreeNode sortedArrayToBST(int[] nums) {
//       if(nums.length==0) return null;
//       int n = nums.length;
//       TreeNode root = creat(nums,0,n-1);
//       return root;
//    }
//    public  static TreeNode creat(int[] nums,int left,int right){
//    	if(left==right) 
//    		return new TreeNode(nums[left]);
//    	else if(right-left==1){
//    		if(nums[left]<nums[right]){
//    			TreeNode root = new TreeNode(nums[left]);
//    			root.right = new TreeNode(nums[right]);
//    			return root;
//    		}else{
//    			TreeNode root = new TreeNode(nums[right]);
//    			root.left = new TreeNode(nums[left]);
//    			return root;
//    		}
//    	}else{
//    		//
//    		int mid = left + (right-left+1)/2;
//        	TreeNode n = new TreeNode(nums[mid]);
//        	n.left = creat(nums,left,mid-1);
//        	n.right = creat(nums,mid+1,right);
//        	return n;
//    	}
    	
//    	
//    	
//    }
    
	//���ÿ�����ô������
//  public static TreeNode sortedArrayToBST(int[] nums) {
//	  if(nums.length == 0) return null;
//	  TreeNode head = helper(nums,0,nums.length-1);
//	  return head;
//  }
//  public static TreeNode helper(int[] nums, int low, int high){
//	  if(low>high) return null;
//	  int mid = (low+high)/2;
//	  TreeNode node = new TreeNode(nums[mid]);
//	  node.left = helper(nums,low,mid-1);
//	  node.right = helper(nums,mid+1,high);
//	  return node;
//	  
//  }
	
	//�ǵݹ��д��
	
}
