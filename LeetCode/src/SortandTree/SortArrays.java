package SortandTree;

import java.util.ArrayList;
import java.util.List;

/*
 * ��������������������
 * 
 * **/
public class SortArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 49, 38, 65, 97, 76, 13, 27, 49 };
		// int[] nums = {9,8,7,6,5,4,3,2,1};

		System.out.println("����֮ǰ��");
		for (int i : nums)
			System.out.print(i + " ");
		System.out.print("\n");

		long starTime = System.currentTimeMillis();// ��ʼʱ��

		// �����㷨
		// straightInsertion(nums);
		// binaryInsertion(nums);
		// shellSort(nums);
		// simpleSelect(nums);
		// heapSort(nums);
		// bubbleSort(nums);
		// bubbleSort2(nums);
		// quickSort(nums);
		// mergeSort(nums,0,nums.length-1);
		radixSort(nums);

		long endTime = System.currentTimeMillis();
		long Time = endTime - starTime;
		System.out.println("����ʱ�䣺" + Time);

		System.out.println("����֮��");
		for (int i : nums)
			System.out.print(i + " ");

	}

	/*
	 * ֱ�Ӳ��������ȶ��� ʱ�临�Ӷȣ�O(n^2) ����ʱ����ã�O(n) ����ʱ����O(n^2)
	 **/
	public static void straightInsertion(int[] a) {
		int temp = 0;
		for (int i = 1; i < a.length; i++) {
			temp = a[i];// ���Ƚ�Ԫ��
			int j = i - 1;
			for (; j >= 0 && a[j] > temp; j--)
				a[j + 1] = a[j]; // ���ڼ����ڵ�Ԫ�غ���
			a[j + 1] = temp;
		}
	}

	/*
	 * ���ֲ���(�ȶ�) ʱ�临�Ӷȣ� ˼·��������ֱ�Ӳ���һ�£�ֻ�ǲ��ö��ַ���ǰ������������н��в��롣 ���Լ��ٱȽϴ����������ƶ�������ֱ�Ӳ�����ͬ
	 **/
	public static void binaryInsertion(int[] a) {
		int temp = 0;
		for (int i = 1; i < a.length; i++) {
			temp = a[i];// ���Ƚϵ�����
			int low = 0;
			int high = i - 1;
			int mid = 0;
			// �����ö��ֲ�����0~i-1�����������У�Ѱ��һ�²���λ��
			while (low <= high) {
				mid = (low + high) / 2;
				if (temp > a[mid])
					low = mid + 1;
				else
					high = mid - 1;
			}
			// ����λ��Ϊlow����high+1���Ѻ������������
			int j = i - 1;
			for (; j >= low; j--)
				a[j + 1] = a[j];
			a[j + 1] = temp;
		}
	}

	/*
	 * ϣ������(���ȶ�) ʱ�临�Ӷȣ�O(nlogn)
	 * 
	 * �ҵ�����ǣ����ղ�ͬ���������з��飬Ȼ���ÿ������ֱ�Ӳ������� �����õļ򵥵���������d = {n/2 ,n/4, n/8 ��..1}
	 * ϣ������ʱЧ�������ѣ��ؼ���ıȽϴ������¼�ƶ�����������������������d��ѡȡ�� �ض�����¿���׼ȷ������ؼ���ıȽϴ����ͼ�¼���ƶ�������
	 * Ŀǰ��û���˸���ѡȡ��õ������������еķ����������������п����и���ȡ������ȡ�����ģ�Ҳ��ȡ�����ġ� ����Ҫע�⣺���������г�1
	 * ��û�й����ӣ������һ���������ӱ���Ϊ1��ϣ�����򷽷���һ�����ȶ������򷽷���
	 **/
	public static void shellSort(int a[]) {
		int dk = a.length;
		while (true) {
			dk = dk / 2;
			for (int x = 0; x < dk; x++) {// ����x�Ƿ�����
				// ����Բ�ͬ��С�����ֱ�Ӳ���
				for (int i = x + dk; i < a.length; i = i + dk) {
					int temp = a[i];
					int j = i - dk;
					for (; j >= 0 && a[j] > temp; j = j - dk)
						a[j + dk] = a[j];// ����tempԪ�غ���
					a[j + dk] = temp;// ���Ƚ�Ԫ�ز����λ��
				}
			}
			if (dk == 1)
				break;// ֹͣ����
		}

	}

	/*
	 * ��ѡ������(���ȶ�) ʱ�临�Ӷȣ� O(n^2) ˼�룺ÿ�δӴ������������ѡ����С�����ַŵ��Ѿ�����ı����
	 **/
	public static void simpleSelect(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int temp = a[i];
			int position = i;
			// ��δ�����������ѡ����Сֵ
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < temp) {
					temp = a[j];
					position = j;
				}
			}
			// �ѵ�ǰ��i��λ�õ������ҵ��ĵ�iС�����ֽ��н���
			a[position] = a[i];
			a[i] = temp;
		}

	}

	/*
	 * ������(���ȶ�) ʱ�临�Ӷ�O(nlogn) ���ʣ�����i�ڵ���һ���Ƕ˵�ڵ㣬��parent(i)=1/2,
	 * leftChild(i)=2i,rightChild(i)=2*i+1 �ѳ�ʼ��һλ���鿴��һ����ȫ��������һλ�洢��ʽ
	 * 1���Ȱѳ�ʼ�����������С�ѣ���n/2(ȡ�½�)�ĸ��ڵ㿪ʼ�������� 2��ÿ��ȡH[0]�����һ��Ԫ�ؽ��н�������ÿ��ȡ��ǰ�Ѷ��ŵ�����
	 * 3��������0~i��Ԫ�ؽ��е���
	 * 
	 * ���������logn+1
	 **/
	public static void heapSort(int[] h) {
		// �Ƚ���һ�³�ʼ��
		for (int i = (h.length - 1) / 2; i >= 0; i--)// ��ֻ��ǰ�벿��
			heapAdjust(h, i, h.length - 1);
		// ���ν���ǰ�Ѷ���������棬Ȼ�������
		for (int i = h.length - 1; i > 0; i--) {
			int tmp = h[i];
			h[i] = h[0];
			h[0] = tmp;
			heapAdjust(h, 0, i - 1);
		}

	}

	public static void heapAdjust(int[] h, int s, int m) {
		int child = 2 * s + 1;
		while (child <= m) {// ��s�������
			// ���Һ��Ӷ����ڵĻ���ѡ��һ���ϴ�ĺ���
			if (child + 1 <= m)
				child = h[child] > h[child + 1] ? child : child + 1;
			if (h[s] < h[child]) {
				// ���ڵ�ͽϴ��ӻ��ཻ��
				int tmp = h[s];
				h[s] = h[child];
				h[child] = tmp;
				s = child;// ��Ҫ������ָ�����
				child = 2 * s + 1;// ���ӽڵ����
			} else
				break;// ����Ҫ���е���
		}
	}

	/*
	 * ð������ ʱ�临�Ӷȣ�ƽ��O(n^2)���O(n) �Ľ���1������һ����־������ĳһ�β���������ʱ��Ϳ���ֹͣ�ˡ�
	 * 2������һ��־�Ա���pos,���ڼ�¼ÿ�����������һ�ν��н�����λ�á�����posλ��֮��ļ�¼���ѽ�����λ,
	 * ���ڽ�����һ������ʱֻҪɨ�赽posλ�ü��ɡ�
	 * 
	 **/
	public static void bubbleSort(int[] a) {
		// �Ӻ��濪ʼ�ɣ�С��ð���ŵ�ǰ��ȥ
		// for(int i=a.length-1; i>0; i--){
		// for(int j=a.length-1;j>a.length-1-i;j--){
		// if(a[j]<a[j-1]){//���������ǰ��С������
		// int tmp = a[j];
		// a[j]=a[j-1];
		// a[j-1]=tmp;
		// }
		// }
		// }

		// ��ǰ�濪ʼ��������ݵ�����ȥ
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - 1 - i; j++) {// ��ȥi����Ϊ����i���Ѿ��ź���
				if (a[j] > a[j + 1]) {
					int tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tmp;
				}
			}
		}
	}

	/*
	 * ˫���ð������
	 **/
	public static void bubbleSort2(int[] a) {
		int low = 0;
		int high = a.length - 1;
		int tmp, j;
		while (low < high) {
			// ����ð�ݣ������
			for (j = low; j < high; ++j) {
				if (a[j] > a[j + 1]) {
					tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tmp;
				}
			}
			--high;
			// ����ð�ݣ�����С
			for (j = high; j > low; --j) {
				if (a[j] < a[j - 1]) {
					tmp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = tmp;
				}
			}
			++low;
		}
	}

	/*
	 * �������� ʱ�临�Ӷ�O(nlogn) ��n�ϴ�ʱ���ÿ��źã������л�������ʱ���ÿ��ŷ������ã����˻���Ϊð�ݣ�
	 **/
	// ��һ�֣��ݹ�ķ���
	public static void quickSort(int[] a) {
		if (a.length > 0) {
			quickSortRecursion(a, 0, a.length - 1);
		}
	}

	public static void quickSortRecursion(int[] a, int low, int high) {

		if (low < high) {
			int pivotloc = partition(a, low, high);
			quickSortRecursion(a, low, pivotloc - 1);
			quickSortRecursion(a, pivotloc + 1, high);
		}
	}

	public static int partition(int[] a, int low, int high) {
		int pivot = a[low];
		while (low < high) {
			while (low < high && a[high] >= pivot)
				--high;
			a[low] = a[high];
			while (low < high && a[low] <= pivot)
				++low;
			a[high] = a[low];
		}
		a[low] = pivot;
		return low;
	}
	/*
	 * ���ŸĽ��� ���ű���Ϊ��ͬ������O(nlogn)��ƽ��������õģ����������ʼ���а��ؼ���������߻��������ʱ��
	 * ���ŷ����˻���Ϊð������Ϊ�Ľ���ͨ��������ȡ�С���ѡȡ��׼��¼�� �����������������˵����м�������¼�ľ��еĵ���Ϊ֧���¼��
	 * 
	 * ���Ľ��㷨��ֻ�Գ��ȴ���k�������е��ÿ��ţ������������ Ȼ���ٶ���������������ò�������
	 **/
	/*
	 * �鲢�㷨(�ȶ�) ʱ�䣺O(nlogn) һ���������������Ǹ��������������
	 **/

	public static void mergeSort(int[] a, int left, int right) {
		if (left < right) {
			int middle = (left + right) / 2;
			mergeSort(a, left, middle);
			mergeSort(a, middle + 1, right);
			merge(a, left, middle, right);
		}
	}

	// �������i~middle middle+1~right�ϲ���һ��
	public static void merge(int[] a, int left, int middle, int right) {
		int[] tmpa = new int[a.length];
		int k = left;
		int i = left;
		int j = middle + 1;
		while (i <= middle && j <= right && k <= right) {
			if (a[i] <= a[j])
				tmpa[k++] = a[i++];
			else
				tmpa[k++] = a[j++];
		}
		// ��ʣ�µķŵ���ʱ����
		while (i <= middle && k <= right)
			tmpa[k++] = a[i++];
		while (j <= right && k <= right)
			tmpa[k++] = a[j++];
		// ����ʱ���鸴�ƻ�ԭ������
		int t = left;
		while (t <= right) {
			a[t] = tmpa[t];
			t++;
		}
	}

	// дһ���ǵݹ�Ĺ鲢�����㷨
	// ˼·:�鲢���ȴ�1��ʼ��ÿ�ι鲢���ȱ�Ϊԭ����2��
	// ��Ҫע�⴦��鲢�γ���Ϊ���� �Լ� ���һ���鲢�γ��Ⱥ�ǰ�治��ȵ����
	public static void mergeSortNonRer(int[] a, int left, int right) {
		int len = 1;// ÿ�εĹ鲢����
		while (len < a.length) {
			// ����for��һ�˹鲢
			for (int i = 0; i + len < a.length; i = i + len * 2) {
				int low = i;
				int mid = i + len - 1;
				int high = i + 2 * len - 1;
				if (high > a.length - 1)
					high = a.length - 1;// ����һ�±߽����
				merge(a, low, mid, high);
			}
			len = len * 2;
		}
	}

	/*
	 * ��������
	 **/
	public static void radixSort(int[] nums) {
		// �ҵ��������ȷ�������ż���
		int max = 0;
		for (int n : nums) {
			if (max < n)
				max = n;
		}
		// �����������λ��
		int times = 0;
		while (max > 0) {
			max = max / 10;
			times++;
		}
		// ����10�����У���0~9
		List<List<Integer>> listset = new ArrayList<List<Integer>>();
		for (int j = 0; j < 10; j++) {
			ArrayList<Integer> l = new ArrayList<Integer>();
			listset.add(l);
		}
		// ����times�η�����ռ�
		for (int i = 0; i < times; i++) {
			// ��������Ԫ��
			for (int j = 0; j < nums.length; j++) {
				// �õ����ӵ�time+1λ��
				int x = (nums[j] % ((int) Math.pow(10, i + 1)));
				x = x / ((int) Math.pow(10, i));
				List<Integer> list = listset.get(x);
				list.add(nums[j]);
				listset.set(x, list);
			}

			int count = 0;// Ԫ�ؼ�����
			// �ռ�����Ԫ��
			for (int k = 0; k < 10; k++) {
				while (listset.get(k).size() > 0) {
					List<Integer> list2 = listset.get(k);
					nums[count] = list2.get(0);
					list2.remove(0);
					count++;
				}
			}

		}

	}

}
