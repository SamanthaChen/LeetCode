package DataStructual;

import java.util.LinkedList;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int x) { val = x; }
	/*
	 * 根据数组来创建树
	 * **/
	public TreeNode(int[] nums){
		LinkedList<TreeNode> nodelist = new LinkedList<TreeNode>();
		//将数组的每个元素都转换成树节点,并用一个表存
		for(int nodeindex = 0; nodeindex<nums.length;nodeindex++)
			nodelist.add(new TreeNode(nums[nodeindex]));
		//建立父节点与子节点的联系
		for(int parentindex = 0;parentindex<=nums.length/2-1;parentindex++){
			TreeNode parent = nodelist.get(parentindex);
			parent.left = nodelist.get(2*parentindex+1);//左孩子
			//需要考虑右孩子可能不存在的情况
//			if(2*parentindex+2<=nums.length-1){
				parent.right = nodelist.get(2*parentindex+2);//左孩子
//			}
		}
		this.val = nodelist.get(0).val;
		this.left = nodelist.get(0).left;
		this.right = nodelist.get(0).right;
		
		
	}

	public String toString(){

		return String.valueOf(val);
		
	}
	//用层次遍历写一个打印树的吧
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
