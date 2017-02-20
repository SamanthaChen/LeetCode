package Solutions;

public class MedianodTwoSortedArray {
    //简单的思路是重新插入一个新的表（O(m+n)）然后求中间元素(O(1)
    //或者不用完全二分插入，直接插入到中间元素就停止
    // public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    //     int n = (nums1.length+nums2.length)/2 + 1;
    //     int[] leftmid = new int[n];
    //     int k=0;
    //     int i=0;
    //     int j=0;
    //     while( k<n){
    //         	//需要考虑如果一边已经加完了的情况
    //         	if(i<nums1.length && j<nums2.length){
    //                 if(nums1[i]<nums2[j]){
    //                     leftmid[k++]=nums1[i];
    //                     i++;
    //                 }else{
    //                     leftmid[k++]=nums2[j];
    //                     j++;
    //                 }
    //         	}else if(i<nums1.length){//j已经到尽头
    //                 leftmid[k++]=nums1[i];
    //                 i++;
    //         	}else if(j<nums2.length){
    //                 leftmid[k++]=nums2[j];
    //                 j++;
    //         	}

    //       }
    //     return (nums1.length+nums2.length)%2 == 0 ? (leftmid[n-2]+leftmid[n-1])/2.0 : leftmid[n-1];
    // }
    
    
    //思路2：二分查找
//    public static double findMedianSortedArrays(int[] A, int[] B){
//        int m = A.length;
//        int n = B.length;
//        
//        if((m+n)%2 ==1) return findKth(A,0,m-1,B,0,n-1,(m+n+1)/2);
//        else return (findKth(A,0,m-1,B,0,n-1,(m+n+1)/2) +findKth(A,0,m-1,B,0,n-1,(m+n+1)/2+1))/2.0;
//        
//    }
//    public static int findKth(int[] A,int al,int ar,int[] B, int bl, int br,int k){
//        //临界情况
//    	int alen = (ar-al)+1;
//    	int blen = (br-bl)+1;
//    	if(alen==0) return B[bl+k-1];
//    	if(blen==0) return A[al+k-1];
//    	if(k==0) return Math.min(A[al], B[bl]);
//    	int amid = (ar+al)/2;
//    	int bmid = (br+bl)/2;
//    	if(A[amid]<B[bmid]){
//    		
//    	}
//}
    public static double findMedianSortedArrays(int[] A, int[] B){
        int m = A.length;
        int n = B.length;
        
        if((m+n)%2 ==1) return findKth(A,0,m-1,B,0,n-1,(m+n)/2);//总序列长度是奇数，找一个数就行了
        else return (findKth(A,0,m-1,B,0,n-1,(m+n)/2) +findKth(A,0,m-1,B,0,n-1,(m+n)/2+1))/2.0;//偶数，找两个数的平均
        
    }
    public static int findKth(int[] A,int al,int ar,int[] B, int bl, int br,int k){
        //临界情况
        int alen = ar-al+1; 
        int blen = br-bl+1;
        if(alen==0) return B[bl+k];//A的找完了 直接在B里面找第k个
        if(blen==0) return A[al+k];//B的找完了，B的找完了，直接在A里面找第k个
        if(k==0) return Math.min(A[al],B[bl]);//返回较小的
        
        int amid = (k*alen/(alen+blen)) ;
        int bmid = k-1-amid;
        amid = al+amid;
        bmid = bl+bmid;
     
        if(A[amid]<=B[bmid]){
            k = k-(amid-al)-1; 
            al = amid+1; //抛弃A前面的，太小了
            
        }else {
            k=k-(bmid-bl)-1;
            bl=bmid+1; //抛弃B前面的，太小了
        }
        return findKth(A,al,ar,B,bl,br,k);
 
		
            
    }
 
		
            
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1,2,3,4,5};
		int[] nums2 = {6,7};
		System.out.println(findMedianSortedArrays(nums1,nums2));
	}

}
