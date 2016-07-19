package Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S153Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] S = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
		List<List<Integer>>  res = threeSum(S);
		for(List<Integer> ll : res){
			String s = "";
			for(Integer l : ll){
				s += l+"\t";
			}
			System.out.println(s);
				
		}
		
		
	}
    //��������ָ�룬��O(n^2)ʱ�临�Ӷ�
    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>>  res = new ArrayList<List<Integer>>();
        //�߽����
        int n = nums.length;
        if(n<3 || nums==null) return res;
        //Ϊ�˷�ֹ�ظ������Ÿ���
        Arrays.sort(nums);
        for(int i=0; i<n-1 ;i++){
            //����i���ܳ��ֵ��ظ�
            if(i==0 || nums[i]>nums[i-1]){
                int j=i+1;
                int k=n-1;
                
                while(j<k){
                    if(nums[i]+nums[j]+nums[k]==0 && j<k){
                        List<Integer> l = new ArrayList<Integer>(); 
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[k]);
                        res.add(l);
                        //������������ָ��
                        j++;
                        k--; 
                        //����һ��j k���ظ�����
                        while(j<k && nums[j]==nums[j-1]) j++;
                        while(j<k && nums[k]==nums[k+1]) k--;
                    }else if(nums[i]+nums[j]+nums[k]<0){
                        j++;
                    }else{
                        k--;
                    }
                }
            }
            
        }
        return res;
    }

}
