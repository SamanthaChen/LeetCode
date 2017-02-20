package Solutions;

import java.util.HashMap;
import java.util.HashSet;

public class ContainsNearDuplicate {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        
        //���k*N�� ��ʱ
      
//        if(nums.length < k ||nums.length == 1) return false;
//        for(int i = 0; i < nums.length; i++ ){
//            for(int j = i+1; j < k; j++){
//                if(nums[i]==nums[j]) return true;
//            }
//        }
//        return false;
        
        //����setά��һ����СΪk+1�Ļ�������(10ms 80.81%)
      
//        HashSet<Integer> set = new HashSet<Integer>();
//        for(int i = 0 ; i < nums.length; i++){
//            if(i>k) set.remove(nums[i-k-1]) ;//Ϊ��ά�ֻ������ڣ�ÿ�ν���һ�����ӵ�ɾ��
//            if(!set.add(nums[i])) return true;
//        }
//        return false;
        
        //��һ��map ��ʱ
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0 ; i < nums.length; i++){
            if(map.containsKey(nums[i])) {
                if(i-map.get(nums[i]) <= k) return true;
            }
            map.put(nums[i],i);
            
        }
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,4,1,2,1,7,8,3};
		System.out.print(containsNearbyDuplicate(nums,6) ? "T" :"F");
	}
}