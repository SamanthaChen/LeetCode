package Solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import DataStructual.TreeNode;

public class BinaryTreeLevelOrderTraversal {
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
    	// //层次遍历（用一个队列和两个int记录当前层次节点数和下一个层次节点数） 87ms，0.06%
        //  List<List<Integer>> res = new ArrayList<List<Integer>>();//保存结果
        // if(root == null) return res;
        // Queue<TreeNode> queue = new LinkedList<TreeNode>();
        // queue.add(root);
        // int prenum = 1;
        // int nextnum = 0;
        // List<Integer> list = new ArrayList<Integer>();
        // while(!queue.isEmpty()){
        //     TreeNode node = queue.poll();
        //     System.out.println(node.val);
        //     prenum--;
        //     if (node!=null) list.add(node.val);//弹出一次就存一次
        //     if(node.left != null) {
        //         queue.offer(node.left);
        //         System.out.println(node.left.val);
        //         nextnum++;
        //     }
        //     if(node.right!=null) {
        //         queue.offer(node.right);
        //         System.out.println(node.right.val);
        //         nextnum++;
        //     }
        //     if (prenum == 0){
        //         prenum = nextnum;
        //         nextnum =0;
        //         List<Integer> newlist = new ArrayList<Integer>();
        //         newlist.addAll(list);
        //         res.add(newlist);
        //         System.out.println(newlist);
        //         list.clear() ;//这一层的遍历完了,清空
        //     } 
            
        // }
        // //将结果进行翻转
        // Collections.reverse(res);
        // return res;
        
        //层次遍历,不用两个数来保存层数,用队列，循环，并且每次将层数插入列表首(10.19% 4ms)
        // List<List<Integer>> res = new ArrayList<List<Integer>>();//保存结果
        // if(root == null) return res;
        // Queue<TreeNode> q = new LinkedList<TreeNode>();
        // q.offer(root);
        // while(!q.isEmpty()){
        //     int levelnum = q.size();
        //     List<Integer> l = new ArrayList<Integer>();//存储一层的节点
        //     for(int i=0;i<levelnum;i++){//将这一层的进行访问并存入儿子
        //         TreeNode node = q.poll();
        //         l.add(node.val);
        //         if(node.left!=null) q.offer(node.left);
        //         if(node.right!=null) q.offer(node.right);
        //     }
        //     //一层访问完了,每次将该层次放在第一位
        //     res.add(0,l);
        // }
        // return res;
        
        //递归的DFS完成BFS(81.17% 2ms)
        List<List<Integer>> res = new ArrayList<List<Integer>>();//保存结果
        if(root == null) return res;
        levelHelper(res,root,0);
        return res;
    }
    public static void levelHelper(List<List<Integer>> res,TreeNode root,int height){
        if(root == null) return;//返回调用chu
        if(height>=res.size()) res.add(0,new ArrayList<Integer>());//在队首扩展新的层次
        levelHelper(res, root.left,height+1);
        levelHelper(res, root.right,height+1);
        res.get(res.size()-1-height).add(root.val);//先深度遍完左右子孙再在对应的层次将root值添上去
    }
        
        
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t3 = new TreeNode(3);
		TreeNode t9 = new TreeNode(9);
		TreeNode t20 = new TreeNode(20);
		TreeNode t15 = new TreeNode(15);
		TreeNode t7 = new TreeNode(7);
		t3.left = t9;
		t3.right = t20;
		t20.left = t15;
		t20.right = t7;
		List<List<Integer>> res=levelOrderBottom(t3);
		System.out.println("res:");
		for(List<Integer> list : res){
				System.out.println(list);
		}
		
	}

}
