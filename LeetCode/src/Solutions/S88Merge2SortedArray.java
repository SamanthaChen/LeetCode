package Solutions;

public class S88Merge2SortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] nums1 = {1,3,5,7,9,0,0,0,0};
		 int[] nums2 = {2,4,6,8};
		 merge(nums1,5,nums2,4);
		 for(int i=0;i<9;i++){
			 System.out.print(nums1[i]+" ");
		 }
	}
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //从后面开始插入吧(0ms 42.52%)
        int i = 0;
        int k = m+n-1;
        int p1 = m-1;//这里表明m和n必须大于1
        int p2 = n-1;
        while(p1>=0 && p2>=0){
            if(nums1[p1]>nums2[p2]){
                nums1[k--] = nums1[p1--];
            }else{
                nums1[k--] = nums2[p2--];
            }
        }
        while(p2>=0){
            nums1[k--]=nums2[p2--]; 
        }
    }
}
