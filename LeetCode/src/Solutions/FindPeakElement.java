package Solutions;
//��ĿҪ���Ƕ�����ʱ�临�Ӷȣ����ǵ����ֲ���

public class FindPeakElement {

	public static void main(String[] args) {
		int[] nums = {1,2,1,2,1};
		System.out.println(findPeakElement(nums));

	}
	//O(n)�ռ�
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
    //���ֲ���
//    ���  nums[i-1]<nums[i]>nums[i+1]  nums[i]��peak
//    ��� nums[i-1]<nums[i]<nums[i+1] peak�� i+1~n-1��peak
//    ���  nums[i-1]>nums[i]>nums[i+1]  peak��0~i-1
    public static int findPeakElement2(int[] nums) {
    	return binarySearch(nums,0,nums.length-1);
    }
    public static int binarySearch(int[] nums,int start, int end){
    	if(start == end){//ֻ��һ��Ԫ��
    		return start;
    	}else if(start+1==end){//ֻ������Ԫ�ص�,������
    		return nums[start]>nums[end] ? start: end;
    	}else{
    		int mid = (start+end)/2;
    		if(nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1]){
    			return mid;//����������
    		}else if(nums[mid-1]<nums[mid]&& nums[mid]<nums[mid+1]){//������
    			return binarySearch(nums,mid+1,end);
    		}else {//�ݼ��� if(nums[mid-1]>nums[mid]&& nums[mid]>nums[mid+1])
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
    	return start;//start =end�����
    }

}
