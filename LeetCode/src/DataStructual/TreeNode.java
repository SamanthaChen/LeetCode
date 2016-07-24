package DataStructual;

import java.util.LinkedList;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int x) { val = x; }
	/*
	 * ����������������
	 * **/
	public TreeNode(int[] nums){
		LinkedList<TreeNode> nodelist = new LinkedList<TreeNode>();
		//�������ÿ��Ԫ�ض�ת�������ڵ�,����һ�����
		for(int nodeindex = 0; nodeindex<nums.length;nodeindex++)
			nodelist.add(new TreeNode(nums[nodeindex]));
		//�������ڵ����ӽڵ����ϵ
		for(int parentindex = 0;parentindex<=nums.length/2-1;parentindex++){
			TreeNode parent = nodelist.get(parentindex);
			parent.left = nodelist.get(2*parentindex+1);//����
			//��Ҫ�����Һ��ӿ��ܲ����ڵ����
//			if(2*parentindex+2<=nums.length-1){
				parent.right = nodelist.get(2*parentindex+2);//����
//			}
		}
		this.val = nodelist.get(0).val;
		this.left = nodelist.get(0).left;
		this.right = nodelist.get(0).right;
		
		
	}

	public String toString(){

		return String.valueOf(val);
		
	}
	//�ò�α���дһ����ӡ���İ�
//	public void print(){
////		StringBuffer sb = new StringBuffer();
//		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
//		queue.add(this);
//		while(!queue.isEmpty()){
//			TreeNode p = queue.poll();
//			System.out.print(p.val+" ");
//			if(p.left!=null) queue.offer(p.left);
//			if(p.right!=null) queue.offer(p.right);
//		}
//		
//		
//		
//	}
//	
}
