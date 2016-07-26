package Solutions;

import java.util.HashMap;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,3,4,0};
		int[] res = twoSum(nums,0);
		for(int i = 0 ; i <res.length ; i++)
			System.out.print(res[i]+" ");
	}
    public static int[] twoSum(int[] nums, int target) {
        
        //思路：暴力搜索（73ms 6.31%）
        // int[] res =  new int[2];//结果
        // for(int i = 0 ; i< nums.length; i++){
        //     for(int j = i+1; j < nums.length; j++){
        //         if(nums[i]+nums[j]==target){
        //             res[0]=i;
        //             res[1]=j;
        //         }
        //     }
        // }
        // return res;
        
        //思路：用一个map来存看过的元素(8ms 44.57%)
        int[] res = new int[2];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i<nums.length; i++){
            if(map.containsKey(target-nums[i])){
                res[1] = i;
                res[0] = map.get(target-nums[i]);
            }
            map.put(nums[i],i);
        }
        return res;
    }

}
