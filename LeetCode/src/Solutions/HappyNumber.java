package Solutions;
import java.util.HashSet;
import java.util.Set;


public class HappyNumber {
    public static boolean isHappy(int n) {
        //��ؼ��ĵط���Ϊ���ж�֮ǰ�Ƿ�������ظ����ֵ����֣���һ��set���洢
        if(n == 1) return true;
        Set<Integer> isLoop = new HashSet<Integer>();
        
        while(isLoop.add(n)){//��ѭ����ƽ������Ϊn���Ƚ��Ƿ���ֻ�·(���ü������жϣ���Ϊ2ƽ����4����һֱ��4ѭ���������ǻص�2)
            int sum = 0;
            int mod =0;
            do{//��ѭ������ƽ����
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
