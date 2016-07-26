package Solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import DataStructual.TreeNode;

public class BinaryTreeLevelOrderTraversal {
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
    	// //��α�������һ�����к�����int��¼��ǰ��νڵ�������һ����νڵ����� 87ms��0.06%
        //  List<List<Integer>> res = new ArrayList<List<Integer>>();//������
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
        //     if (node!=null) list.add(node.val);//����һ�ξʹ�һ��
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
        //         list.clear() ;//��һ��ı�������,���
        //     } 
            
        // }
        // //��������з�ת
        // Collections.reverse(res);
        // return res;
        
        //��α���,�������������������,�ö��У�ѭ��������ÿ�ν����������б���(10.19% 4ms)
        // List<List<Integer>> res = new ArrayList<List<Integer>>();//������
        // if(root == null) return res;
        // Queue<TreeNode> q = new LinkedList<TreeNode>();
        // q.offer(root);
        // while(!q.isEmpty()){
        //     int levelnum = q.size();
        //     List<Integer> l = new ArrayList<Integer>();//�洢һ��Ľڵ�
        //     for(int i=0;i<levelnum;i++){//����һ��Ľ��з��ʲ��������
        //         TreeNode node = q.poll();
        //         l.add(node.val);
        //         if(node.left!=null) q.offer(node.left);
        //         if(node.right!=null) q.offer(node.right);
        //     }
        //     //һ���������,ÿ�ν��ò�η��ڵ�һλ
        //     res.add(0,l);
        // }
        // return res;
        
        //�ݹ��DFS���BFS(81.17% 2ms)
        List<List<Integer>> res = new ArrayList<List<Integer>>();//������
        if(root == null) return res;
        levelHelper(res,root,0);
        return res;
    }
    public static void levelHelper(List<List<Integer>> res,TreeNode root,int height){
        if(root == null) return;//���ص���chu
        if(height>=res.size()) res.add(0,new ArrayList<Integer>());//�ڶ�����չ�µĲ��
        levelHelper(res, root.left,height+1);
        levelHelper(res, root.right,height+1);
        res.get(res.size()-1-height).add(root.val);//����ȱ��������������ڶ�Ӧ�Ĳ�ν�rootֵ����ȥ
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
