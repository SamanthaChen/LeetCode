package Solutions;

import java.util.HashSet;
import java.util.Set;

public class NQueensII {

	public static void main(String[] args) {
		NQueensII m = new NQueensII();
		System.out.println(m.totalNQueens(2));
	}

	// ���Ѿ������ˣ��ж��У������Խ����ǲ��ǳ�ͻ�Ϳ����ˣ�������Ĳ�������
	private final Set<Integer> colSet = new HashSet<Integer>();
	private final Set<Integer> diaSet1 = new HashSet<Integer>();
	private final Set<Integer> diaSet2 = new HashSet<Integer>();
	// int count = 0;// ���Ҳ����ȫ�ֱ�������

	public int totalNQueens(int n) {
		return helper(0, 0, n);
	}

	public int helper(int rowid, int count, int n) {

		for (int colid = 0; colid < n; colid++) {
			// ���Ϸ���colid�ͼ���+1ѭ��
			if (colSet.contains(colid))
				continue;

			int diag1 = rowid + colid;
			if (diaSet1.contains(diag1))
				continue;

			int diag2 = rowid - colid;
			if (diaSet2.contains(diag2))
				continue;

			// �Ϸ��ľ��ж��Ƿ�������ˣ�δ��ͻ���
			if (rowid == n - 1) {
				count++;
			} else {

				colSet.add(colid);
				diaSet1.add(diag1);
				diaSet2.add(diag2);
				count = helper(rowid + 1, count, n); // ע���ˣ�������Ҫ��ֵ��������count�����
				// ��λ
				diaSet2.remove(diag2);
				diaSet1.remove(diag1);
				colSet.remove(colid);
			}

		}
		return count;
	}

}
