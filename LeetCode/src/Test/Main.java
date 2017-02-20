package Test;

import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int a = in.nextInt();
            solution(a);
            
        }
    }
    public static void solution(int a){
        int[] nums = new int[4];
        
        do{
        	nums[0]=a%10;
        	nums[1]=(a/10)%10;
        	nums[2]=(a/100)%10;
        	nums[3]=a/1000;
        	Arrays.sort(nums);
        	int n1 = nums[0]*1+nums[1]*10+nums[2]*100+nums[3]*1000;
        	int n2 = nums[3]*1+nums[2]*10+nums[1]*100+nums[0]*1000;
            int n = n1-n2;
            if(n==0){
                System.out.println(n1+" - "+n2+" = 0000");
                break;
            }else{
                System.out.println(n1+" - "+n2+" = "+n);
            }
            a = n;
            
        }while(a!=6174);
        
        
    }

}