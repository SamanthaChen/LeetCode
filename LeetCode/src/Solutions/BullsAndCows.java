package Solutions;

public class BullsAndCows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getHint("11112222","22221111"));
	}
    public static String getHint(String secret, String guess) {
        //先用map找出相同数字以及频率sum，再扫描一遍找bulls，cows = sum-bulls
        //注意到题目是数字，所以可以排序
        //先用map找出相同数字以及频率sum，再扫描一遍找bulls，cows = sum-bulls
        //注意到题目是数字，所以只有0-9
        int bulls = 0;
        int cows = 0;
        int[] index = new int[10];//存0-9的出现次数
        for(int i= 0; i < secret.length(); i++){
            int s = secret.charAt(i)-'0';
            int g = guess.charAt(i)-'0';
            if( s == g ) bulls++;
            else{
                if(index[s]<0) cows++;//说明之前出现过一个一样的g把次数减小为fu了
                if(index[g]>0) cows++;
                index[s]++;
                index[g]--;
            }

            
        }
        String res = bulls+"A"+cows+"B";
        return res;
        

    }
}
