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
    //˼·���ÿ���һ���ܵ�list������һֱ��ԭ�����ܵ��ں�
    //˼·:�Ȱ���start�����ٺϲ�
    public static List<Interval> merge(List<Interval> intervals) {
        
         if ( intervals.size()<=1 ) return intervals;
         //������һ�������Ƚ���
         Collections.sort(intervals, new Comparator<Interval>(){
             public int compare(Interval a, Interval b){
                 return Integer.compare(a.start,b.start);
             }
             
         });
         //�ϲ��׶�
         List<Interval> res = new LinkedList<Interval>();
         int start = intervals.get(0).start;
         int end = intervals.get(0).end;
         for(Interval i : intervals){
             if(i.start<=end){//�ص�
                 end = Math.max(i.end,end);//�ƶ�end����
             }else{//���ص�
                 res.add(new Interval(start,end));//���ǰһ�����������µĿ�ʼ
                 start = i.start;
                 end = i.end;
             }
         }
         //������һ��
         res.add(new Interval(start,end));
         return res;
        
 
    }
}
