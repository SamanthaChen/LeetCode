package Solutions;
import java.util.HashSet;
import java.util.Set;


public class HappyNumber {
    public static boolean isHappy(int n) {
        //最关键的地方是为了判断之前是否出现了重复出现的数字，用一个set来存储
        if(n == 1) return true;
        Set<Integer> isLoop = new HashSet<Integer>();
        
        while(isLoop.add(n)){//外循环将平方和置为n，比较是否出现环路(采用集合来判断，因为2平方是4，会一直在4循环，而不是回到2)
            int sum = 0;
            int mod =0;
            do{//内循环计算平方和
                mod = n % 10;
                n = n/10;
                sum += mod*mod;
            }while(n>0); 
            if(sum == 1) return true;
            else n = sum;
        }
        return false;

        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(isHappy(19)) System.out.println("true");
		else System.out.println("false");
	}

}
