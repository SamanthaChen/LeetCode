package Test;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	     @SuppressWarnings("resource")
		 Scanner s = new Scanner(System.in);
	     int m = s.nextInt();
	     int n = s.nextInt();
	     String[][] a = new String[m][n];
	     while(s.hasNext()){
	    	 for(int i = 0; i<m; i++){
	    		 for(int j = 0; j<n; j++){
	    			 a[i][j] = s.next();
	    			 System.out.print(a[i][j]+"\t");
	    		 }
	    	 }
	     }
	     s.close();
	 
	}

}
