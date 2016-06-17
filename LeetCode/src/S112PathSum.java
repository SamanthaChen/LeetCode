import DataStructual.TreeNode;


public class S112PathSum {
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

}
