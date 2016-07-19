package Solutions;

public class S73SetMatrixZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //˼·1��һ�߱���һ����Ϊ0��Ӱ�������жϣ������ö���ռ��¼һ��
    //��һ��m+n�����¼(2ms 26%)
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if(matrix==null || m<=0 ) return;
        int n = matrix[0].length;
        boolean[] pos = new boolean[m+n];
        //��һ���������¼0��λ��
        for(int i = 0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]==0){
                    pos[i]=true;
                    pos[j+m]=true;
                }
            }
        }
        //�ڶ����������Ϊ0
        for(int i = 0; i<m; i++){
            for(int j=0; j<n; j++){
                if(pos[i]==true || pos[m+j]==true) matrix[i][j]=0;
            }
        }
    }

}
