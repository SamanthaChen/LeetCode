package Solutions;

public class S9PalindromeNumber {
    public boolean isPalindrome(int x) {
        //�㷨˼�룺���ó������������������ֱ����ԭ�����Ĵ��ʿ����룬���жϵȲ���(10ms 94%)
        if( x<0 || x!= 0 && x%10==0) return false;
        int rev = 0;
        while(x>rev){
            rev =rev*10 + x%10;
            x = x/10;
        }
        return (x == rev || x == rev/10);
    }
}
