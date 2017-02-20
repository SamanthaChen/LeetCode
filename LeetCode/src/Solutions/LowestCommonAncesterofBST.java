package Solutions;

import DataStructual.TreeNode;

public class LowestCommonAncesterofBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //�ҵķ��������õݹ�
        // if(root == null || p == null || q == null) return null;
        // if(p.val == q.val) return p;//�����ڵ���ȣ�ֱ�ӷ���
        
        // if(p.val < root.val && q.val < root.val ) return lowestCommonAncestor(root.left,p,q);//�����ڵ㶼С��root���������
        // if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right,p,q);//�����ڵ㶼����root�����ұ���
        
        // return root;//root��p��q���м� ֱ�ӷ���
        
        //�����õݹ�ķ���
        while((root.val-p.val)*(root.val-q.val) > 0){
           //˵��������ͬһ��
           root = p.val > root.val ? root.right : root.left;//�ֱ����ұ߲��һ���߲���
        }
        return root;//�����������м�ֱ�ӷ���
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
