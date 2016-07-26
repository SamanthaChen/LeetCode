package Solutions;

public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1534236469;
		System.out.println(n+" "+reverse(n));

	}
    public static int reverse(int x) {
        int res = 0;
        while( x != 0){
            int tail = x % 10;
            x /= 10;
            int newres = res*10 + tail;
            //·ÀÖ¹Òç³ö
            if((newres-tail)/10 != res ) return 0;
            res = newres;
        }
    return res;
    }
}
