import DataStructual.TreeNode;


public class S112PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        
        //stack+set实现的访问标志实现DFS，只有到达叶节点才比较当前值，否则弹出栈顶 并继续深度遍历（12ms 0.63%）
    //     if(root == null) return false;
    //     Stack<TreeNode> stack = new Stack<TreeNode>();
    //     Set<TreeNode> visited = new HashSet<TreeNode>();
    //     stack.push(root);
    //     visited.add(root);
    //     int temp = root.val;
    //     while(!stack.isEmpty()){
    //         TreeNode peek = stack.peek();
    //         if(peek.left!=null && (!visited.contains(peek.left))){
    //             stack.push(peek.left);
    //             visited.add(peek.left);
    //             temp += peek.left.val;
    //         }
    //         else if(peek.right!=null && (!visited.contains(peek.right))){
    //             stack.push(peek.right);
    //             visited.add(peek.right);
    //             temp += peek.right.val;
    //         }
    //         else{//已经到达叶节点或者左右子孙都访问过了
    //             if((temp == sum) && (peek.left==null) &&  (peek.right==null) ) return true;//只有到达叶节点才能计算路径值
    //                  temp = temp-peek.val;//减去即将弹出的元素值
    //                  stack.pop();
    //         }
    //     }
    //   return false; 
    
    //递归实现DFS(1ms 10.11%)
    if (root == null) return false;
    if( root.left == null && root.right == null) return root.val == sum;//到达叶节点
    return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
