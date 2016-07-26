package Solutions;

public class SearchA2DMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	    public boolean searchMatrix(int[][] matrix, int target) {
	        //�߽����
	        if(matrix == null || matrix.length==0 || matrix[0].length==0) return false;
	        //���ڸ������������������Կ���һ��һά��,Ȼ����ֲ���
	        int m = matrix.length;
	        int n = matrix[0].length;
	        int low = 0;
	        int high = m*n-1;
	        while(low<=high){
	            int mid = (low+high)/2;
	            if(target==matrix[mid/n][mid%n]) return true;
	            else if(target < matrix[mid/n][mid%n]) high = mid-1;
	            else low = mid+1;
	        }
	        return false;
	        
	    }

}
