package Solutions;

public class S198HouseRobber {
    public int rob(int[] nums) {
        
        //采用动态规划，维护一个dp[n+1]的数组 时间：O（n） 空间O（n）(0ms,48.10%)
        //状态转移方程：
        //dp[i] = max{dp[i-2]+nums[i],dp[i-1]}(max（当前考虑完 i-2的最大值+抢i的，考虑完i-1的最大值（不抢i的）)
        // int size = nums.length;
        // if(size < 2) return size > 0 ? nums[0] : 0; //边界情况
        
        // int[] dp = new int[size];//多取一个数保存最后的结果
        // dp[0] = nums[0];//只考虑第一个
        // dp[1] = Math.max(nums[0], nums[1]);//只能抢其中一个
        // for(int i = 2; i < size ; i++){
        //     dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]); 
        // }
        // return dp[size-1];
        
        ////采用动态规划， 时间：O（n） 空间O（1）(0ms,48.10%)
        //best1 对应dp[i-2] ; best0 对应dp[i-1]
        // best1 best0 temp best0'
        // i-2   i-1   temp i+1 
        int n = nums.length;
        if( n < 2 ) return n == 0  ? 0 : nums[0];
        int best1 = 0;//可以考虑选择下一个房间
        int best0 = 0;//必须不选择下一个房间
        for(int i = 0; i < n; i++){
            int temp = best1+nums[i]; 
            //更新i+1的情况
            best1 = best0; //i+1可以抢了 （是因为i没有选）
            best0 = Math.max(temp, best0); //i+1不能抢，是因为考虑可能抢了i
        }
        return Math.max(best1,best0);
        
    }
}
