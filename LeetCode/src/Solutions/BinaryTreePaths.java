package Solutions;

import java.util.ArrayList;
import java.util.List;

import DataStructual.TreeNode;

public class BinaryTreePaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1
		//2 3
		//null 4 5 null
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		n1.left = n2;
		n1.right = n3;
		n2.right = n4;
		n3.left = n5;
		List<String> res = binaryTreePaths(n1);
		for(String s : res){
			System.out.println(s);
		}
		
		
	}
    public static List<String> binaryTreePaths(TreeNode root) {
        //µÝ¹éµÄ
        List<String> res = new ArrayList<String>();
        if(root!=null) printPath(root,"",res);
        return res;
    }
    public static void printPath(TreeNode root, String path, List<String> res){
        if(root.left == null && root.right ==null) res.add(path+root.val);
        if(root.left!=null) printPath(root.left, path+root.val+"->", res);
        if(root.right!=null) printPath(root.right, path+root.val+"->",res);
        
    }

}
