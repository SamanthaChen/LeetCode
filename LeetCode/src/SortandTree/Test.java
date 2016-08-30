package SortandTree;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {9,8,7,6,5,4,3,2,1};
		
		System.out.println("排序之前：");
		for(int i:nums) System.out.print(i+" ");
		System.out.print("\n");

		long starTime=System.currentTimeMillis();//开始时间
		
		//排序算法
//		straightInsertion(nums);
//		binaryInsertion(nums);
//		shellSort(nums);
//		simpleSelect(nums);
//		heapSort(nums);
//		QuickSort(nums);
//		mergesort(nums,0,nums.length-1);
		mergeSortNonRer(nums,0,nums.length-1);
		
		long endTime=System.currentTimeMillis();
		long Time = endTime-starTime;
		System.out.println("运行时间："+Time);
		
		
		System.out.println("排序之后：");
		for(int i:nums) System.out.print(i+" ");
		
	}
	/*
	 * 自己再重新写一个堆排序
	 * **/
	public static void heapSort(int[] h){
		//先建立一下初始堆
		for(int i=(h.length-1)/2;i>=0;i--)
			heapAdjust(h,i,h.length-1);
		//依次将当前堆顶输出到后面，然后调整堆
		for(int i = h.length-1; i > 0; i--){
			int tmp = h[i];
			h[i]=h[0];
			h[0]=tmp;
			heapAdjust(h,0,i-1);
		}
		
	}
	//对堆进行调整的
	public static void heapAdjust(int[] h,int s,int m){
		int child = 2*s+1;
		while(child<=m){//从s往后调整
			//左右孩子都存在的话，选择一个较大的孩子
			if(child+1<=m) child = h[child]> h[child+1] ? child : child+1 ;
			if(h[s]<h[child]){
				//根节点和较大孩子互相交换
				int tmp = h[s];
				h[s]=h[child];
				h[child] = tmp;
				s = child;//需要调整的指针后移
				child = 2*s +1;//孩子节点后移
			}else
				break;//不需要进行调整
		}
	}
	//自己重新写一个快排
	public static void QuickSort(int[] a){
		if(a.length>0){
			quick(a,0,a.length-1);
		}
	}
	public static void quick(int[] a, int low, int high){
		if(low<high){///如果不加这个判断递归会无法退出导致堆栈溢出异常
			int pivotloc = partition(a,low,high);
			quick(a,low,pivotloc-1);
			quick(a,pivotloc+1,high);
		}

	}
	public static int partition(int[] a,int low, int high){
		int pivot = a[low];
		while(low<high){
			while(low<high && a[high]>=pivot)high--;
			a[low]=a[high];
			while(low<high && a[low]<=pivot)low++;
			a[high]=a[low];
		}
		a[low]=pivot;
		return low;
	}
	
	//自己重新写一个归并的递归算法
	public static void mergesort(int[] nums,int left, int right){
		if(left<right){
			int middle = (left+right)/2;
			mergesort(nums,left,middle);
			mergesort(nums,middle+1,right);
			merge(nums,left,middle,right);
		}

	}
	public static void merge(int[] nums, int left, int middle, int right){
		int[] tmp = new int[nums.length];
		int l = left;
		int r = middle+1;
		int k=left;
		while(l<=middle && r<=right && k<nums.length){
			if(nums[l]<=nums[r]) tmp[k++] =nums[l++];
			else tmp[k++] = nums[r++];
		}
		while(l<=middle && k<nums.length) tmp[k++] =nums[l++];
		while(r<=right && k<nums.length) tmp[k++] =nums[r++];
		
		k=left;
		while(k<=right){
			nums[k]= tmp[k];
			k++;
		}
	}
	//写一个非递归的归并排序算法
	//思路:归并长度从1开始，每次归并长度变为原来的2倍
	//需要注意处理归并段长度为奇数   以及  最后一个归并段长度和前面不相等的情况 
	public static void mergeSortNonRer(int[] a, int left, int right){
		int len = 1;//每次的归并长度
		while(len<a.length){
			//里面for是一趟归并
			for(int i=0; i+len <a.length; i = i+len*2){
				int low = i;
				int mid = i+len-1;
				int high = i+2*len-1;
				if(high>a.length-1) high = a.length-1;//处理一下边界情况
				merge(a,low,mid,high);
			}
			len = len*2;
		}
	}
	

}
