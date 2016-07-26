package Solutions;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static boolean wordPattern(String pattern, String str) {
        String[] strArray = str.split(" ");
        if(pattern.length()!= strArray.length) return false;
        
        //方法1
        // HashMap<Character,String> map = new HashMap<Character,String>();
        // for(int i = 0; i < strArray.length; i++ ){
        //     char a = pattern.charAt(i);
        //     if(map.containsKey(a)){
        //         if(!(map.get(a).equals(strArray[i]))) return false;
        //         else continue;
        //     }else{
        //         if(map.containsValue(strArray[i])) return false;
        //         else map.put(a,strArray[i]);
        //     }
        // }
        // return true;
        
        // 方法2 (Integer 和int居然不一样)with i being an Integer object, which allows to compare with just != because there's no autoboxing-same-value-to-different-objects-problem anymore. https://leetcode.com/discuss/62374/8-lines-simple-java
        Map map = new HashMap();
        for(Integer i = 0 ; i < pattern.length(); ++i){
            if(map.put(pattern.charAt(i),i)!=map.put(strArray[i],i) ) return false;
        }
        return true;
        
    //         String[] words = str.split(" ");
    // if (words.length != pattern.length())
    //     return false;
    // Map index = new HashMap();
    // for (Integer i=0; i<words.length; ++i)
    //     if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
    //         return false;
    // return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "itwasthebestoftimesitwastheworstoftimesitwastheageofwisdomitwastheageoffoolishnessitwastheepochofbeliefitwastheepochofincredulityitwastheseasonoflightitwastheseasonofdarknessitwasthespringofhopeitwasthewinterofdespair";
		String b = "i tttttttttttttttt wwww aa sssss tttttttttttttttt hhhhhhhhhhhhhhhhhhhhhhh eeeeeeeeeee bbbbbbbbbbbbbbbbbb eeeeeeeeeee sssss tttttttttttttttt oo fffffffff tttttttttttttttt i mmm eeeeeeeeeee sssss i tttttttttttttttt wwww aa sssss tttttttttttttttt hhhhhhhhhhhhhhhhhhhhhhh eeeeeeeeeee wwww oo rrrrrrrrrrrrrr sssss tttttttttttttttt oo fffffffff tttttttttttttttt i mmm eeeeeeeeeee sssss i tttttttttttttttt wwww aa sssss tttttttttttttttt hhhhhhhhhhhhhhhhhhhhhhh eeeeeeeeeee aa gggggggggggggg eeeeeeeeeee oo fffffffff wwww i sssss ddddddddddd oo mmm i tttttttttttttttt wwww aa sssss tttttttttttttttt hhhhhhhhhhhhhhhhhhhhhhh eeeeeeeeeee aa gggggggggggggg eeeeeeeeeee oo fffffffff fffffffff oo oo llllllll i sssss hhhhhhhhhhhhhhhhhhhhhhh nnnnnn eeeeeeeeeee sssss sssss i tttttttttttttttt wwww aa sssss tttttttttttttttt hhhhhhhhhhhhhhhhhhhhhhh eeeeeeeeeee eeeeeeeeeee pppp oo cccccccccccc hhhhhhhhhhhhhhhhhhhhhhh oo fffffffff bbbbbbbbbbbbbbbbbb eeeeeeeeeee llllllll i eeeeeeeeeee fffffffff i tttttttttttttttt wwww aa sssss tttttttttttttttt hhhhhhhhhhhhhhhhhhhhhhh eeeeeeeeeee eeeeeeeeeee pppp oo cccccccccccc hhhhhhhhhhhhhhhhhhhhhhh oo fffffffff i nnnnnn cccccccccccc rrrrrrrrrrrrrr eeeeeeeeeee ddddddddddd uuuuuuuuuu llllllll i tttttttttttttttt yyyyyyyyyyy i tttttttttttttttt wwww aa sssss tttttttttttttttt hhhhhhhhhhhhhhhhhhhhhhh eeeeeeeeeee sssss eeeeeeeeeee aa sssss oo nnnnnn oo fffffffff llllllll i gggggggggggggg hhhhhhhhhhhhhhhhhhhhhhh tttttttttttttttt i tttttttttttttttt wwww aa sssss tttttttttttttttt hhhhhhhhhhhhhhhhhhhhhhh eeeeeeeeeee sssss eeeeeeeeeee aa sssss oo nnnnnn oo fffffffff ddddddddddd aa rrrrrrrrrrrrrr kkkkkkkkk nnnnnn eeeeeeeeeee sssss sssss i tttttttttttttttt wwww aa sssss tttttttttttttttt hhhhhhhhhhhhhhhhhhhhhhh eeeeeeeeeee sssss pppp rrrrrrrrrrrrrr i nnnnnn gggggggggggggg oo fffffffff hhhhhhhhhhhhhhhhhhhhhhh oo pppp eeeeeeeeeee i tttttttttttttttt wwww aa sssss tttttttttttttttt hhhhhhhhhhhhhhhhhhhhhhh eeeeeeeeeee wwww i nnnnnn tttttttttttttttt eeeeeeeeeee rrrrrrrrrrrrrr oo fffffffff ddddddddddd eeeeeeeeeee sssss pppp aa i rrrrrrrrrrrrrr";
		System.out.println(wordPattern(a,b) ? "T" : "F" );
	}
}
