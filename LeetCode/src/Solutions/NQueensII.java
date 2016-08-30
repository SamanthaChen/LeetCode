package Solutions;

import java.util.HashSet;
import java.util.Set;

public class NQueensII {

	public static void main(String[] args) {
		NQueensII m = new NQueensII();
		System.out.println(m.totalNQueens(2));
	}

	// 行已经处理了，判断列，两个对角线是不是冲突就可以了，不用真的布置棋盘
	private final Set<Integer> colSet = new HashSet<Integer>();
	private final Set<Integer> diaSet1 = new HashSet<Integer>();
	private final Set<Integer> diaSet2 = new HashSet<Integer>();
	// int count = 0;// 这个也必须全局变量？？

	public int totalNQueens(int n) {
		return helper(0, 0, n);
	}

	public int helper(int rowid, int count, int n) {

		for (int colid = 0; colid < n; colid++) {
			// 不合法的colid就继续+1循环
			if (colSet.contains(colid))
				continue;

			int diag1 = rowid + colid;
			if (diaSet1.contains(diag1))
				continue;

			int diag2 = rowid - colid;
			if (diaSet2.contains(diag2))
				continue;

			// 合法的就判断是否放置完了，未完就回溯
			if (rowid == n - 1) {
				count++;
			} else {

				colSet.add(colid);
				diaSet1.add(diag1);
				diaSet2.add(diag2);
				count = helper(rowid + 1, count, n); // 注意了！这里需要传值！！否则count不会变
				// 复位
				diaSet2.remove(diag2);
				diaSet1.remove(diag1);
				colSet.remove(colid);
			}

		}
		return count;
	}

}
