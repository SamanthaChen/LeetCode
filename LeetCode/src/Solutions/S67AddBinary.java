package Solutions;

public class S67AddBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;//��λλ
        while(i >= 0 || j >= 0){
           int bres = carry;//��λ�Ľ��
           if(i >= 0) bres += a.charAt(i--)-'0';
           if(j >= 0) bres += b.charAt(j--)-'0';
           carry = bres/2;
           sb.append(bres%2);
        }
        //����Ҫ���Ƕ�����Ľ�λλ
        if(carry==1) sb.append(carry);
        return sb.reverse().toString();

    }
}

