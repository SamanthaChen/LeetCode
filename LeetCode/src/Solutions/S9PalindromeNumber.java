package Solutions;

public class S9PalindromeNumber {
    public boolean isPalindrome(int x) {
        //算法思想：利用除数和余数整两个数分别等于原来回文串剖开两半，再判断等不等(10ms 94%)
        if( x<0 || x!= 0 && x%10==0) return false;
        int rev = 0;
        while(x>rev){
            rev =rev*10 + x%10;
            x = x/10;
        }
        return (x == rev || x == rev/10);
    }
}
