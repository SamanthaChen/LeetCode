package Solutions;

public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int m=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
               nums[m++]=nums[i];
            }
        }
        while(m<nums.length) nums[m++]=0;
    }
}
