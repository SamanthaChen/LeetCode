package Solutions;

public class SearchInsertPosition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int searchInsert(int[] nums, int target) {
        
//        //
//        for(int i=0; i<nums.length;i++){
//            if(target==nums[i]) return i;
//            if(target<nums[i]) return i;
//        }
//        return nums.length;
    	
        //¶þ·Ö²éÕÒ
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid=(low+high)/2; 
            if(target==nums[mid]) return mid;
            else if(target<nums[mid]) high=mid-1;
            if(target>nums[mid]) low=mid+1;
        }
        return low;
    }
}
