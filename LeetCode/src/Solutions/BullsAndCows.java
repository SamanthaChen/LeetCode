package Solutions;

public class BullsAndCows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getHint("11112222","22221111"));
	}
    public static String getHint(String secret, String guess) {
        //����map�ҳ���ͬ�����Լ�Ƶ��sum����ɨ��һ����bulls��cows = sum-bulls
        //ע�⵽��Ŀ�����֣����Կ�������
        //����map�ҳ���ͬ�����Լ�Ƶ��sum����ɨ��һ����bulls��cows = sum-bulls
        //ע�⵽��Ŀ�����֣�����ֻ��0-9
        int bulls = 0;
        int cows = 0;
        int[] index = new int[10];//��0-9�ĳ��ִ���
        for(int i= 0; i < secret.length(); i++){
            int s = secret.charAt(i)-'0';
            int g = guess.charAt(i)-'0';
            if( s == g ) bulls++;
            else{
                if(index[s]<0) cows++;//˵��֮ǰ���ֹ�һ��һ����g�Ѵ�����СΪfu��
                if(index[g]>0) cows++;
                index[s]++;
                index[g]--;
            }

            
        }
        String res = bulls+"A"+cows+"B";
        return res;
        

    }
}