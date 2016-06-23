package Solutions;

public class S125ValidPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome(".,"));
	}
    public static boolean isPalindrome(String s) {
        
        if(s==null) return true;
        //����˼�룬��������С��ָ��ֱ�Ӻ���ǰ�Լ���ǰ�����ǲ����غϵ�(10ms 50.88%)
        int head = 0;
        int tail = s.length()-1;
        while(head <= tail){
            char chead = s.charAt(head);
            char ctail = s.charAt(tail);
            if(!Character.isLetterOrDigit(s.charAt(head)) )head++;
            else if(!Character.isLetterOrDigit(s.charAt(tail))) tail--;
            else{
                if(Character.toLowerCase(chead)!=Character.toLowerCase(ctail)) return false;//����Ҫע���Сд������
                head++;
                tail--;
            }

        }
        return true;
        
    }
}
