package Solutions;

public class ReverseWordsinaString {

	public static void main(String[] args) {
		ReverseWordsinaString m = new ReverseWordsinaString();
		String s = "      the sky       is blue     ";
		// char[] ch = { ' ', ' ', 'a', 'b', ' ', ' ', 'c', ' ', ' ' };
		// String a = m.trim(ch);
		// System.out.println(a);
		// System.out.println(a.length());
		System.out.println(m.reverseWords(s));

	}

	public String reverseWords(String s) {
		String[] parts = s.trim().split("\\s+");// ��������ʽ
		String out = "";
		for (int i = parts.length - 1; i > 0; i--) {
			out += parts[i] + " ";
		}
		return out + parts[0];

	}

	// ע�⣬��������Ǻܶ���գ�û��ac����
	public String reverseWords2(String s) {
		if (s.length() <= 1)
			return s;
		char[] ch = s.toCharArray();
		// �ȷ�תȫ��
		reverse(ch, 0, ch.length - 1);
		// ��תÿ������
		int begin = 0;
		int end = 1;
		while (begin < ch.length && end <= ch.length) {
			if (ch[begin] == ' ') {
				// ���ʿ�ͷ�ǿո�
				begin++;
				end++;
			} else if (end == ch.length || ch[end] == ' ') {// ��ͻ�����������Ⱥ�˳��Ҳ����Ҫ��
				// ���ﵥ�ʷָ�λ�û��ߵ��յ�
				reverse(ch, begin, end - 1);
				begin = end;
			} else {
				end++;
			}
		}
		// ȥ������Ŀո�
		return trim(ch);

	}

	public void reverse(char[] ch, int start, int end) {
		if (ch.length <= 1 || start > end)
			return;
		while (start < end) {
			char tmp = ch[start];
			ch[start] = ch[end];
			ch[end] = tmp;
			start++;
			end--;
		}
	}

	public String trim(char[] ch) {
		int n = ch.length;
		int i = 0;
		int j = 0;
		while (j < n) {
			while (j < n && ch[j] == ' ')
				j++;
			while (j < n && ch[j] != ' ')
				ch[i++] = ch[j++];
			while (j < n && ch[j] == ' ')
				j++; // skip spaces
			// ������һ�����ʼӿո�
			if (j < n)
				ch[i++] = ' ';
		}
		return new String(ch).substring(0, i);// �����һ���ո�ȥ��
	}
}
