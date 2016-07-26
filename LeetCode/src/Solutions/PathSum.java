package Solutions;
import java.util.LinkedList;

import DataStructual.TreeNode;


public class PathSum {
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
	
	//递归的方法
  public static boolean hasPathSum1(TreeNode root, int sum) {
      if(root == null)
      	return false;
      if(root.left ==null && root.right==null)
      	return root.val == sum;
      return (hasPathSum1(root.left,sum-root.val) || hasPathSum1(root.right,sum-root.val));
    
  }
  
  //非递归的方法，用广度优先，当找到叶节点时候判断是否满足
  //用两个队列，一个存当前的路径，一个存经过该路径的和
  public static boolean hasPathSum11(TreeNode root, int sum){
      if(root == null)
      	return false;
      
      LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
      LinkedList<Integer> values = new LinkedList<Integer>();
      
      nodes.add(root);
      values.add(root.val);
      
      while(!nodes.isEmpty()){
      	TreeNode p = nodes.poll();
      	int pval = values.poll();
      	if(p.left==null && p.right==null && pval==sum) 
      		return true;
      	if(p.left!=null){
      		nodes.add(p.left);
      		values.add(pval+p.left.val);
      	}
      	if(p.right!=null){
      		nodes.add(p.right);
      		values.add(pval+p.right.val);
      	}
      	
      }
      return false;
  }

}
