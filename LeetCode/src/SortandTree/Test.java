package SortandTree;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {9,8,7,6,5,4,3,2,1};
		
		System.out.println("����֮ǰ��");
		for(int i:nums) System.out.print(i+" ");
		System.out.print("\n");

		long starTime=System.currentTimeMillis();//��ʼʱ��
		
		//�����㷨
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
		System.out.println("����ʱ�䣺"+Time);
		
		
		System.out.println("����֮��");
		for(int i:nums) System.out.print(i+" ");
		
	}
	/*
	 * �Լ�������дһ��������
	 * **/
	public static void heapSort(int[] h){
		//�Ƚ���һ�³�ʼ��
		for(int i=(h.length-1)/2;i>=0;i--)
			heapAdjust(h,i,h.length-1);
		//���ν���ǰ�Ѷ���������棬Ȼ�������
		for(int i = h.length-1; i > 0; i--){
			int tmp = h[i];
			h[i]=h[0];
			h[0]=tmp;
			heapAdjust(h,0,i-1);
		}
		
	}
	//�Զѽ��е�����
	public static void heapAdjust(int[] h,int s,int m){
		int child = 2*s+1;
		while(child<=m){//��s�������
			//���Һ��Ӷ����ڵĻ���ѡ��һ���ϴ�ĺ���
			if(child+1<=m) child = h[child]> h[child+1] ? child : child+1 ;
			if(h[s]<h[child]){
				//���ڵ�ͽϴ��ӻ��ཻ��
				int tmp = h[s];
				h[s]=h[child];
				h[child] = tmp;
				s = child;//��Ҫ������ָ�����
				child = 2*s +1;//���ӽڵ����
			}else
				break;//����Ҫ���е���
		}
	}
	//�Լ�����дһ������
	public static void QuickSort(int[] a){
		if(a.length>0){
			quick(a,0,a.length-1);
		}
	}
	public static void quick(int[] a, int low, int high){
		if(low<high){///�����������жϵݹ���޷��˳����¶�ջ����쳣
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
	
	//�Լ�����дһ���鲢�ĵݹ��㷨
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
	//дһ���ǵݹ�Ĺ鲢�����㷨
	//˼·:�鲢���ȴ�1��ʼ��ÿ�ι鲢���ȱ�Ϊԭ����2��
	//��Ҫע�⴦��鲢�γ���Ϊ����   �Լ�  ���һ���鲢�γ��Ⱥ�ǰ�治��ȵ���� 
	public static void mergeSortNonRer(int[] a, int left, int right){
		int len = 1;//ÿ�εĹ鲢����
		while(len<a.length){
			//����for��һ�˹鲢
			for(int i=0; i+len <a.length; i = i+len*2){
				int low = i;
				int mid = i+len-1;
				int high = i+2*len-1;
				if(high>a.length-1) high = a.length-1;//����һ�±߽����
				merge(a,low,mid,high);
			}
			len = len*2;
		}
	}
	

}
