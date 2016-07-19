
public class test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long[] s = new long[20];
		for(int k=0;k<20;k++){
			s[k]=k+1;
		}
		System.out.println(Screen(s,s.length,1)[0]);

	}
	public static long[] Screen(long s[],int len, int n) {
		long[] str = new long[len];
		int l=0;
		long step=MathPow(2,n);
		for(int i=0;i<len;i++){
			if(s[i]%step==0){
				str[l]=s[i];
				l++;
			}
		}
		
		System.out.print("µÚ"+n+"´Î =");
		for(int i=0;i<l;i++){
			System.out.print(str[i]+",");
		}
		System.out.println();
		
		if(l>1){
			str=Screen(str,l,n+1);
		}
		return str;
	}
	public static long MathPow(long x,int n){
		long x_n=1;
		for(int i=0;i<n;i++){
			x_n=x_n*x;
		}
		return x_n;
	}
}
