package Solutions;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m=3;
		int n=3;
		int[][] matrix = new int[m][n];
		int k=1;
		for(int i = 0; i<m;i++){
			for(int j=0;j<n;j++){
				matrix[i][j]=k++;
			}
		}
		List<Integer> res = spiralOrder(matrix);
		res.forEach(e->{System.out.print(e+"\t");});
	}
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return res;
        int m = matrix.length;
        int n = matrix[0].length;
        
        int top = 0;
        int bottom = m-1;
        int left = 0;
        int right = n-1;
        while(res.size()<m*n){
            //�������ң���������һ��
            for(int i = left; i <= right; i++) res.add(matrix[top][i]);
            top++;
            //�������£������ұ�һ��
            for(int j = top; j <= bottom; j++) res.add(matrix[j][right]);
            right--;
            
            if(top>bottom) break; //ֹͣ����,��ֹ�����ظ�����
            
            //����������������һ��
            for(int i = right; i >= left; i--) res.add(matrix[bottom][i]);
            bottom--;
            
            if(left>right) break;//ֹͣ��������ֹ�����ظ�����
            
            
            //�������ϣ��������һ��
            for(int j = bottom; j>=top; j--) res.add(matrix[j][left]);
            left++;
           
        }
        return res;
        
    }
}
