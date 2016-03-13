package Solutions;

public class S168Excel {
    public String convertToTitle(int n) {
        String res = "";
        int mod = 0;
        while(n>0){
            mod = (n-1)%26;
            char ch = (char)(mod + 65);//不能直接mod+‘A’？？
            res = ch + res;//反过来加
            n = (n-1) / 26;//注意要件一
        }
        return res;
        
    }
}
