package JulyAlgotithm;

public class StringsPractice {

	public static void main(String[] args) {
		String s = "abaccdeffdb";//���Ӧ����b
//		System.out.println(firstSingleChar(s));
	}
	/*
	 * �ҵ���һ��ֻ����һ�ε��ַ�
	 * (�����е�˵�ٶȵ�Ҫ����for while ѭ������ôʵ�֣�)
	 * ˼·����hashmap�������������飬һ����¼�ַ�λ�ã�һ����¼���ִ�����
	 * **/
	public char firstSingleChar(String s){
		int[] pos = new int[26];//��¼λ�õ�
		int[] frequncy = new int[26];//��¼Ƶ�ʵ�
		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			frequncy[c-'a'] ++;
			if(pos[c-'a']<= i) pos[c-'a']= i;//��¼��һ�γ��ֵ�λ��
		}
		int index = Integer.MAX_VALUE;
		char c = 'a';
		for(int i=0;i<26;i++){
			if(frequncy[i]==1 && pos[i]<index){
				index = pos[i];
				c = (char) (i+'a');
			}
		}
		return c;
	}
}
