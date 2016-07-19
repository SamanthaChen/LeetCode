package Solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class S26MergeIntervals {
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		S26MergeIntervals solution = new S26MergeIntervals();
		S26MergeIntervals.Interval i1 = solution.new Interval(1,3);
		S26MergeIntervals.Interval i2 = solution.new Interval(2,6);
		S26MergeIntervals.Interval i3 = solution.new Interval(8,10);
		S26MergeIntervals.Interval i4 = solution.new Interval(15,18);
//		S26MergeIntervals.Interval i5 = solution.new Interval(1,3);
		List<Interval> list = new ArrayList<Interval>();
		list.add(i1);list.add(i2);list.add(i3);list.add(i4);
		List<Interval> res = merge(list);
		for(Interval i :res){
			System.out.println(("["+i.start+","+i.end+"]"));
		}

	}
    //思路，得拷贝一个总的list出来，一直跟原来的总的融合
    //思路:先按照start排序，再合并
    public static List<Interval> merge(List<Interval> intervals) {
        
         if ( intervals.size()<=1 ) return intervals;
         //排序，用一个匿名比较器
         Collections.sort(intervals, new Comparator<Interval>(){
             public int compare(Interval a, Interval b){
                 return Integer.compare(a.start,b.start);
             }
             
         });
         //合并阶段
         List<Interval> res = new LinkedList<Interval>();
         int start = intervals.get(0).start;
         int end = intervals.get(0).end;
         for(Interval i : intervals){
             if(i.start<=end){//重叠
                 end = Math.max(i.end,end);//移动end坐标
             }else{//不重叠
                 res.add(new Interval(start,end));//添加前一个，并重置新的开始
                 start = i.start;
                 end = i.end;
             }
         }
         //添加最后一个
         res.add(new Interval(start,end));
         return res;
        
 
    }
}
