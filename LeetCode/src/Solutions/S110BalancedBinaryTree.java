package Solutions;

import DataStructual.TreeNode;

public class S110BalancedBinaryTree {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean isBalanced(TreeNode root) {
        // //�ݹ�������������ȵķ��� ԭ����ʱ���Ľ���1ms��87.6%�����ؼ��ط���ÿ�εݹ������������߶Ȳ��ֹ���õ���������
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
 
        return depth(root)!=-1;
        
        // �ǵݹ�ķ���
        
        
        
    }
    // �ݹ�ʱ����õĺ���
    public int depth(TreeNode root){//��������ȣ�Ӧ�ü�ʱ���ݲ�ƽ������������˳���
        int d=0;
        if(root == null) return 0;
    
        int ld = depth(root.left);//�����������
        if(ld == -1) return -1;
        int rd = depth(root.right);//�����������
        if(rd == -1) return -1;
        if(ld-rd<-1 || ld-rd>1) return -1;//�����������������1,���ظ���
        //������Ȱ���������������+1��
        return ld>rd? ld+1:rd+1;
    }
    
    //���ݶ���д�ģ����������߶Ȳ����1��������������ƽ���
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
