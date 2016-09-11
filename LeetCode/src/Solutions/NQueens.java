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
		// lambda���ʽ��ӡ�б�
		res.forEach((list) -> {
			System.out.print("[");
			list.forEach((e) -> {
				System.out.print(e + " ");
			});
			System.out.print("]");
			System.out.println("");
		});

	}

	// ��һ��һά��������ʾ�ʺ���õ�λ�ã�������±��ʾ�кţ������ڵ�Ԫ�ر�ʾ�к�
	// �����±�϶���һ����Ĭ�ϻʺ󲻻������ͬһ�У�ֻ��Ҫ�������ͬһ�У���0~n-1�Ĳ�ͬ���ֱ�ʾ��
	// ����Ѱ������������������ϼ���
	/**
	 * �ⷨ1��DFS����������ʱ�� O(N^3) �ռ� O(N)
	 */
	public List<List<String>> solveNQueens(int n) {
		int[] nums = new int[n];
		List<List<String>> res = new ArrayList<List<String>>();
		backTrack(nums, n, 0, res);
		return res;
	}

	private void backTrack(int[] queenArray, int n, int cur, List<List<String>> res) {
		if (cur == n) {// ˵����������ͷ�ˣ����Լ���
			// �������鹹��������
			List<String> list = new ArrayList<String>();
			for (int i : queenArray) {
				char[] ch = new char[n];
				Arrays.fill(ch, '.');
				ch[i] = 'Q';
				list.add(new String(ch));
			}
			res.add(list);

		} else {
			// ������٣��������п�����
			for (int num = 0; num < n; num++) {
				// ѡ����һ�е�����
				// ����֮ǰ�Ѿ�ѡ��13xxxxxx����һ�п���ѡ6���γ�136xxxxx
				queenArray[cur] = num;
				if (isValid(queenArray, cur)) {
					// ����ǰ��ֵ������������������һ��
					backTrack(queenArray, n, cur + 1, res);
				}
			}
		}

	}

	// ��鵱ǰ0~end�������ǲ�����Ч��,����ǰ�������
	// ��a[end]��ÿһ��ǰ��ȽϾ��У���������
	private boolean isValid(int[] queen, int end) {
		for (int i = 0; i < end; i++) {
			if (queen[i] == queen[end] || Math.abs(i - end) == Math.abs(queen[i] - queen[end])) // �ֱ������Խ��ߺ͸��Խ��߳�ͻ�����
				return false;
		}
		return true;
	}

	/**
	 * �����leetcode18%�����ⷨ1��80%���Ƚ���
	 * �ⷨ2���÷�����˼·�ͱ�����һ�����������ڣ�֮ǰ�����ж�һ���ʺ��Ƿ��ͻ���Ǳ���һ�鵱ǰ�ʺ����е��б���ÿһ���ʺ��Ƿ��ͻ��
	 * �����������������������֮ǰ�ʺ����Ϣ���Ϳ���O(1)ʱ���жϳ��ʺ��Ƿ��ͻ�� �������Ϸֱ����м��ϣ����ڴ������Щ�б�ռ�ˣ�
	 * ���Խ��߼��ϣ����ڴ���ĸ����ϵ����µĶԽ��߱�ռ�ˣ� ���Խ��߼��ϣ����ڴ���ĸ����ϵ����µĶԽ��߱�ռ�ˡ�
	 * ���Ψһ���ж�ĳ�������ڵ����Խ��ߺ͸��Խ����أ� ���Ƿ��֣���������кż��кŵĺ���ͬ������������ͬһ�����Խ����ϡ�
	 * ��������кż��кŵĲ���ͬ������������ͬһ�����Խ����ϡ�
	 */
	// ������ȫ�ֱ�����
	List<List<String>> ans = new ArrayList<List<String>>();// ���
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
			// �ж�num�ʲ��ʺ����к�
			for (int num = 0; num < n; num++) {
				int diag1 = i + num;// ���Խ����кź��кź����
				int diag2 = i - num;// ���Խ����кź��кŲ����
				// �ж��Ƿ�Ϸ�
				if (rowSet.contains(num) || diaSet1.contains(diag1) || diaSet2.contains(diag2))
					continue;// ���Ϸ�����һ��num

				// �Ϸ��Ļ���������
				queen[i] = num;
				rowSet.add(num);
				diaSet1.add(diag1);
				diaSet2.add(diag2);
				helper(queen, n, i + 1);
				// ������һ��ʱ��״̬��Ҫ��λ
				diaSet2.remove(diag2);
				diaSet1.remove(diag1);
				rowSet.remove(num);
			}
		}

	}

}
