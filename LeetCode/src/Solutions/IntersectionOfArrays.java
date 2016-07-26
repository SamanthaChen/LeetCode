package Solutions;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	

	}
	
    public int[] intersection(int[] nums1, int[] nums2) {
//        HashSet<Integer> res = new HashSet<Integer>();
//        for(int i = 0; i< nums1.length;i++){
//            for(int j = 0; j < nums2.length; j++){
//                if(nums1[i] == nums2[j]) res.add(nums2[j]);
//            }
//        }
//        int[] r = new int[res.size()];
//        int k = 0;
//        for(int e : res){
//            r[k++] = e;
//        }
//        return r;
        //Á½¸öset 
        Set<Integer> set =  new HashSet<Integer>();
        Set<Integer> res = new HashSet<Integer>();
        for(int i = 0; i < nums1.length; i++){
            set.add(nums1[i]);
        }
        for(int j = 0; j < nums2.length; j++){
            if(set.contains(nums2[j])){
                res.add(nums2[j]);
            }
        }
        int[] intersection = new int[res.size()];
        int k = 0;
        for(int e : res ){
            intersection[k++] = e;
        }
        return intersection;
    }
}
