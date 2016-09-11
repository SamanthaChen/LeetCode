package Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueens {

	public static void main(String[] args) {
		NQueens m = new NQueens();
		List<List<String>> res = m.solveNQueens2(4);
		// lambda表达式打印列表
		res.forEach((list) -> {
			System.out.print("[");
			list.forEach((e) -> {
				System.out.print(e + " ");
			});
			System.out.print("]");
			System.out.println("");
		});

	}

	// 用一个一维数组来表示皇后放置的位置，数组的下标表示行号，数组内的元素表示列号
	// 由于下标肯定不一样，默认皇后不会出现在同一行，只需要解决不在同一列，用0~n-1的不同数字表示列
	// 遍历寻找所有满足条件的组合即可
	/**
	 * 解法1：DFS，暴力法，时间 O(N^3) 空间 O(N)
	 */
	public List<List<String>> solveNQueens(int n) {
		int[] nums = new int[n];
		List<List<String>> res = new ArrayList<List<String>>();
		backTrack(nums, n, 0, res);
		return res;
	}

	private void backTrack(int[] queenArray, int n, int cur, List<List<String>> res) {
		if (cur == n) {// 说明遍历到尽头了，可以加入
			// 根据数组构建输出结果
			List<String> list = new ArrayList<String>();
			for (int i : queenArray) {
				char[] ch = new char[n];
				Arrays.fill(ch, '.');
				ch[i] = 'Q';
				list.add(new String(ch));
			}
			res.add(list);

		} else {
			// 继续穷举？搜索所有可能性
			for (int num = 0; num < n; num++) {
				// 选择下一列的数字
				// 比如之前已经选了13xxxxxx，下一列可以选6，形成136xxxxx
				queenArray[cur] = num;
				if (isValid(queenArray, cur)) {
					// 若当前赋值满足条件，继续看下一个
					backTrack(queenArray, n, cur + 1, res);
				}
			}
		}

	}

	// 检查当前0~end的数字是不是有效的,由于前面检查过了
	// 将a[end]与每一个前面比较就行，不用两两
	private boolean isValid(int[] queen, int end) {
		for (int i = 0; i < end; i++) {
			if (queen[i] == queen[end] || Math.abs(i - end) == Math.abs(queen[i] - queen[end])) // 分别是主对角线和副对角线冲突的情况
				return false;
		}
		return true;
	}

	/**
	 * 这个在leetcode18%，而解法1是80%，比较慢
	 * 解法2：该方法的思路和暴力法一样，区别在于，之前我们判断一个皇后是否冲突，是遍历一遍当前皇后排列的列表，看每一个皇后是否冲突。
	 * 这里，我们用三个集合来保存之前皇后的信息，就可以O(1)时间判断出皇后是否冲突。 三个集合分别是行集合，用于存放有哪些行被占了；
	 * 主对角线集合，用于存放哪个右上到左下的对角线被占了； 副对角线集合，用于存放哪个左上到右下的对角线被占了。
	 * 如何唯一的判断某个点所在的主对角线和副对角线呢？ 我们发现，两个点的行号加列号的和相同，则两个点在同一条主对角线上。
	 * 两个点的行号减列号的差相同，则两个点再同一条副对角线上。
	 */
	// 这里用全局变量？
	List<List<String>> ans = new ArrayList<List<String>>();// 结果
	Set<Integer> rowSet = new HashSet<Integer>();
	Set<Integer> diaSet1 = new HashSet<Integer>();
	Set<Integer> diaSet2 = new HashSet<Integer>();

	public List<List<String>> solveNQueens2(int n) {
		int[] queen = new int[n];
		helper(queen, n, 0);
		return ans;
	}

	private void helper(int[] queen, int n, int i) {
		if (i == n) {
			char[] ch = new char[n];
			List<String> list = new ArrayList<String>();
			for (int num : queen) {
				Arrays.fill(ch, '.');
				ch[num] = 'Q';
				list.add(new String(ch));
			}
			ans.add(list);

		} else {
			// 判断num适不适合做列号
			for (int num = 0; num < n; num++) {
				int diag1 = i + num;// 主对角线行号和列号和相等
				int diag2 = i - num;// 副对角线行号和列号差相等
				// 判断是否合法
				if (rowSet.contains(num) || diaSet1.contains(diag1) || diaSet2.contains(diag2))
					continue;// 不合法，换一个num

				// 合法的话继续回溯
				queen[i] = num;
				rowSet.add(num);
				diaSet1.add(diag1);
				diaSet2.add(diag2);
				helper(queen, n, i + 1);
				// 返回上一层时候状态需要复位
				diaSet2.remove(diag2);
				diaSet1.remove(diag1);
				rowSet.remove(num);
			}
		}

	}

}
