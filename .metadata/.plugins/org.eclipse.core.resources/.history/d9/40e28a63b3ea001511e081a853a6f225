package Solutions;

public class S12IntToRoman {

    public String intToRoman(int num) {
        //因为只用显示0—~3999 存30个数组还是可以的？
        String[] thousand = {"","M","MM","MMM"};//表示0,1000,2000,3000
        String[] hundred = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};//0，100，200...900
        String[] decade = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};//0，10，20...90
        String[] digit = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
         
        return thousand[num/1000]+hundred[(num%1000)/100]+decade[(num%1000%100)/10]+digit[num%1000%100%10];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
