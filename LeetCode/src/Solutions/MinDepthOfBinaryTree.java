package Solutions;

import DataStructual.TreeNode;

public class MinDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        //采用递归的广度优先（1ms 12.17%）
        if (root == null) return 0;
        int leftdepth = minDepth(root.left);
        int rightdepth = minDepth(root.right);
        //仅有一个儿子为空的不是叶子节点，不能直接采用左右子节点的最小值+1
        return (leftdepth==0 || rightdepth == 0)? leftdepth+rightdepth+1:Math.min(leftdepth,rightdepth)+1;
       
    }
}
