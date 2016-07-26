package Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalidromePartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aab";
//		System.out.println(isPalindrome(s));

		List<List<String>> res = partition(s);

		res.forEach((list)->{list.forEach((e)->{System.out.print(e+"\t");}); 
												System.out.println("");});
	}
	/*
	 * ��һ�ֽ���˼�룺������ȱ��� 
	 * 1�������ж�str(0,i)�ǲ��ǻ��ģ��ǵĻ����뵽list���棬Ȼ��ȡʣ�µ��Ӵ��ݹ���á��ݹ�������������Ӵ�����Ϊ0��Ȼ���list���뵽�����
	 * 2����������ģ�i++ һֱ�� �ַ���ĩβ
	 * 3��ȫ�������Ժ󷵻ؽ��
	 * @date = 2016.7.20
	 * **/
//	public static List<List<String>> partition(String s) {
//		
//		List<List<String>>  res = new ArrayList<List<String>>(); 
//		if(s==null || s.length()==0) return res;
//		List<String> list = new ArrayList<String>();
//		addPalindrome(s,list,res);
//		return res;
//    }
//	/**
//	 * �ݹ���ӻ��Ĵ��ķ���
//	 * @return 
//	 * */
//	public static void addPalindrome(String s, List<String> list, List<List<String>> res){
//		//�ȿ���һ��ֹͣ����:������ַ�������Ϊ0ʱ���ֹͣ��,�ѵ�ǰ��list��������
//		if(s.length()==0) res.add(new ArrayList<String>(list));
//		//�ݹ���㷨
//		int len = s.length();
//		for(int i = 1; i<=len ; i++){
//			String prestr = s.substring(0,i);
//			if(isPalindrome(prestr)){
//				list.add(prestr);
//				String poststr = s.substring(i);
//				addPalindrome(poststr,list,res);
//				//Ϊ�˱�֤�����list�����ټ���,�ݹ������ʱ��Ҫ�Ѻ����Ԫ����ɾ��
//				list.remove(list.size()-1);
//			}
//			
//		}
//	}
//	/**
//	 * �ж��Ƿ��ǻ��ĵķ���
//	 * */
//	public static boolean isPalindrome(String s){
//		int i = 0;
//		int j = s.length()-1;
//		while(i<=j){
//			if(s.charAt(i)==s.charAt(j)){
//				i++;
//				j--;
//			}else
//				return false;
//		}
//		return true;
//		
//	}
	
	
 	public static List<List<String>> partition(String s) {
		int len = s.length();
		@SuppressWarnings("unchecked")
		List<List<String>>[] result = new List[len + 1];
		result[0] = new ArrayList<List<String>>();
		result[0].add(new ArrayList<String>());

		boolean[][] pair = new boolean[len][len];
		for (int i = 0; i < s.length(); i++) {
			result[i + 1] = new ArrayList<List<String>>();
			for (int left = 0; left <= i; left++) {
				if (s.charAt(left) == s.charAt(i) && (i-left <= 1 || pair[left + 1][i - 1])) {
					pair[left][i] = true;
					String str = s.substring(left, i + 1);
					for (List<String> r : result[left]) {
						List<String> ri = new ArrayList<String>(r);
						ri.add(str);
						result[i + 1].add(ri);
					}
				}
			}
		}
		return result[len];
	}
	

}
