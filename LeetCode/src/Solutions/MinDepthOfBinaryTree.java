package Solutions;

import DataStructual.TreeNode;

public class MinDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        //���õݹ�Ĺ�����ȣ�1ms 12.17%��
        if (root == null) return 0;
        int leftdepth = minDepth(root.left);
        int rightdepth = minDepth(root.right);
        //����һ������Ϊ�յĲ���Ҷ�ӽڵ㣬����ֱ�Ӳ��������ӽڵ����Сֵ+1
        return (leftdepth==0 || rightdepth == 0)? leftdepth+rightdepth+1:Math.min(leftdepth,rightdepth)+1;
       
    }
}
