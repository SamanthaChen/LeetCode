package Solutions;

import DataStructual.TreeNode;

public class LowestCommonAncesterofBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //我的方法，采用递归
        // if(root == null || p == null || q == null) return null;
        // if(p.val == q.val) return p;//两个节点相等，直接返回
        
        // if(p.val < root.val && q.val < root.val ) return lowestCommonAncestor(root.left,p,q);//两个节点都小于root，往左边找
        // if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right,p,q);//两个节点都大于root，往右边找
        
        // return root;//root在p，q在中间 直接返回
        
        //不采用递归的方法
        while((root.val-p.val)*(root.val-q.val) > 0){
           //说明在树的同一边
           root = p.val > root.val ? root.right : root.left;//分别往右边查找或左边查找
        }
        return root;//根在两个点中间直接返回
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
