package Solutions;

public class SingleNUmberIII {

	public static void main(String[] args) {
		int[] nums = {-1,0};
		
		int[] res=singleNumber(nums);
		for(int i:res) System.out.println(i+" ");

	}
	   public static int[] singleNumber(int[] nums) {
	        int[] ans = new int[2]; 
	        int res = 0;
	        for(int i:nums) res ^= i;//ȫ�����õ��������ַ����Ľ��
	        //������λΪ1��λ��
	        res = res & (-res);
	        //����res�Ľ�����ַ�����Ϊ���� 
	       
	                //������Ǹ�λ����1����λ�ò�������

	                for(int n:nums){
	                    
	                    if((n & res ) == 1){
	                        ans[0] ^= n;
	                    }else{
	                        ans[1] ^= n;
	                    }
	                }
	                
	           
	        return ans;
	    } 

}
