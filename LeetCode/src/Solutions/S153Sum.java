package Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S153Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] S = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
		List<List<Integer>>  res = threeSum(S);
		for(List<Integer> ll : res){
			String s = "";
			for(Integer l : ll){
				s += l+"\t";
			}
			System.out.println(s);
				
		}
		
		
	}
    //设置两个指针，用O(n^2)时间复杂度
    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>>  res = new ArrayList<List<Integer>>();
        //边界情况
        int n = nums.length;
        if(n<3 || nums==null) return res;
        //为了防止重复，先排个序
        Arrays.sort(nums);
        for(int i=0; i<n-1 ;i++){
            //处理i可能出现的重复
            if(i==0 || nums[i]>nums[i-1]){
                int j=i+1;
                int k=n-1;
                
                while(j<k){
                    if(nums[i]+nums[j]+nums[k]==0 && j<k){
                        List<Integer> l = new ArrayList<Integer>(); 
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[k]);
                        res.add(l);
                        //继续更新两个指针
                        j++;
                        k--; 
                        //处理一下j k的重复问题
                        while(j<k && nums[j]==nums[j-1]) j++;
                        while(j<k && nums[k]==nums[k+1]) k--;
                    }else if(nums[i]+nums[j]+nums[k]<0){
                        j++;
                    }else{
                        k--;
                    }
                }
            }
            
        }
        return res;
    }

}
