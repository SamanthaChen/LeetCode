package Solutions;

public class S62UniquePath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //�ⷨ������O(m*n)ʱ��
    // public int uniquePaths(int m, int n) {
    //     if(m<1 || n<1) return 0;
    //     int[][] f = new int[m][n];
    //     //��һ�к͵�һ�г�ʼ��һ��
    //     for(int i=0; i< m; i++) f[i][0]=1;
    //     for(int j=0; j< n; j++) f[0][j]=1;
    //     for(int i=1; i< m; i++){
    //         for(int j=1; j< n; j++){
    //             f[i][j] = f[i-1][j] + f[i][j-1];
    //         }
    //     }
    //     return f[m-1][n-1];
    // }
    
    //�򻯵Ľⷨ�����ö�ά���飬��һ��һλ����,һ��һ�е�ɨ�������
    public int uniquePaths(int m, int n){
        int[] current = new int[n];
        for(int i = 0 ; i < n ; i++ ) current[i] = 1 ;
     
        for(int i = 1; i < m ; i++){
            for(int j = 1; j < n; j++){
                current[j] += current[j-1];
            }
        }
        return current[n-1];
        
    }

}
