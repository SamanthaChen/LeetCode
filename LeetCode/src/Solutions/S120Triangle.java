package Solutions;

import java.util.ArrayList;
import java.util.List;

public class S120Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> inner1 = new ArrayList<Integer>();
		inner1.add(1);
		List<List<Integer>> outer = new  ArrayList<List<Integer>>();
		outer.add(inner1);
		List<Integer> inner2 = new ArrayList<Integer>();
		inner2.add(2);
		inner2.add(3);
		outer.add(inner2);
		
		System.out.println(minimumTotal(outer));
	}
    //思路：自底向上，改变三角形的值，最终顶点输出最小值
    //
	public static int minimumTotal(List<List<Integer>> triangle) {
	  
	    
	    int n = triangle.size();//行数
	    if(n == 0) return  0;
	    if(n == 1) return triangle.get(0).get(0);
	    
	    for( int i = n-2; i >= 0 ; i--){
	        for(int j = 0 ; j < i+1 ; j++){
	            int temp = Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1));
	            int num =  triangle.get(i).get(j);
	            triangle.get(i).set(j, num + temp);
	        }
	    }
	    return triangle.get(0).get(0);
	}
}
