package Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //˼·����ǰ���3sumһ��,�����ܽ������
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int n = nums.length;
        if(nums == null || n<4) return res;
        //������
        Arrays.sort(nums);
        for(int i = 0 ; i < n-1; i++ ){
            //ɸ���ظ���
            if(i!=0 && nums[i-1]==nums[i]) continue;
            for(int j=i+1; j<n ; j++){
                //ɸ���ظ���
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
                        //ɸ���ظ���
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
