package Solutions;

public class S168Excel {
    public String convertToTitle(int n) {
        String res = "";
        int mod = 0;
        while(n>0){
            mod = (n-1)%26;
            char ch = (char)(mod + 65);//����ֱ��mod+��A������
            res = ch + res;//��������
            n = (n-1) / 26;//ע��Ҫ��һ
        }
        return res;
        
    }
}
