package Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //思路，跟前面的3sum一致,可以总结出规律
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int n = nums.length;
        if(nums == null || n<4) return res;
        //先排序
        Arrays.sort(nums);
        for(int i = 0 ; i < n-1; i++ ){
            //筛掉重复的
            if(i!=0 && nums[i-1]==nums[i]) continue;
            for(int j=i+1; j<n ; j++){
                //筛掉重复的
                if(j!=i+1 && nums[j-1]==nums[j]) continue;
                int k = j+1;
                int l = n-1;
                while(k<l){
                    if(nums[i]+nums[j]+nums[k]+nums[l]==target){
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[l]);
                        res.add(list);
                        k++;
                        l--;
                        //筛掉重复的
                        while(nums[k-1]==nums[k] && k<l) k++;
                        while(nums[l+1]==nums[l] && k<l) l--;
                    }else if(nums[i]+nums[j]+nums[k]+nums[l]<target) k++;
                    else if(nums[i]+nums[j]+nums[k]+nums[l]>target) l--;
                }
            }
        }
        return res;
        
    }

}
