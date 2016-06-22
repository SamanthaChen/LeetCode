package Solutions;

public class S58LengthofLastWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(lengthOfLastWord(" "));
	}
    public static int lengthOfLastWord(String s) {
        String[] ss = s.split(" ");
        return ss.length < 1 ? 0 : ss[ss.length-1].length();
    }

}
