package Solutions;

import java.util.HashSet;

public class ValidSudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean isValidSudoku(char[][] board) {
        //数独的规则：1、每行1-9只出现一次 2、每列1-9只出现一次 3、每个子格1-9只出现一次
        
   
        //利用三个hashSet分别对每一条规则进行检查(7ms,35.2%)
        for(int i = 0; i < 9 ; i++){
            HashSet<Character> row = new HashSet<Character>();//存每一行
            HashSet<Character> column = new HashSet<Character>();//存每一列
            HashSet<Character> box = new HashSet<Character>(); //存每一格
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'  && !row.add(board[i][j])) return false;//检查行
                if(board[j][i] != '.'  && !column.add(board[j][i])) return false;//检查列
                //检查cube有点麻烦
                int rowindex = 3*(i/3);//  (0 1 2)/3 =0 (3 4 5)/3=1 (6 7 8)/3=2
                int columnindex = 3*(i%3);//  (0 1 2) (3 4 5)  (6 7 8) % 3 = (0 1 2)
                if(board[rowindex+j/3][columnindex + j%3] != '.'  && !box.add(board[rowindex+j/3][columnindex + j%3])) return false;//检查格子

            }

        }
        return true;

    }
}
