package Solutions;

import DataStructual.TreeNode;

public class MaxDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        
        //  /*用递归方法解决(1ms 10.20%)*/
        if(root==null) return 0;//根节点为空则深度为0
        int leftdepth = maxDepth(root.left);
        int rightdepth = maxDepth(root.right);
        return leftdepth>rightdepth ? leftdepth+1 : rightdepth+1;
        
        /*用非递归方法解决(3ms 5.26%)*/
    
        // if(root == null) {
        //     return 0;
        // }
        // Queue<TreeNode> queue = new LinkedList<>();
        // queue.offer(root);
        // int count = 0;
        // while(!queue.isEmpty()) {
        //     int size = queue.size();
        //     while(size-- > 0) {
        //         TreeNode node = queue.poll();
        //         if(node.left != null) {
        //             queue.offer(node.left);
        //         }
        //         if(node.right != null) {
        //             queue.offer(node.right);
        //         }
        //     }
        //     count++;
        // }
        // return count;
    }
}
