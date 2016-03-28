package Solutions;

public class S198HouseRobber {
    public int rob(int[] nums) {
        
        //���ö�̬�滮��ά��һ��dp[n+1]������ ʱ�䣺O��n�� �ռ�O��n��(0ms,48.10%)
        //״̬ת�Ʒ��̣�
        //dp[i] = max{dp[i-2]+nums[i],dp[i-1]}(max����ǰ������ i-2�����ֵ+��i�ģ�������i-1�����ֵ������i�ģ�)
        // int size = nums.length;
        // if(size < 2) return size > 0 ? nums[0] : 0; //�߽����
        
        // int[] dp = new int[size];//��ȡһ�����������Ľ��
        // dp[0] = nums[0];//ֻ���ǵ�һ��
        // dp[1] = Math.max(nums[0], nums[1]);//ֻ��������һ��
        // for(int i = 2; i < size ; i++){
        //     dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]); 
        // }
        // return dp[size-1];
        
        ////���ö�̬�滮�� ʱ�䣺O��n�� �ռ�O��1��(0ms,48.10%)
        //best1 ��Ӧdp[i-2] ; best0 ��Ӧdp[i-1]
        // best1 best0 temp best0'
        // i-2   i-1   temp i+1 
        int n = nums.length;
        if( n < 2 ) return n == 0  ? 0 : nums[0];
        int best1 = 0;//���Կ���ѡ����һ������
        int best0 = 0;//���벻ѡ����һ������
        for(int i = 0; i < n; i++){
            int temp = best1+nums[i]; 
            //����i+1�����
            best1 = best0; //i+1�������� ������Ϊiû��ѡ��
            best0 = Math.max(temp, best0); //i+1������������Ϊ���ǿ�������i
        }
        return Math.max(best1,best0);
        
    }
}
