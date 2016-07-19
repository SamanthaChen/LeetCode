package Solutions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
//import DataStructual.WordNode;//自己定义的数据结构
public class S127WordLadder {
	
	 
	//思路1：将单词字典建立一棵树，然后进行广度遍历 （这个方法超时？！）
	//有一个需要注意的地方，已经遇到好几次了就是不能先迭代set，然后又从中间删除set中的元素！

	class WordNode{
	    String word;
	    int numStep;//记录层数
	    
	    public WordNode(String word, int numStep){
	        this.word = word;
	        this.numStep = numStep;
	    }
	}


	    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
	    	wordList.add(endWord);//将最后一个单词也加入进去
	        //用队列实现深度遍历
	        LinkedList<WordNode> queue = new LinkedList<WordNode>();
	
	        queue.add(new WordNode(beginWord,1));
	        //这里是为了遍历wordList设计的
            Set<String> copyDict = new HashSet<String>();
            copyDict.addAll(wordList);
            boolean[] visited = new boolean[wordList.size()];
            
	        while(!queue.isEmpty()){
	            WordNode top = queue.pop();
	            String word = top.word;
	            
	            if(word.equals(endWord)) return top.numStep;//匹配到最后一个词，则返回层数
	            //将只差一个字母的单词加入到队列里面

	            int k = 0;
	            for(String w : copyDict){
	                int samechar = 0;
	                for(int i=0; i<word.length(); i++){
	                    if(w.charAt(i)==word.charAt(i)) samechar++;
	                }
	                if(samechar==word.length()-1  && !visited[k]) {
	                	queue.add(new WordNode(w,top.numStep +1));//把这个只差一个字母的词加入队列后，字典里面需要删除
	                	wordList.remove(w);
	                	visited[k] = true;
	                }
	                k++;
	            }
	        }
	        return 0;
	    }
	    
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			String beginWord = "hit";
			String endWord = "cog";
			Set<String> wordDict = new HashSet<String>();
			wordDict.add("hot");
			wordDict.add("dot");
			wordDict.add("dog");
			wordDict.add("lot");
			wordDict.add("log");
			S127WordLadder S = new S127WordLadder();
			int res = S.ladderLength( beginWord,  endWord,  wordDict);
			System.out.print(res);
			
			
		}


}
