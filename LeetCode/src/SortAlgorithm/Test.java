package SortAlgorithm;

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
		QuickSort(nums);
		
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
	

}
