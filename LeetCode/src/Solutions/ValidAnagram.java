package Solutions;
/*
 * 判断两个字符是否是兄弟字符，即 abccc 和cabcc是兄弟字符
 * */
import java.util.Arrays;


public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        // Arrays.sort(cs);
        // Arrays.sort(ct);
        // return Arrays.equals(cs,ct);
        //不用排序的话
        int[] record = new int['z'+1];//存字母表大小的数组
        for(int i = 0; i<s.length(); i++){
            record[cs[i]]++;
        }
        for(int i = 0; i<t.length(); i++){
            record[ct[i]]--;
        }
        for(int a: record){
            if (a!=0) return false;
        }
        return true;
        
    }

}
