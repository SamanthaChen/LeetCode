package Test;

public class MedianodTwoSortedArrays {

	public static void main(String[] args) {
		int[] nums1 = {1,2,3,8,9,10,14};
		int[] nums2 = {4,5,6,7,11,12,13};
		System.out.println(findMedianSortedArrays(nums1,nums2));

	}
	//二分查找，分而治之
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	int len1 = nums1.length;
    	int len2 = nums2.length;
    	int k = (len1+len2)/2;
    	if((len1+len2)%2==1)
    		return findKth(nums1,0,len1-1,nums2,0,len2-1,k);
    	else
    		return (findKth(nums1,0,len1-1,nums2,0,len2-1,k-1)+findKth(nums1,0,len1-1,nums2,0,len2-1,k))/2.0;
        
    }
    public static  int findKth(int[] nums1,int low1, int high1,int[] nums2, int low2,int high2,int k){
    	//结束条件
    	int len1 = high1-low1+1;
    	int len2 = high2-low2+1;
    	if(len1==0){
    		return nums2[low2+k];
    	}
    	if(len2==0){
    		return nums1[low1+k];
    	}
    	if(k==0){
    		return Math.min(nums1[low1], nums2[low2]);
    	}
    	//递归查找

    	//这只是长度
    	int mid1 = k*(len1/(len1+len2)); 
    	int mid2 = k - mid1 - 1; 
    	//这是位置
    	mid1 += low1;
    	mid2 += low2;
    	//判断往哪边缩小范围
    	if(nums1[mid1]<=nums2[mid2]){
    		k = k - (mid1-low1)-1;//不考虑mid以及她前面的
    		low1 = mid1+1;
    	}else{
    		k = k - (mid2-low2)-1;
    		low2 = mid2+1;
    	}
    	return findKth(nums1,low1,high1,nums2,low2,high2,k);
    }
    

}
