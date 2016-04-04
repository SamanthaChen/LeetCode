package Solutions;

import java.util.List;
import java.util.ArrayList;

import DataStructual.TreeNode;

public class S102BinaryTreeLevalOrderTravel {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //先写一个循环的BFS(3ms 14.37%)
        // Queue<TreeNode> q = new LinkedList<TreeNode> ();
        // List<List<Integer>> res = new ArrayList<List<Integer>>();
        // if(root == null) return res;
        // q.offer(root);
        // int qsize;
        // while(!q.isEmpty()){
        //     qsize = q.size();//记录层次数数目
        //     List<Integer> levellist = new ArrayList<Integer>();//记录每一层的id
        //     for(int i=0;i<qsize;i++){
        //         TreeNode node = q.remove();
        //         levellist.add(node.val);
        //         if(node.left!=null) q.offer(node.left);
        //         if(node.right!=null) q.offer(node.right);
        //     }
        //     //一层遍历完了
        //     res.add(levellist);
            
        // }
        // return res;
        
        //递归 DFS实现层次遍历(2ms 60.74%)
    	ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;
        levelHelper(res,root,0);
        return res;
    }
    public void  levelHelper(List<List<Integer>> res , TreeNode root,int height){
        if(root == null) return;//返回调用的地方
        if(height>=res.size())//当前树的深度大于当前结果数组的层数
            res.add(new ArrayList<Integer>());//扩展层数
            
        //其他，按照层次加入到相应的地方
        res.get(height).add(root.val);
        levelHelper(res,root.left,height+1);
        levelHelper(res,root.right,height+1);
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
