package JulyAlgotithm;

public class Probability {

	public static void main(String[] args) {
		
		System.out.println(cal(50));
	}
	//计算n个人其中有两个人是同一天生日的概率
	public static double cal(int n){
		double res = 1.0;
		for(int i=0;i<n;i++){
			res *= (365.0-i)/365.0;
		}
//		double pre = Math.round((1-res)*100);
//		return pre/100;
		return 1-res;
	}

}
