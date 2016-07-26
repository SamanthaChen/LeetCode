package Solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class S350 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1,2};
		int[] nums2 = {1,1,2,2,2};
		int[] res = intersect(nums1,nums2);
		for(int r : res){
			System.out.print(r+"\t");
		}
	}
    public static int[] intersect(int[] nums1, int[] nums2) {
        //采用一个map 一个list
        HashMap<Integer,Integer> map =  new HashMap<Integer,Integer>();
        List<Integer> list = new ArrayList<Integer>();
        
        for(int  i = 0; i < nums1.length; i++){
            if(!map.containsKey(nums1[i])){
                map.put(nums1[i],1);
            }
            else{
                map.put(nums1[i], map.get(nums1[i])+1);
            }
        }
        
        for(int j = 0; j <nums2.length; j++){
            if(map.containsKey(nums2[j]) ){
                list.add(nums2[j]);
                int value = map.get(nums2[j])-1;
                if(value == 0) 
                    map.remove(nums2[j]);
                else 
                    map.put(nums2[j], value);
            }
            
        }
        int[] res = new int[list.size()];
        for(int k = 0 ; k < list.size(); k++){
            res[k] = list.get(k);
        }
        return res;
        
    }
}
