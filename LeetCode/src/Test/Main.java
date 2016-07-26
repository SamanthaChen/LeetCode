package Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in).useDelimiter(" ");
		ArrayList<Integer> list = new ArrayList<Integer>(); 
		while(cin.hasNext()){
			list.add(cin.nextInt());
		}
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		list.add(61);list.add(51);
//		list.add(49);list.add(30);
//		list.add(20);list.add(10);
//		list.add(70);list.add(80);
//
//		list.add(90);list.add(99);
		int ans = solution(list);
		System.out.println(ans);
		
	}
	public static int solution(ArrayList<Integer> list){
		Collections.sort(list);
		if(list.get(0)>=60) return 60;
		int ans = (int) (Math.floor(list.get(4)/10.0)*10);
		return ans;
	}

}
