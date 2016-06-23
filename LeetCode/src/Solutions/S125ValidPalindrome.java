package Solutions;

public class S125ValidPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome(".,"));
	}
    public static boolean isPalindrome(String s) {
        
        if(s==null) return true;
        //基本思想，设置两个小标指针分别从后往前以及从前往后看是不是重合的(10ms 50.88%)
        int head = 0;
        int tail = s.length()-1;
        while(head <= tail){
            char chead = s.charAt(head);
            char ctail = s.charAt(tail);
            if(!Character.isLetterOrDigit(s.charAt(head)) )head++;
            else if(!Character.isLetterOrDigit(s.charAt(tail))) tail--;
            else{
                if(Character.toLowerCase(chead)!=Character.toLowerCase(ctail)) return false;//还需要注意大小写的问题
                head++;
                tail--;
            }

        }
        return true;
        
    }
}
