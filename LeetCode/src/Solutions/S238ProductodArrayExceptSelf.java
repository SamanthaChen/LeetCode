package Solutions;

public class S238ProductodArrayExceptSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int[] productExceptSelf(int[] nums) {
        //思路，将乘积分为左右两边部分，没有的部分设为1(2ms 49%)
        //       [1    2   3   4]
        //left:   1    1   2   6
        //right:  24  12  4   1
        //product:24  12  8    6
        int n = nums.length;
        int[] res = new int[n];
        res[0]=1;
        for(int i = 1; i < n; i++){
            res[i] = res[i-1]*nums[i-1];
        }
        int right =1;
        for(int j = n-1;j >= 0; j--){
            res[j] = res[j]*right;
            right = right*nums[j];
        }
        return res;
        
    }

}
