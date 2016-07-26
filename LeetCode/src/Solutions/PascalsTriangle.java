package Solutions;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        //单纯用ArraList做(1ms,35%)
        // List<List<Integer>> res = new ArrayList<List<Integer>>();
        // if(numRows == 0) return res;//0层
        // List<Integer> l = new ArrayList<Integer>();
        // l.add(1);
        // res.add(l);
        // if(numRows == 1) return res;
        // //层数>=1
        // for(int i=1;i<numRows;i++){
        //   List<Integer> list = new ArrayList<Integer>(); //每一层都新new一个一维list,每一层有i+1个数
        //   list.add(1);//每一层第一个数=1
        //   if(i>1){
        //         //中间的数按照上一层的结果
        //         for(int j=1;j<i;j++){
        //             list.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));//l[j]=res[i-1][j-1]+res[i-1][j-1]
        //         }
        //   }
        //     list.add(1);//每一层最后一个数=1
        //     res.add(list); 
        // }
        // return res;
        
        //更简洁一些，左对齐和右对齐都是一样的(2ms 2.46%)
        List<List<Integer>> allrows = new ArrayList<List<Integer>>();
        List<Integer> row =  new ArrayList<Integer>();
        for(int i=0;i<numRows;i++){
            row.add(0,1);//不断往队头加1
            for(int j=1;j<row.size()-1;j++){
                row.set(j,row.get(j)+row.get(j+1));
            }
            allrows.add(new ArrayList<Integer>(row));//将row复制一份，并加入结果中
            
        }
        return allrows;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generate(5);
	}

}
