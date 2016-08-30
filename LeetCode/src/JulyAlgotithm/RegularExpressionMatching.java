package JulyAlgotithm;
/*
 * LeetCode #6
 * 
 * **/
public class RegularExpressionMatching {

	public static void main(String[] args) {
//		System.out.println(isMatch("","J*Smi.."));
	}
	/*
	 * ����ⷨ����Ϊ *����ǰ����ַ�ƥ��һ��������ַ�
	 * **/
	//ע�� s==null �� s =="" ��ͬ��Ϊ�˱��ջ�����s.length==0
	public static boolean isMatch2(String s, String p){
		if(s.length()==0 && p.length()==0) return true;
		if(p.length()==1 && p.charAt(0)=='*') return true;
		
		if(s.length()==0 && p.length()!=0|| (s.length()!=0 && p.length()==0) )
				return false;
		if(p.charAt(0)!='*'){
			if(s.charAt(0)==p.charAt(0) || p.charAt(0)=='.'){
				return isMatch(s.substring(1),p.substring(1));
			}else{
				return false;
			}
		}else{
			if(s.charAt(0)!= p.charAt(1)){
				return isMatch(s.substring(1),p);
			}else{
				return isMatch(s.substring(1),p.substring(2));
			}
		}
		
		
		
	}
	
	/*
	 * ����ⷨ����LeetCode������Ľ��
	 * 1.*��ǰ����ַ���Ҫ��������Ƚ�
	 * **/
	public static boolean isMatch(String s, String p){
		if(p.isEmpty()) 
			return s.isEmpty();
		
		//p�ĳ���Ϊ1���϶����ÿ���*
		if(p.length()==1 || p.charAt(1)!='*'){
			if(s.isEmpty() ||  p.charAt(0)!='.' || p.charAt(0)!=s.charAt(0)){
				return false;
			}else{
				return isMatch(s.substring(1),p.substring(1));
			}
		}
		
		//����>=2 ����p.charAt(1)==*
		//��s�е���p.charAt(0)��ƥ����
		while(!s.isEmpty() && (p.charAt(0)=='.' || p.charAt(0)==s.charAt(0))){
			if(isMatch(s,p.substring(2)))//*����ƥ���
					return true;
			s = s.substring(1);
		}
		return isMatch(s,p.substring(2));
	}

		
	

}
