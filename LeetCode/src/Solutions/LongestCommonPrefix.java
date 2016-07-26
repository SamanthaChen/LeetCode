package Solutions;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"apple", "apply","application","app"};
//		String[] strs = {""};
		System.out.println(longestCommonPrefix(strs));
	}
    public static String longestCommonPrefix(String[] strs) {
        //思路：一个个对比
//        if(strs == null ) return null;
//        
//        StringBuilder sb = new StringBuilder();
//        int minlen = Integer.MAX_VALUE;
//        for(int i = 0 ; i < strs.length; i++){
//            if( minlen > strs[i].length() ) minlen = strs[i].length();
//        }
//        if(minlen == 0) return null;
//        //直接拿第一个跟后面的进行比较
//        for( int i = 0; i < minlen ; i++){//这里比较的是单个字符
//            for( int j = 0 ; j < strs.length; j++){ //这里比较的字符串
//                if( strs[0].charAt(i) != strs[j].charAt(i) ) return sb.toString();
//            }
//            sb.append(strs[0].charAt(i));
//        }
//        return sb.toString();
    	
        //思路，从后面开始减
        if(strs == null || strs.length == 0) return "";
        String pre = strs[0];
        int prelen = strs[0].length();
        for(int i = 1; i < strs.length ; i++){
            while(strs[i].indexOf(pre)!=0) pre = pre.substring(0,--prelen);
        }
        return pre;
    }

}
