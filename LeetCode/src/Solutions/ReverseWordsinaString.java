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
		String[] parts = s.trim().split("\\s+");// 用正则表达式
		String out = "";
		for (int i = parts.length - 1; i > 0; i--) {
			out += parts[i] + " ";
		}
		return out + parts[0];

	}

	// 注意，输入可能是很多个空（没有ac））
	public String reverseWords2(String s) {
		if (s.length() <= 1)
			return s;
		char[] ch = s.toCharArray();
		// 先翻转全部
		reverse(ch, 0, ch.length - 1);
		// 翻转每个单词
		int begin = 0;
		int end = 1;
		while (begin < ch.length && end <= ch.length) {
			if (ch[begin] == ' ') {
				// 单词开头是空格
				begin++;
				end++;
			} else if (end == ch.length || ch[end] == ' ') {// 与和或条件里面的先后顺序也很重要！
				// 到达单词分割位置或者到终点
				reverse(ch, begin, end - 1);
				begin = end;
			} else {
				end++;
			}
		}
		// 去掉多余的空格
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
			// 复制完一个单词加空格
			if (j < n)
				ch[i++] = ' ';
		}
		return new String(ch).substring(0, i);// 把最后一个空格去掉
	}
}
