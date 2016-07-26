package Solutions;

import java.util.HashSet;

public class ValidSudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean isValidSudoku(char[][] board) {
        //�����Ĺ���1��ÿ��1-9ֻ����һ�� 2��ÿ��1-9ֻ����һ�� 3��ÿ���Ӹ�1-9ֻ����һ��
        
   
        //��������hashSet�ֱ��ÿһ��������м��(7ms,35.2%)
        for(int i = 0; i < 9 ; i++){
            HashSet<Character> row = new HashSet<Character>();//��ÿһ��
            HashSet<Character> column = new HashSet<Character>();//��ÿһ��
            HashSet<Character> box = new HashSet<Character>(); //��ÿһ��
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'  && !row.add(board[i][j])) return false;//�����
                if(board[j][i] != '.'  && !column.add(board[j][i])) return false;//�����
                //���cube�е��鷳
                int rowindex = 3*(i/3);//  (0 1 2)/3 =0 (3 4 5)/3=1 (6 7 8)/3=2
                int columnindex = 3*(i%3);//  (0 1 2) (3 4 5)  (6 7 8) % 3 = (0 1 2)
                if(board[rowindex+j/3][columnindex + j%3] != '.'  && !box.add(board[rowindex+j/3][columnindex + j%3])) return false;//������

            }

        }
        return true;

    }
}
