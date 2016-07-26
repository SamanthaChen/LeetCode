package Solutions;

public class UniqueBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	   public int numTrees(int n) {
	        // 解题思路，假设F(i,n)是以i为根，长度为n的unique二叉搜索树的个数，G(n)是长度为n的unique搜索树个数，
	        // 按照搜索树左右两边划分有
	        // F(i,n) = G(i-1)*G(n-i)
	        // 则G(n)= F(1,n)+F(2,n)+...+F(3,n) =G(0)*G(n-1)+...+G(n-1)*G(0)
	        if(n < 2) return 1; 
	        int[] G = new int[n+1];
	        G[0] = 1;
	        G[1] = 1;
	        for(int i = 2; i <= n; ++i){
	            for(int j = 0 ; j < i ; ++j){
	                G[i] += G[j]*G[i-1-j];
	            }
	        }
	         return G[n];
	        
	    }
}
