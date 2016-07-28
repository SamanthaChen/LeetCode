package JulyAlgotithm;

public class StringContains {

	public static void main(String[] args) {
		String a = "ABCDEFGHIJKLMN";
		String b = "ABCDQ";
		System.out.println(contains(a,b));

	}
	public static boolean contains(String a, String b){
		int hash = 0;
		for(int i = 0;i < a.length(); i++){
			hash = hash |  1<<(a.charAt(i)-'A');
		}
		for(int j = 0;j < b.length(); j++){
			if((hash & 1 <<(b.charAt(j)-'A') )== 0){
				return false;
			}
		}
		return true;
	}

}
