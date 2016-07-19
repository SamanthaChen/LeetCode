package Test;

import java.util.Scanner;

public class test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		 String input = "1 fish 2 fish red fish blue fish";
	     @SuppressWarnings("resource")
		Scanner s = new Scanner(System.in).useDelimiter("\\s*fish\\s*");
	     System.out.println(s.nextInt());
	     System.out.println(s.nextInt());
	     System.out.println(s.next());
	     System.out.println(s.next());
	     s.close();

	}

}
