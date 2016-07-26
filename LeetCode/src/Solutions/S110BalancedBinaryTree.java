package Solutions;

import DataStructual.TreeNode;

public class S110BalancedBinaryTree {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean isBalanced(TreeNode root) {
        // //递归求左右子树深度的方法 原来超时，改进后1ms，87.6%（【关键地方：每次递归检查左右子树高度差，防止无用的搜索】）
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
 
        return depth(root)!=-1;
        
        // 非递归的方法
        
        
        
    }
    // 递归时候采用的函数
    public int depth(TreeNode root){//除了求深度，应该及时根据不平衡的子树进行退出。
        int d=0;
        if(root == null) return 0;
    
        int ld = depth(root.left);//左子树的深度
        if(ld == -1) return -1;
        int rd = depth(root.right);//右子树的深度
        if(rd == -1) return -1;
        if(ld-rd<-1 || ld-rd>1) return -1;//左右子树深度相差大于1,返回负的
        //否则深度按照左右子树最大的+1算
        return ld>rd? ld+1:rd+1;
    }
    
    //根据定义写的，左右子树高度差不超过1且左右子树都是平衡的
    public static boolean isBalanced1(TreeNode root) {
    	if(root==null)
    		return true;
    	int left = getHeight(root.left);
    	int right = getHeight(root.right);
     
    	return Math.abs(left-right)<=1 && isBalanced1(root.left) && isBalanced1(root.right);
        
    }
    public static int getHeight(TreeNode root){
    	if(root==null) return 0;
    	return(Math.max(getHeight(root.left), getHeight(root.right))+1);
    	
    }


}
