package Solutions;

public class S125ValidPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome(".,"));
	}
//    public static boolean isPalindrome(String s) {
//        
//        if(s==null) return true;
//        //����˼�룬��������С��ָ��ֱ�Ӻ���ǰ�Լ���ǰ�����ǲ����غϵ�(10ms 50.88%)
//        int head = 0;
//        int tail = s.length()-1;
//        while(head <= tail){
//            char chead = s.charAt(head);
//            char ctail = s.charAt(tail);
//            if(!Character.isLetterOrDigit(s.charAt(head)) )head++;
//            else if(!Character.isLetterOrDigit(s.charAt(tail))) tail--;
//            else{
//                if(Character.toLowerCase(chead)!=Character.toLowerCase(ctail)) return false;//����Ҫע���Сд������
//                head++;
//                tail--;
//            }
//
//        }
//        return true;
//        
//    }
    public static boolean isPalindrome(String s) {
        if(s==null) return true;
        int i=0;
        int j=s.length()-1;
        while(i<=j){
            if( !Character.isLetter(s.charAt(i))) i++;//������ĸ
            else if (!Character.isLetter(s.charAt(j))) j--;//������ĸ
            else {//����ĸ �������������1.��ȣ�2�����
            	if(Character.toLowerCase(s.charAt(i))!=Character.toLowerCase(s.charAt(j)))
            		return false;
                i++;
                j--;
            }

        }
        return true;
    
    
    }
}
