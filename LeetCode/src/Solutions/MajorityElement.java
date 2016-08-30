package Solutions;

public class MajorityElement {

	public static void main(String[] args) {
		int[] nums = {1,2,2,2,3,4,2};
		System.out.println(majorityElement(nums));

	}
    public static int majorityElement(int[] nums) {
       int c = 0;
       int times = 0;
       for(int i=0;i<nums.length;i++){
    	   if(times==0){
    		   c=nums[i];
    		   times=1;
    	   }else{
        	   if(nums[i]==c){
        		   times++;
        	   }else{
        		   times --;
        	   }
    	   }

       }
       return c;
    }

}
