package Solutions;

public class S152MaximunProductArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //˼·1������ͬʱ������������������Ҫ������ֵ����ǰ���͵�ǰ��С����ǰ��СΪһ������ʱ�����һ���ܴ�ĸ������ܻ������
    //��ˣ���ǰ���͵�ǰ��С�����������л��
    //maxp[i]= max(  max(maxp[i-1]*a[i],a[i]) , minp[i-1]*a[i]) ��������a[i]>0�������minp[i-1]*a[i] ��a[i]<0�����
    //minp[i] = min(min(maxp[i-1]*a[i],a[i]),minproduct*a[i]); ��������a[i]<0�������minproduct*a[i] ��a[i]>0�����
    public int maxProduct(int[] a) {
        int maxproduct = a[0];
        int minproduct = a[0];
        int temp;
        int global=a[0];
        for(int i = 1 ; i < a.length; i++){
            temp = maxproduct;
            maxproduct = Math.max(Math.max(maxproduct*a[i],a[i]),minproduct*a[i]);
            minproduct = Math.min(Math.min(temp*a[i],a[i]),minproduct*a[i]);
            global = Math.max(maxproduct,global);
        }
        return global;
        
    }

}
