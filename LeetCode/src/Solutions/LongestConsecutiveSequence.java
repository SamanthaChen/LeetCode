package Solutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {9,1,-3,2,4,8,3,-1,6,-2,-4,7};
		System.out.println(longestConsecutive(nums));

	}
	//考虑一下可能出现重复的，如[0,1,1,1,2]长度应该为3
//    public static int longestConsecutive(int[] nums) {
//        
//        if(nums.length<=1)return nums.length;
//        Arrays.sort(nums);
//        int current = 1;
//        int res = 1;
//        for(int i=1;i<nums.length;i++){
//            //处理重复的元素
//            while(i<nums.length && nums[i]==nums[i-1] ) i++;
//            if(i==nums.length) break;
//            if(nums[i]==nums[i-1]+1) current++;
//            else{
//                if(current>res) {
//                    res = current;
//                } 
//                current =1;
//            }
//        }
//        return res>current? res:current;
//    }
	
    //简单的思想是先排序，但是排序需要O(nlogn)
    //为了获得O(n)时间复杂度可以采用空间换时间
     public static int longestConsecutive(int[] nums) {
         if(nums==null || nums.length<1) return nums.length;
         int res = 1;
         Set<Integer> set = new HashSet<Integer>();
         for(int e: nums) set.add(e);
         for(int e: nums){
             set.remove(e);
             int left = e-1;
             int right = e+1;
             int current = 1;
             while(set.contains(left)){
                 set.remove(left);
                 current++;
                 left--;
             }
             while(set.contains(right)){
                 set.remove(right);
                 current++;
                 right++;
             }
             res = Math.max(res,current);
         }
         return res;
     }
}
