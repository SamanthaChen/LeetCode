package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CombinationToSum {

	/*
第21 题
2010 年中兴面试题
编程求解：
输入两个整数 n 和 m ，从数列 1 ， 2 ， 3.......n 中随意取几个数 ,
使其和等于 m , 要求将其中所有的可能组合列出来 .
	 * two solutions
	 * permutation01:Recursion.easy to write and read-->pick n or not,haha
	 * permutation02:put n,then put n-1...if bigger,remove;if smaller,keep putting;if ok,output.
	 */
	public static void main(String[] args) {
		CombinationToSum cts=new CombinationToSum();
		//permutation01(int sum,int n)
		cts.permutation01(10,10);
		System.out.println("===========");
		cts.permutation02(10,6);
	}

	/*Recursion.use Stack<Integer>
	we can use ArrayList,too.
	private List<Integer> list=new ArrayList<Integer>();
	list.add(n);
	list.remove(list.indexOf(n));
	*/
	private Stack<Integer> stack=new Stack<Integer>();
	public  void permutation01(int sum,int n){
		if(n<=0||sum<=0)return;
		if(sum==n){
			printStack(stack);
			System.out.print(n);
			System.out.println();
		}
		stack.add(n);
		permutation01(sum-n,n-1);
		stack.pop();
		permutation01(sum,n-1);
	}
	
	public  void permutation02(int sum, int n) {
		if(n<=0||sum<=0)return;
		for (int i = n; i > 0; i--) {
			if (i == sum) {
				System.out.println(i);
				continue;
			}
			List<Integer> list = new ArrayList<Integer>();
			list.add(i);
			for (int j = i - 1; j > 0;) {
				list.add(j);
				int ret = isOK(list, sum);
				if (ret < 0) {
					j--;
				}
				if (ret == 0) {
					printList(list);
					System.out.println();
					j = list.get(1) - 1;//now we go back and make the second element smaller
					list.clear();
					list.add(i);
				}
				if (ret > 0) {
					list.remove(list.size()-1);//too large,remove the last element
					j--;
				}
			}
		}
	}

	// whether the sum of list element equals to sum or not
	public static int isOK(List<Integer> list, int sum) {
		int re = 0;
		int total = 0;
		for (int each : list) {
			total += each;
		}
		if (total > sum)
			re = 1;
		if (total < sum)
			re = -1;
		return re;

	}

	public void printStack(Stack<Integer> stack){
		/*
		while(!stack.isEmpty()){
			int temp=stack.pop();
			System.out.print(temp+" ");
		}
		*/
		//don't remove the elements in stack
		for(Integer each:stack){
			System.out.print(each+" ");
		}
	}


	public  void printList(List<Integer> list) {
		for (int each : list) {
			System.out.print(each + " ");
		}
	}
	
}

