package Solutions;

public class S12IntToRoman {

    public String intToRoman(int num) {
        //因为只用显示0—~3999 存30个数组还是可以的？
        // String[] thousand = {"","M","MM","MMM"};//表示0,1000,2000,3000
        // String[] hundred = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};//0，100，200...900
        // String[] decade = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};//0，10，20...90
        // String[] digit = {"","I","II","III","IV","V","VI","VII","VIII","IX"};//0,1,2...9
         
        // // return thousand[num/1000]+hundred[(num%1000)/100]+decade[(num%1000%100)/10]+digit[num%1000%100%10];
        // return thousand[num/1000]+hundred[num%1000/100]+decade[num%100/10]+digit[num%10];
        
        //写一个别人的，更节省空间时间的
        int[] digit = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] str ={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        String res = "";
        for(int i = 0; i < digit.length; i++ ){
            while(num >= digit[i]){
                num -= digit[i];
                res += str[i];
            }
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
