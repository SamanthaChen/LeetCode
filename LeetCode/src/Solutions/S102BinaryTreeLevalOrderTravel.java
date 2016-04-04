package Solutions;

import java.util.List;
import java.util.ArrayList;

import DataStructual.TreeNode;

public class S102BinaryTreeLevalOrderTravel {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //��дһ��ѭ����BFS(3ms 14.37%)
        // Queue<TreeNode> q = new LinkedList<TreeNode> ();
        // List<List<Integer>> res = new ArrayList<List<Integer>>();
        // if(root == null) return res;
        // q.offer(root);
        // int qsize;
        // while(!q.isEmpty()){
        //     qsize = q.size();//��¼�������Ŀ
        //     List<Integer> levellist = new ArrayList<Integer>();//��¼ÿһ���id
        //     for(int i=0;i<qsize;i++){
        //         TreeNode node = q.remove();
        //         levellist.add(node.val);
        //         if(node.left!=null) q.offer(node.left);
        //         if(node.right!=null) q.offer(node.right);
        //     }
        //     //һ���������
        //     res.add(levellist);
            
        // }
        // return res;
        
        //�ݹ� DFSʵ�ֲ�α���(2ms 60.74%)
    	ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;
        levelHelper(res,root,0);
        return res;
    }
    public void  levelHelper(List<List<Integer>> res , TreeNode root,int height){
        if(root == null) return;//���ص��õĵط�
        if(height>=res.size())//��ǰ������ȴ��ڵ�ǰ�������Ĳ���
            res.add(new ArrayList<Integer>());//��չ����
            
        //���������ղ�μ��뵽��Ӧ�ĵط�
        res.get(height).add(root.val);
        levelHelper(res,root.left,height+1);
        levelHelper(res,root.right,height+1);
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
