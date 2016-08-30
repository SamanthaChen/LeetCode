package Solutions;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//经典方法：前面和后面进行翻转
    public String reverseString1(String s) {
        if(s==null || s.length()==0) return s;
        int len = s.length();
        int start = 0;
        int end = len-1;
        char[] c = s.toCharArray();
        while(start<end){
            char temp = c[start];
            c[start]=c[end];
            c[end]=temp;
            start++;
            end--;
        }
        return String.valueOf(c);
    }
    //利用JDK的方法
    public String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
     }

}
