package Solutions;

public class S28ImplementstrStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(strStr("abcdefghijk","de"));
	}
    public static int strStr(String haystack, String needle) {
        if( haystack == null || needle == null || needle.length() > haystack.length()) return -1;
        for(int i = 0;;i++){
            for(int j = 0;  ; j++){
               if(j == needle.length()) return i;
               if(i + j == haystack.length()) return -1; //长度范围已经超过
               if(haystack.charAt(i+j)!=needle.charAt(j)) break;
            }
            
        }
        
    }

}
