package Solutions;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        //������ArraList��(1ms,35%)
        // List<List<Integer>> res = new ArrayList<List<Integer>>();
        // if(numRows == 0) return res;//0��
        // List<Integer> l = new ArrayList<Integer>();
        // l.add(1);
        // res.add(l);
        // if(numRows == 1) return res;
        // //����>=1
        // for(int i=1;i<numRows;i++){
        //   List<Integer> list = new ArrayList<Integer>(); //ÿһ�㶼��newһ��һάlist,ÿһ����i+1����
        //   list.add(1);//ÿһ���һ����=1
        //   if(i>1){
        //         //�м����������һ��Ľ��
        //         for(int j=1;j<i;j++){
        //             list.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));//l[j]=res[i-1][j-1]+res[i-1][j-1]
        //         }
        //   }
        //     list.add(1);//ÿһ�����һ����=1
        //     res.add(list); 
        // }
        // return res;
        
        //�����һЩ���������Ҷ��붼��һ����(2ms 2.46%)
        List<List<Integer>> allrows = new ArrayList<List<Integer>>();
        List<Integer> row =  new ArrayList<Integer>();
        for(int i=0;i<numRows;i++){
            row.add(0,1);//��������ͷ��1
            for(int j=1;j<row.size()-1;j++){
                row.set(j,row.get(j)+row.get(j+1));
            }
            allrows.add(new ArrayList<Integer>(row));//��row����һ�ݣ�����������
            
        }
        return allrows;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generate(5);
	}

}
