package Solutions;
/*
 * �ж������ַ��Ƿ����ֵ��ַ����� abccc ��cabcc���ֵ��ַ�
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
        //��������Ļ�
        int[] record = new int['z'+1];//����ĸ���С������
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
