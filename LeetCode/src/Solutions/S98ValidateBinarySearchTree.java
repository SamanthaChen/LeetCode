package Solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import DataStructual.TreeNode;

public class S98ValidateBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		List<TreeNode> list = new ArrayList<TreeNode>();
		for(int i=0;i<nums.length;i++)
			list.add(new TreeNode(nums[i]));
		
		list.get(4).left=list.get(3);
		list.get(4).right=list.get(5);
		
//		list.get(3).left=list.get(1);
//		list.get(3).right=list.get(2);
//		
//		list.get(5).left=list.get(6);
//		list.get(5).right=list.get(7);
		

		
		TreeNode root = list.get(4);//1�Ǹ��ڵ�
		System.out.println(isValidBST(root));
		

	}
	//˼·�����������ֵ<root,��������Сֵ>root
	//����������Сֵ�ķ����Ѿ�ʧЧ����Ϊ���ܴ��ڽڵ�ֱ������ֵ������Сֵ�����
//    public static boolean isValidBST(TreeNode root) {
//    	return isValid(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
//    }
//    public static boolean isValid(TreeNode p,int min, int max){
//    	if(p==null) return true;
//    	if(p.val <= min || p.val >= max)return false;
//    	return (isValid(p.left,min,p.val) && isValid(p.right,p.val,max));
//    }
    
    //�ǵݹ�ķ���
	//˼·���������Ӧ����һ������������,��list���������У����ж�һ���ǲ��Ƿ��ϵ�������ҪO(n)ʱ��ռ�
//    public static boolean isValidBST(TreeNode root) {
//    	List<Integer> list = new ArrayList<Integer>();
//    	Stack<TreeNode> stack = new Stack<TreeNode>();
//    	TreeNode  p = root;
//    	while(!stack.isEmpty() || p!=null){
//    		if(p!=null){
//    			stack.add(p);
//    			p=p.left;
//    		}else{
//    			TreeNode q = stack.pop();
//    			list.add(q.val);
//    			p=q.right;
//    		}
//    	}
//    	for(int i=0;i<list.size()-1;i++){
//    		if(list.get(i)>=list.get(i+1)) return false;
//    	}
//    	return true;
//    	
//    	
//    }
    //�ǵݹ�ķ���
	//˼·���������Ӧ����һ������������,�ڱ���ʱ���ǰһ���ڵ�͵�ǰ�ڵ㣬�ж�һ���ǲ��ǵ�����
    public static boolean isValidBST(TreeNode root){
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	TreeNode  p = root;
    	TreeNode pre = null;//��ǰһ�������Ľڵ�
    	while(!stack.isEmpty()|| p!=null){
    		if(p!=null){
    			stack.add(p);
    			p=p.left;
    		}else{
    			TreeNode n = stack.pop();//��ջ���浯��������Ҫ������
    			if(pre!=null && pre.val >= n.val) 
    				return false;
    			pre = n;
    			p = n.right;
    		}
    	}
    	return true;
    }

}
