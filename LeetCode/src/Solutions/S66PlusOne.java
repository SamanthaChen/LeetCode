package Solutions;

public class S66PlusOne {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for(int i=len-1;i>=0;i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;//���緵��.��һλ��1�����Ҳ������������治��д��
            }
            else digits[i]=0;//9+1��Ϊ0 
        }
       //˵����λ�Ѿ�������һλ������ֱ�Ӿ��Ѿ�������
        int[] num = new int[len+1];
        num[0]=1;
        return num;
      
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
