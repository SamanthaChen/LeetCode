package Solutions;

public class MedianodTwoSortedArray {
    //�򵥵�˼·�����²���һ���µı�O(m+n)��Ȼ�����м�Ԫ��(O(1)
    //���߲�����ȫ���ֲ��룬ֱ�Ӳ��뵽�м�Ԫ�ؾ�ֹͣ
    // public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    //     int n = (nums1.length+nums2.length)/2 + 1;
    //     int[] leftmid = new int[n];
    //     int k=0;
    //     int i=0;
    //     int j=0;
    //     while( k<n){
    //         	//��Ҫ�������һ���Ѿ������˵����
    //         	if(i<nums1.length && j<nums2.length){
    //                 if(nums1[i]<nums2[j]){
    //                     leftmid[k++]=nums1[i];
    //                     i++;
    //                 }else{
    //                     leftmid[k++]=nums2[j];
    //                     j++;
    //                 }
    //         	}else if(i<nums1.length){//j�Ѿ�����ͷ
    //                 leftmid[k++]=nums1[i];
    //                 i++;
    //         	}else if(j<nums2.length){
    //                 leftmid[k++]=nums2[j];
    //                 j++;
    //         	}

    //       }
    //     return (nums1.length+nums2.length)%2 == 0 ? (leftmid[n-2]+leftmid[n-1])/2.0 : leftmid[n-1];
    // }
    
    
    //˼·2�����ֲ���
//    public static double findMedianSortedArrays(int[] A, int[] B){
//        int m = A.length;
//        int n = B.length;
//        
//        if((m+n)%2 ==1) return findKth(A,0,m-1,B,0,n-1,(m+n+1)/2);
//        else return (findKth(A,0,m-1,B,0,n-1,(m+n+1)/2) +findKth(A,0,m-1,B,0,n-1,(m+n+1)/2+1))/2.0;
//        
//    }
//    public static int findKth(int[] A,int al,int ar,int[] B, int bl, int br,int k){
//        //�ٽ����
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
        
        if((m+n)%2 ==1) return findKth(A,0,m-1,B,0,n-1,(m+n)/2);//�����г�������������һ����������
        else return (findKth(A,0,m-1,B,0,n-1,(m+n)/2) +findKth(A,0,m-1,B,0,n-1,(m+n)/2+1))/2.0;//ż��������������ƽ��
        
    }
    public static int findKth(int[] A,int al,int ar,int[] B, int bl, int br,int k){
        //�ٽ����
        int alen = ar-al+1; 
        int blen = br-bl+1;
        if(alen==0) return B[bl+k];//A�������� ֱ����B�����ҵ�k��
        if(blen==0) return A[al+k];//B�������ˣ�B�������ˣ�ֱ����A�����ҵ�k��
        if(k==0) return Math.min(A[al],B[bl]);//���ؽ�С��
        
        int amid = (k*alen/(alen+blen)) ;
        int bmid = k-1-amid;
        amid = al+amid;
        bmid = bl+bmid;
     
        if(A[amid]<=B[bmid]){
            k = k-(amid-al)-1; 
            al = amid+1; //����Aǰ��ģ�̫С��
            
        }else {
            k=k-(bmid-bl)-1;
            bl=bmid+1; //����Bǰ��ģ�̫С��
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
