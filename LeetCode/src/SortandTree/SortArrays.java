package SortandTree;

import java.util.ArrayList;
import java.util.List;

/*
 * 用来解决数组的排序问题
 * 
 * **/
public class SortArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 49, 38, 65, 97, 76, 13, 27, 49 };
		// int[] nums = {9,8,7,6,5,4,3,2,1};

		System.out.println("排序之前：");
		for (int i : nums)
			System.out.print(i + " ");
		System.out.print("\n");

		long starTime = System.currentTimeMillis();// 开始时间

		// 排序算法
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
		System.out.println("运行时间：" + Time);

		System.out.println("排序之后：");
		for (int i : nums)
			System.out.print(i + " ");

	}

	/*
	 * 直接插入排序（稳定） 时间复杂度：O(n^2) 正序时候最好：O(n) 逆序时候最差：O(n^2)
	 **/
	public static void straightInsertion(int[] a) {
		int temp = 0;
		for (int i = 1; i < a.length; i++) {
			temp = a[i];// 待比较元素
			int j = i - 1;
			for (; j >= 0 && a[j] > temp; j--)
				a[j + 1] = a[j]; // 大于监视哨的元素后移
			a[j + 1] = temp;
		}
	}

	/*
	 * 二分插入(稳定) 时间复杂度： 思路：基本和直接插入一致，只是采用二分法在前面有序的序列中进行插入。 可以减少比较次数，但是移动次数和直接插入相同
	 **/
	public static void binaryInsertion(int[] a) {
		int temp = 0;
		for (int i = 1; i < a.length; i++) {
			temp = a[i];// 待比较的数字
			int low = 0;
			int high = i - 1;
			int mid = 0;
			// 下面用二分查找在0~i-1的有序序列中，寻找一下插入位置
			while (low <= high) {
				mid = (low + high) / 2;
				if (temp > a[mid])
					low = mid + 1;
				else
					high = mid - 1;
			}
			// 插入位置为low或者high+1，把后面的数往后移
			int j = i - 1;
			for (; j >= low; j--)
				a[j + 1] = a[j];
			a[j + 1] = temp;
		}
	}

	/*
	 * 希尔排序(不稳定) 时间复杂度：O(nlogn)
	 * 
	 * 我的理解是：按照不同的增量进行分组，然后对每个组用直接插入排序 这里用的简单的增量序列d = {n/2 ,n/4, n/8 …..1}
	 * 希尔排序时效分析很难，关键码的比较次数与记录移动次数依赖于增量因子序列d的选取。 特定情况下可以准确估算出关键码的比较次数和记录的移动次数。
	 * 目前还没有人给出选取最好的增量因子序列的方法。增量因子序列可以有各种取法，有取奇数的，也有取质数的。 但需要注意：增量因子中除1
	 * 外没有公因子，且最后一个增量因子必须为1。希尔排序方法是一个不稳定的排序方法。
	 **/
	public static void shellSort(int a[]) {
		int dk = a.length;
		while (true) {
			dk = dk / 2;
			for (int x = 0; x < dk; x++) {// 这里x是分组数
				// 里面对不同的小组进行直接插入
				for (int i = x + dk; i < a.length; i = i + dk) {
					int temp = a[i];
					int j = i - dk;
					for (; j >= 0 && a[j] > temp; j = j - dk)
						a[j + dk] = a[j];// 大于temp元素后移
					a[j + dk] = temp;// 待比较元素插入的位置
				}
			}
			if (dk == 1)
				break;// 停止条件
		}

	}

	/*
	 * 简单选择排序(不稳定) 时间复杂度： O(n^2) 思想：每次从待排序的序列中选择最小的数字放到已经排序的表后面
	 **/
	public static void simpleSelect(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int temp = a[i];
			int position = i;
			// 从未排序的数字中选择最小值
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < temp) {
					temp = a[j];
					position = j;
				}
			}
			// 把当前第i个位置的数和找到的第i小的数字进行交换
			a[position] = a[i];
			a[i] = temp;
		}

	}

	/*
	 * 堆排序(不稳定) 时间复杂度O(nlogn) 性质：假设i节点是一个非端点节点，则parent(i)=1/2,
	 * leftChild(i)=2i,rightChild(i)=2*i+1 把初始的一位数组看做一个完全二叉树的一位存储方式
	 * 1、先把初始数组调整成最小堆，从n/2(取下界)的根节点开始调整最大堆 2、每次取H[0]和最后一个元素进行交换，即每次取当前堆顶放到后面
	 * 3、继续对0~i个元素进行调整
	 * 
	 * 树的深度是logn+1
	 **/
	public static void heapSort(int[] h) {
		// 先建立一下初始堆
		for (int i = (h.length - 1) / 2; i >= 0; i--)// 根只在前半部分
			heapAdjust(h, i, h.length - 1);
		// 依次将当前堆顶输出到后面，然后调整堆
		for (int i = h.length - 1; i > 0; i--) {
			int tmp = h[i];
			h[i] = h[0];
			h[0] = tmp;
			heapAdjust(h, 0, i - 1);
		}

	}

	public static void heapAdjust(int[] h, int s, int m) {
		int child = 2 * s + 1;
		while (child <= m) {// 从s往后调整
			// 左右孩子都存在的话，选择一个较大的孩子
			if (child + 1 <= m)
				child = h[child] > h[child + 1] ? child : child + 1;
			if (h[s] < h[child]) {
				// 根节点和较大孩子互相交换
				int tmp = h[s];
				h[s] = h[child];
				h[child] = tmp;
				s = child;// 需要调整的指针后移
				child = 2 * s + 1;// 孩子节点后移
			} else
				break;// 不需要进行调整
		}
	}

	/*
	 * 冒泡排序 时间复杂度：平均O(n^2)最好O(n) 改进：1、加入一个标志变量，某一次不发生交换时候就可以停止了。
	 * 2、设置一标志性变量pos,用于记录每趟排序中最后一次进行交换的位置。由于pos位置之后的记录均已交换到位,
	 * 故在进行下一趟排序时只要扫描到pos位置即可。
	 * 
	 **/
	public static void bubbleSort(int[] a) {
		// 从后面开始吧，小的冒泡排到前面去
		// for(int i=a.length-1; i>0; i--){
		// for(int j=a.length-1;j>a.length-1-i;j--){
		// if(a[j]<a[j-1]){//后面的数比前面小，交换
		// int tmp = a[j];
		// a[j]=a[j-1];
		// a[j-1]=tmp;
		// }
		// }
		// }

		// 从前面开始，大的泡泡到后面去
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - 1 - i; j++) {// 减去i是因为后面i个已经排好了
				if (a[j] > a[j + 1]) {
					int tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tmp;
				}
			}
		}
	}

	/*
	 * 双向的冒泡排序
	 **/
	public static void bubbleSort2(int[] a) {
		int low = 0;
		int high = a.length - 1;
		int tmp, j;
		while (low < high) {
			// 正向冒泡，找最大
			for (j = low; j < high; ++j) {
				if (a[j] > a[j + 1]) {
					tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tmp;
				}
			}
			--high;
			// 反向冒泡，找最小
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
	 * 快速排序 时间复杂度O(nlogn) 当n较大时候用快排好，当序列基本有序时候用快排反而不好（会退化成为冒泡）
	 **/
	// 第一种，递归的方法
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
	 * 快排改进： 快排被认为是同数量级O(nlogn)中平均性能最好的，但是如果初始序列按关键码有序或者基本有序的时候
	 * 快排反而退化成为冒泡排序。为改进，通常“三者取中”来选取基准记录。 即将排序区的两个端点与中间三个记录的居中的调整为支点记录。
	 * 
	 * 本改进算法是只对长度大于k的子序列调用快排，让其基本有序。 然后再对整个基本有序采用插入排序
	 **/
	/*
	 * 归并算法(稳定) 时间：O(nlogn) 一般用于总体无序但是各子项有序的数组
	 **/

	public static void mergeSort(int[] a, int left, int right) {
		if (left < right) {
			int middle = (left + right) / 2;
			mergeSort(a, left, middle);
			mergeSort(a, middle + 1, right);
			merge(a, left, middle, right);
		}
	}

	// 将有序的i~middle middle+1~right合并成一个
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
		// 将剩下的放到临时数组
		while (i <= middle && k <= right)
			tmpa[k++] = a[i++];
		while (j <= right && k <= right)
			tmpa[k++] = a[j++];
		// 将临时数组复制回原来数组
		int t = left;
		while (t <= right) {
			a[t] = tmpa[t];
			t++;
		}
	}

	// 写一个非递归的归并排序算法
	// 思路:归并长度从1开始，每次归并长度变为原来的2倍
	// 需要注意处理归并段长度为奇数 以及 最后一个归并段长度和前面不相等的情况
	public static void mergeSortNonRer(int[] a, int left, int right) {
		int len = 1;// 每次的归并长度
		while (len < a.length) {
			// 里面for是一趟归并
			for (int i = 0; i + len < a.length; i = i + len * 2) {
				int low = i;
				int mid = i + len - 1;
				int high = i + 2 * len - 1;
				if (high > a.length - 1)
					high = a.length - 1;// 处理一下边界情况
				merge(a, low, mid, high);
			}
			len = len * 2;
		}
	}

	/*
	 * 基数排序
	 **/
	public static void radixSort(int[] nums) {
		// 找到最大数，确定排序排几趟
		int max = 0;
		for (int n : nums) {
			if (max < n)
				max = n;
		}
		// 计算最大数的位数
		int times = 0;
		while (max > 0) {
			max = max / 10;
			times++;
		}
		// 建立10个队列，存0~9
		List<List<Integer>> listset = new ArrayList<List<Integer>>();
		for (int j = 0; j < 10; j++) {
			ArrayList<Integer> l = new ArrayList<Integer>();
			listset.add(l);
		}
		// 进行times次分配和收集
		for (int i = 0; i < times; i++) {
			// 分配数组元素
			for (int j = 0; j < nums.length; j++) {
				// 得到数子的time+1位数
				int x = (nums[j] % ((int) Math.pow(10, i + 1)));
				x = x / ((int) Math.pow(10, i));
				List<Integer> list = listset.get(x);
				list.add(nums[j]);
				listset.set(x, list);
			}

			int count = 0;// 元素计数器
			// 收集队列元素
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
