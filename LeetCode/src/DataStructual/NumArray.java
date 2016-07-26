package DataStructual;

public class NumArray {
    int[] nums;
    //思路：提前计算和（动态规划的思想？）
    public NumArray(int[] nums) {
    	
        for(int i = 1; i < nums.length; i++){
            nums[i] = nums[i-1]+nums[i];
        }
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        if(i == 0) return nums[j];
        return nums[j]-nums[i-1];
    }
}
