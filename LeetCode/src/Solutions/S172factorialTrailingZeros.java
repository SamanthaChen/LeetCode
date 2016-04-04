package Solutions;

public class S172factorialTrailingZeros {
	   public int trailingZeroes(int n) {
		    /**算法思路：http://www.cnblogs.com/heyonggang/p/3386289.html
		     * 分析：一般类似的题目都会蕴含某种规律或简便方法的,阶乘末尾一个零表示一个进位，则相当于乘以10而10 是由2*5所得，在1~100当中，可以产生10的有：0 2 4 5 6 8 结尾的数字，显然2是足够的，因为4、6、8当中都含有因子2，所以都可看当是2，那么关键在于5的数量了那么该问题的实质是要求出1~100含有多少个5由特殊推广到一般的论证过程可得：      
		        1、 每隔5个，会产生一个0，比如 5， 10 ，15，20.。。
		        2 、每隔 5×5 个会多产生出一个0，比如 25，50，75，100 
		        3 、每隔 5×5×5 会多出一个0，比如125.

		所以100！末尾有多少个零为：        100/5+100/25=20+4=24那么1000！末尾有多少个零呢？同理得：        1000/5+1000/25+1000/125=200+40+8+1=249
		到此，问题解决了，但我们在学习过程中应当学会发散思维、举一反三*/
		     int res = 0;
		     while(n>0){
		         res = res+n/5;
		         n = n/5;
		     }
		     return res;
		       
		    }
}
