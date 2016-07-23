package SortAlgorithm;

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
		QuickSort(nums);
		
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
	

}
