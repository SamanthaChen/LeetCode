package Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class WordLadder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String beginWord = "hit";
		String endWord = "cog";
		String[] words = {"hot","dot","dog","lot","log"};
		Set<String> wordList = new HashSet<String>(); 
		Collections.addAll(wordList, words);
		System.out.println(ladderLength(beginWord,endWord,wordList));
	}
	//加一个类
	public static class WordNode{
		String word;
		int step;
		public WordNode(String w, int a){
			word = w;
			step = a;
		}
	}
    public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
     
        LinkedList<WordNode> queue = new LinkedList<WordNode>();
        queue.offer(new WordNode(beginWord,1));
        
        wordList.add(endWord);//把结束词加入到列表中
        
      //下面进行BFS
        while(!queue.isEmpty()){
        	
        	WordNode top = queue.remove();//把poll改为remove
        	String word = top.word;
        	//每次都检查队列顶部的单词是否达到要求
        	if(word.equals(endWord)) return top.step;
        	char[] a = word.toCharArray();
        	
        	//把潜在可能的单词加入到队列里面
        	for(int i=0;i<a.length;i++){
        		char temp = a[i];
        		//改变原来单词里面的单个字母，在字典里面就加入到队列中
        		for(char c='a';c <='z';c++){
        			
        			if(a[i]!=c) a[i] = c;
        			
        			String w = new String(a);
        			if(wordList.contains(w)){
        				wordList.remove(w);
        				queue.add(new WordNode(w,top.step+1));//把push改成add
        			}

        		}
    			//还原原来的单个字母
        		a[i] =temp;
           		

        	}
        }
		return 0;
    }

}
