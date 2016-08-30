package Test;

import java.util.ArrayList;
import java.util.List;

/*
 * 2010������������
	�����⣺
	������������ n �� m��������1��2��3.......n �� ����ȡ������,
	ʹ��͵��� m ,Ҫ���������еĿ�������г�����
 * */
public class SumofNumbers {

	public static void main(String[] args) {
		List<List<Integer>> res = sumofNumbers(10,10);
	
		for(List<Integer> l : res){
			for(int e : l){
				System.out.print(e+" ");
			}
			System.out.println("");
		}

	}
	//˼·1��������0-1��������
	//�ݹ�= f(n,m) =  f(n-1,m-n) ��n
	//		����f(n-1,m) ����n
	public static List<List<Integer>> sumofNumbers(int n, int m){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		helper(n,m,res,new ArrayList<Integer>());
		return res;
	}
	private static void helper(int n, int m, List<List<Integer>> res, List<Integer> list) {
		if(n<0 || m<0) return;
		if(m==0){
			res.add(new ArrayList<Integer>(list));
		}else{
			for(int i=n;i>=0;i--){
				list.add(i);
				helper(i,m-i,res,list);
				list.remove(list.size()-1);
			}

		}
	}
}
