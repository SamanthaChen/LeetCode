package JulyAlgotithm;
/*
 * 有两个序列A和B,A=(a1,a2,...,ak),B=(b1,b2,...,bk),A和B都按升序排列，
 * 对于1<=i,j<=k，求k个最小的（ai+bj），要求算法尽量高效。
 * **/
public class KtninTwoSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 * 分析：假设两个整数数组为A和B，各有N个元素，任意两个数的和组成的数组C有N^2个元素。那么可以把这些和看成N个有序数列：
          A[1]+B[1] <= A[1]+B[2] <= A[1]+B[3] <=…

          A[2]+B[1] <= A[2]+B[2] <= A[2]+B[3] <=…

          …

         A[N]+B[1] <= A[N]+B[2] <= A[N]+B[3] <=…
 		问题转变成，在这N个有序数列里，找到前k小的元素”。
	 * 用k的最大堆，时间是O(klogk)
	 * **/
	public static int[] findKth(int[] A, int[] B,int k){
		int[] res = new int[k];
		
		
		return res;
	}
	public static void heapAdjust(int[] nums){
		
	}

}
