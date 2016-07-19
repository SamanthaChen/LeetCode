package Solutions;

public class S10RegularMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "aaa";
		String b = "a*a";
//		System.out.println(a.substring(1));
		System.out.println(isMatch(a,b));
	}
    //˼·����Ϊ�������(*��ǰ��������ַ�)
    //1.��1���ַ�����*,ƥ���0����ֱ�ӿ���1��ʼ���Ӵ�
    //2.��1���ַ���*
    public static boolean isMatch(String s, String p) {     
    if(p.length()==0) return s.length()==0;
    //�������
    if(p.length()==1){
        if(s.length()<=0) return false;
        if(p.charAt(0)!='.' && p.charAt(0)!=s.charAt(0)) return false;
        else return isMatch(s.substring(1),p.substring(1));//
    }
    //case1:��2���ַ�����*
    if( p.charAt(1)!='*' ) {
    	//1.����p���ȴ���s s.length()<1 
    	
        if(s.length()<1 || (p.charAt(0)!='.' && p.charAt(0)!=s.charAt(0))) return false; 
        else
            return isMatch(s.substring(1),p.substring(1));
    } 
    //case2:�ڶ����ַ���*�����Ǽ����һ����.��
    else{

        //case2.1:һ���ַ�+*Ҳ���Ե���0
        if(isMatch(s,p.substring(2)) ) return true;
        //case2.2:
        int i = 0;
        while(i<s.length() && s.charAt(i)==p.charAt(0) ){
        	if(isMatch(s.substring(i+1),p.substring(2))) return true;
            i++;
        }
        return i==s.length() ? isMatch("",p.substring(2)) :  isMatch(s.substring(i),p.substring(2)) ;
        
        
    }  }

}
