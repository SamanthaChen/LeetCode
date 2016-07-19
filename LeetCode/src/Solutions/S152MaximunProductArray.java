package Solutions;

public class S152MaximunProductArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //思路1：由于同时存在正负数，所以需要存两个值，当前最大和当前最小，当前最小为一个负数时候乘以一个很大的复数可能会变成最大
    //因此，当前最大和当前最小会从三种情况中获得
    //maxp[i]= max(  max(maxp[i-1]*a[i],a[i]) , minp[i-1]*a[i]) 内括号是a[i]>0的情况，minp[i-1]*a[i] 是a[i]<0的情况
    //minp[i] = min(min(maxp[i-1]*a[i],a[i]),minproduct*a[i]); 内括号是a[i]<0的情况，minproduct*a[i] 是a[i]>0的情况
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
