package Solutions;

public class S67AddBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;//进位位
        while(i >= 0 || j >= 0){
           int bres = carry;//单位的结果
           if(i >= 0) bres += a.charAt(i--)-'0';
           if(j >= 0) bres += b.charAt(j--)-'0';
           carry = bres/2;
           sb.append(bres%2);
        }
        //还需要考虑多出来的进位位
        if(carry==1) sb.append(carry);
        return sb.reverse().toString();

    }
}

