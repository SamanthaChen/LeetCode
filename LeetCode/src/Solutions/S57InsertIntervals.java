package Solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import DataStructual.Interval;;

public class S57InsertIntervals {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		S26MergeIntervals solution = new S26MergeIntervals();
		Interval i1 = new Interval(1,2);
		Interval i2 = new Interval(3,5);
		Interval i3 = new Interval(6,7);
		Interval i4 = new Interval(8,10);
		Interval i5 = new Interval(12,16);
		
		Interval i6 = new Interval(4,9);
		List<Interval> list = new ArrayList<Interval>();
		list.add(i1);list.add(i2);list.add(i3);list.add(i4);list.add(i5);
		List<Interval> res = insert(list,i6);
		for(Interval i :res){
			System.out.println(i);
		}
	}
 
//	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
//	       List<Interval> res = new LinkedList<Interval>();
//	        
//	        if(intervals.isEmpty()) {
//	            res.add(newInterval);
//	            return res;
//	        }
//	        if(newInterval==null) {
//	            return intervals;
//	        }
//	        //������
//	        Collections.sort(intervals,new Comparator<Interval>(){
//	            public int compare(Interval a,Interval b){
//	                return Integer.compare(a.start,b.start);
//	            }
//	        });
//	        //�ٲ���
//	        
//	        int start = newInterval.start;
//	        int end  = newInterval.end;
//	        for(Interval i: intervals){
//	            //���ص� ��i���²����ǰ��
//	            if(i.end < start || i.start>end){
//	                res.add(i);
//	            }else{//�ص�
//	                start = Math.min(start,i.start);
//	                end = Math.max(end,i.end);
//	            }
//	        }
//	        res.add(new Interval(start,end));
//	        //������
//	        //������
//	        Collections.sort(res,new Comparator<Interval>(){
//	            public int compare(Interval a,Interval b){
//	                return Integer.compare(a.start,b.start);
//	            }
//	        });
//	        return res;
//    }
    //������ð���˳�����������ԭ�����Ѿ��Ź�˳���ˡ���
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new LinkedList<Interval>();
        
        if(intervals.isEmpty()) {
            res.add(newInterval);
            return res;
        }
        if(newInterval==null) {
            return intervals;
        }
        //���������
        for(Interval i : intervals ){
            if(i.end<newInterval.start){
                res.add(i);
            }else if(i.start>newInterval.end){
                res.add(newInterval);
                newInterval = i;
            }else{//�ص�
                //��Ҫ�½�һ�����󣬷�����ӽ�list����Ҳ���޸ĵ�
                newInterval = new Interval(Math.min(newInterval.start,i.start), Math.max(newInterval.end, i.end));
            }
        }
        res.add(newInterval);
        return res;
        
    }
}
