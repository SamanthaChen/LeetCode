package Solutions;

public class UniqueBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	   public int numTrees(int n) {
	        // ����˼·������F(i,n)����iΪ��������Ϊn��unique�����������ĸ�����G(n)�ǳ���Ϊn��unique������������
	        // �����������������߻�����
	        // F(i,n) = G(i-1)*G(n-i)
	        // ��G(n)= F(1,n)+F(2,n)+...+F(3,n) =G(0)*G(n-1)+...+G(n-1)*G(0)
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
