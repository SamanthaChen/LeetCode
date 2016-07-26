package Solutions;
import java.util.LinkedList;

import DataStructual.TreeNode;


public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        
        //stack+setʵ�ֵķ��ʱ�־ʵ��DFS��ֻ�е���Ҷ�ڵ�űȽϵ�ǰֵ�����򵯳�ջ�� ��������ȱ�����12ms 0.63%��
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
    //         else{//�Ѿ�����Ҷ�ڵ�����������ﶼ���ʹ���
    //             if((temp == sum) && (peek.left==null) &&  (peek.right==null) ) return true;//ֻ�е���Ҷ�ڵ���ܼ���·��ֵ
    //                  temp = temp-peek.val;//��ȥ����������Ԫ��ֵ
    //                  stack.pop();
    //         }
    //     }
    //   return false; 
    
    //�ݹ�ʵ��DFS(1ms 10.11%)
    if (root == null) return false;
    if( root.left == null && root.right == null) return root.val == sum;//����Ҷ�ڵ�
    return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//�ݹ�ķ���
  public static boolean hasPathSum1(TreeNode root, int sum) {
      if(root == null)
      	return false;
      if(root.left ==null && root.right==null)
      	return root.val == sum;
      return (hasPathSum1(root.left,sum-root.val) || hasPathSum1(root.right,sum-root.val));
    
  }
  
  //�ǵݹ�ķ������ù�����ȣ����ҵ�Ҷ�ڵ�ʱ���ж��Ƿ�����
  //���������У�һ���浱ǰ��·����һ���澭����·���ĺ�
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
