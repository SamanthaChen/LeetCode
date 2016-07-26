package Solutions;

public class RotateImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m =3;
		int n =3;
		int k=1;
		int[][] matrix = new int[m][n];
        for(int i=0 ; i<m ; i++){
            for(int j=0; j<n ;j++){
                matrix[i][j]=k++;
            }
        }
        print(matrix);
        rotate(matrix);
        print(matrix);
	}
	   //最笨的方法，再用一个数组存原来的数
//    public static void rotate(int[][] matrix) {
//        if(matrix == null || matrix.length==0 || matrix[0].length==0) return;
//        int m = matrix.length;
//        int n = matrix[0].length;
//        int[][] temp = new int[m][n];
//        //复制原来的
//        for(int i=0 ; i<m ; i++){
//            for(int j=0; j<n ;j++){
//                temp[i][j]=matrix[i][j];
//            }
//        }
//        //重新赋值
//        for(int i=0 ; i<m ; i++){
//            for(int j=0; j<n ;j++){
//                matrix[j][n-1-i] = temp[i][j];
//            }
//        }
//        
//    }
	
	
    //in place 的方法 利用关系式：新matrix[i][j] = 原来的matrix[j][n-1-i]
    //可以先 1、matrix[i][j]与matrix[j][i]互换 2、matrix[i][j] 与 matrix[i][n-1-j]互换
    //这样可以做到不需要太多额外空间
    // 1 2 3     1 4 7    7 4 1
    // 4 5 6 --> 2 5 8 -->8 5 2
    // 7 8 9     3 6 9    9 6 3
    public static void rotate(int[][] matrix){
        if(matrix == null || matrix.length==0 || matrix[0].length==0) return;
        int n = matrix.length;
        //先对角线互换
        for(int i = 0 ; i < n ; i++){
            for(int j = i ; j < n; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        //再左右互换
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n/2; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = tmp;
            }
        }
    }
    public static void print(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        String s = "";
        //复制原来的
        for(int i=0 ; i<m ; i++){
            for(int j=0; j<n ;j++){
                s += matrix[i][j]+"\t";
            }
            s += "\n";
        }
        System.out.println(s);
    }

}
