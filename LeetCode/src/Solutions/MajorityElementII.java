package Solutions;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {

	public static void main(String[] args) {
		int[] nums = {1,2};
		List<Integer> res = majorityElement(nums);
		res.forEach(e->{System.out.print(e+" ");});

	}
	//思路：与majority1一样
	//需要考虑的情况：
//	1、nums长度为1
//	2、major element只有一个，就是有一个超过1/2，另一个没有
	
    public static List<Integer> majorityElement(int[] nums) {
    	List<Integer> res = new ArrayList<Integer>();
    	if(nums==null || nums.length==0) return res;
        int candidate1 = 0;
        int candidate2 = 0;
        int time1=0;
        int time2=0;
        for(int n:nums){
        	if(n==candidate1){
        		time1++;
        	}else if(n==candidate2){
        		time2++;
        	}else if(time1==0){
        		candidate1 = n;
        		time1 = 1;
        	}else if(time2==0){
        		candidate2=n;
        		time2=1;
        	}else{
        		time1--;
        		time2--;
        	}
        }
        time1=0;
        time2=0;
        for(int n:nums){
        	if(n==candidate1) time1++;
        	else if(n==candidate2) time2++;
        }
        if(time1>(nums.length/3)){
        	res.add(candidate1);
        }
        if(time2>(nums.length/3)){
        	res.add(candidate2);
        }

        return res;
       
    }
}
