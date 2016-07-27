package Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import DataStructual.TreeNode;

public class MinimumDepthofBTree {

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
		System.out.println(minDepth(root));

	}
	//�õݹ�
//    public static int minDepth(TreeNode root) {
//        if(root==null) return 0;
//        int n1 = minDepth(root.left);
//        int n2 = minDepth(root.right);
//        //ע���������������Ϊ�ջ����Һ���Ϊ�յ�ʱ����ֱ��ȡ��Сֵ+1
//        return (n1==0 || n2==0) ? (n1+n2+1) : Math.min(n1, n2)+1
//    }

	//���õݹ�͹������
	//������list��ڵ�Ͳ���
    public static int minDepth(TreeNode root) {
        if(root==null) return 0;
        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        LinkedList<Integer> levels = new LinkedList<Integer>();
        nodes.add(root);
        levels.add(1);
        
        while(!nodes.isEmpty()){
        	TreeNode p = nodes.poll();
        	int level = levels.poll();
        	if(p.left == null && p.right ==null ) 
        		return level;
        	if(p.left!=null) {
        		nodes.add(p.left);
        		levels.add(level+1);
        	}
        	if(p.right!=null){
        		nodes.add(p.right);
        		levels.add(level+1);
        	}
        }
        return 0;

    }
}
