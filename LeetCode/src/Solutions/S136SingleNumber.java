package Solutions;

import java.util.HashMap;
import java.util.Map;

public class S136SingleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-1,2,3,-1,3,2,-7};
		System.out.println(singleNumber(nums));
	}
    public static int singleNumber(int[] nums) {
        
        
        //思路1：用一个map(28ms 4.18%)
        // HashMap<Integer,Integer>  map = new HashMap<Integer,Integer>();
        // for(int i=0; i<nums.length; i++){
        //     if(map.containsKey(nums[i])) map.put(nums[i],map.get(nums[i])+1);
        //     else map.put(nums[i],1);
        // }
        // for(Map.Entry<Integer,Integer> entry : map.entrySet()){
        //     if(entry.getValue() == 1) return entry.getKey();
        // }
        // return 0;
        
        //思路2：用异或
        //例如一个数[1,2,2,5,1,3,3] 异或 1^2^2^5^1^3^3 = (1^1)^(2^2)^(3^3)^5=0^0^0^5=5
        int res = 0;
        for(int i = 0 ; i < nums.length; i++){
            res ^= nums[i];
        }
        return res;
        
        
    }
}
