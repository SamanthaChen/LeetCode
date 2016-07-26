package Solutions;

public class ExcelSheetColumn {
    public int titleToNumber(String s) {
        int len = s.length();
        int res = 0;
        for(int i = 0; i<len ;i++){
            res += (s.charAt(i)-'A'+1)*Math.pow(26,len-i-1);
        }
        return res;
    }
}
