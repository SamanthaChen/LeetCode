package Solutions;

public class PowerofThree {
    public boolean isPowerOfThree(int n) {
        
    //ѭ���ķ���(����73.48%)
    // if(n>1){
    //   while(n%3 == 0 ) n /= 3;//���ܱ�3��������һֱѭ��������  
    // }
    
    // return n==1;
    
    //�ݹ�ķ���(run time error)
    // if( n == 1) return true;
    // if( n< 1) return false;
    // return n%3 == 0 ? isPowerOfThree(n/3) : false;
    
    //java���������ֶ��Ǵ����ŵ�,û��unsigned,int��java���ǹ̶���32bits,��ʾ�ķ�ΧΪ-2^31��2^31-1(2,147,483,647)
    //3^20 = 3,486,784,401 3^19=1,162,261,467(����54%)
    return (n>0 && 1162261467%n == 0);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
