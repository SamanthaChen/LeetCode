package Solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,1,2,2,3};
		System.out.println(topKFrequent(nums,2));

	}
    public static List<Integer> topKFrequent(int[] nums, int k) {
        //naive的思路：用map存,但是还需要给map排序？
        //排序就利用桶排序
        int  n  = nums.length;
        List<Integer> res = new ArrayList<Integer>();
        List<Integer>[] bucket  = new List[n+1];//下标是频率，内容是该频率的数字
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer> ();
        //统计出现次数
        for(int i = 0; i<n; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        //桶排序
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(bucket[entry.getValue()]==null) bucket[entry.getValue()] = new ArrayList<Integer>();
            bucket[entry.getValue()].add(entry.getKey());
        }
        //储存结果：
        for(int i = n, j = 0; i >=0  && j < k; i--){
            if(bucket[i]!=null){
                for(int key : bucket[i]){
                    if(j<k){
                        res.add(key);
                        j++;
                    }else return res;
                }
            }
        }
        return res;
        
    }

}
