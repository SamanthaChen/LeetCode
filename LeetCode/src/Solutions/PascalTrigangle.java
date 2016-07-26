package Solutions;

import java.util.ArrayList;
import java.util.List;
public class PascalTrigangle {
    public List<Integer> getRow(int rowIndex) {
        //只用一个ArrayList （3ms，21%）
        List<Integer> row = new ArrayList<Integer>();
        if(rowIndex <0) return row;
        for(int i=0;i<=rowIndex;i++){
            row.add(0,1);
            for(int j=1;j<row.size()-1;j++){
                row.set(j,row.get(j)+row.get(j+1));
            }
        }
        return row;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
