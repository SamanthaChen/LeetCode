package Solutions;

public class UglyNumber {

    public boolean isUgly(int num) {
        //���ֳ���7 1,2,3,4,5,6,8,9����ugly number
        if(num <= 0) return false;
        if(num == 1) return true;
        while(num%2 == 0) num = num/2;//�ܱ�2����
        while(num%3 == 0) num = num/3;;//�ܱ�3����
        while(num%5 == 0) num = num/5;//�ܱ�5����
        //�Ѿ����������п���,�����1˵���Ѿ���2,3,5���������򷵻ؼ�
        return num == 1;
        
        //�ݹ�
//        if(num<=0)return false;
//        if(num==1)return true;
//        if(num%2==0) return isUgly(num/2);
//        if(num%3==0) return isUgly(num/3);
//        if(num%5==0) return isUgly(num/5);
//        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
