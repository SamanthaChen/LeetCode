package Solutions;
/*
 * �ж������ַ��Ƿ����ֵ��ַ����� abccc ��cabcc���ֵ��ַ�
 * */
import java.util.Arrays;


public class Solution242ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        Arrays.sort(cs);
        Arrays.sort(ct);
        return Arrays.equals(cs,ct);
        
    }

}
