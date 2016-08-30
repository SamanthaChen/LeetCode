package Solutions;
//题目要求是对数的时间复杂度，考虑到二分查找

public class FindPeakElement {

	public static void main(String[] args) {
		int[] nums = {1,2,1,2,1};
		System.out.println(findPeakElement(nums));

	}
	//O(n)空间
    public int findPeakElement1(int[] nums) {
        int n = nums.length;
        int[] newnums = new int[n+2];
        for(int i=1;i<=n;i++){
            newnums[i]=nums[i-1];
        }
        newnums[0]=Integer.MIN_VALUE;
        newnums[n+1]=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            if(newnums[i]>newnums[i-1] && newnums[i]>newnums[i+1]){
                return i-1;
            }
        }
        return 0;
    }
    public int findPeakElement2(int[] nums) {
    	if(nums.length==1) return 0;
        for(int i=0;i<nums.length;i++){
        	if(i==0 && nums[i]>nums[i+1]) {
        		return i;
        	}else if(0<i && i<nums.length-1 && nums[i]>nums[i-1] && nums[i]>nums[i+1]){
        		return i;
        	}else if(i==nums.length-1 && nums[i]>nums[i-1]){
        		return i;
        	}
        }
        return 0;
    }
    //二分查找
//    如果  nums[i-1]<nums[i]>nums[i+1]  nums[i]是peak
//    如果 nums[i-1]<nums[i]<nums[i+1] peak在 i+1~n-1有peak
//    如果  nums[i-1]>nums[i]>nums[i+1]  peak在0~i-1
    public static int findPeakElement2(int[] nums) {
    	return binarySearch(nums,0,nums.length-1);
    }
    public static int binarySearch(int[] nums,int start, int end){
    	if(start == end){//只有一个元素
    		return start;
    	}else if(start+1==end){//只有两个元素的,输出大的
    		return nums[start]>nums[end] ? start: end;
    	}else{
    		int mid = (start+end)/2;
    		if(nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1]){
    			return mid;//符合条件的
    		}else if(nums[mid-1]<nums[mid]&& nums[mid]<nums[mid+1]){//递增的
    			return binarySearch(nums,mid+1,end);
    		}else {//递减的 if(nums[mid-1]>nums[mid]&& nums[mid]>nums[mid+1])
    			return binarySearch(nums,start,mid-1);
    		}
    	}
    }
    public static int findPeakElement(int[] nums) {
    	int start = 0;
    	int end = nums.length-1;
    	while(start<end){
    		int mid = (start+end)/2;
    		if(nums[mid]>nums[mid+1]){
    			end = mid;
    		}else{
    			start =mid+1;
    		}
    	}
    	return start;//start =end的情况
    }

}
