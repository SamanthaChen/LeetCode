package JulyAlgotithm;

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
	 
	public static void helper(int n, int m, List<List<Integer>> res, List<Integer> list){
		
		//�ݹ���ֹ����
		
		if(n<=0 || m<=0)
			return;
		
		
		if(m==n){
			print(list);
			System.out.print(n);
			System.out.println("");
//			res.add(new ArrayList<Integer>(list));
		}

		//����n��
		list.add(n);
		helper(n-1,m-n,res,list);
		//����n
		list.remove(list.size()-1);	
		helper(n-1,m,res,list);
	}
	
	public static void print(List<Integer> list){
		for(int l: list)
			System.out.print(l+" ");
	}


}