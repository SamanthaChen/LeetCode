package Solutions;

public class RemoveDuplicatesFromArrayII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,1,2,3,3,3,4,4,5};
		System.out.println("ɾ��ǰ��" );
		String s = "";
		for(int n : nums) s+=n+" ";
		System.out.println(s);
		int i = removeDuplicates(nums);
		System.out.println("length:"+i);
		System.out.println("ɾ����" );
		String ss = "";
		for(int n : nums) ss+=n+" ";
		System.out.println(ss);
	}
    public static int removeDuplicates(int[] nums) {
        //������һ���˼·
        int id = 0;
        for(int i = 0; i < nums.length; i++){
            if( i<2 || nums[i]>nums[id-2]) nums[id++]=nums[i];
        }
        return id;
    }

}
