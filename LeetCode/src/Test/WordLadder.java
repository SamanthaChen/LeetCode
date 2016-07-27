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
	//��һ����
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
        
        wordList.add(endWord);//�ѽ����ʼ��뵽�б���
        
      //�������BFS
        while(!queue.isEmpty()){
        	
        	WordNode top = queue.remove();//��poll��Ϊremove
        	String word = top.word;
        	//ÿ�ζ������ж����ĵ����Ƿ�ﵽҪ��
        	if(word.equals(endWord)) return top.step;
        	char[] a = word.toCharArray();
        	
        	//��Ǳ�ڿ��ܵĵ��ʼ��뵽��������
        	for(int i=0;i<a.length;i++){
        		char temp = a[i];
        		//�ı�ԭ����������ĵ�����ĸ�����ֵ�����ͼ��뵽������
        		for(char c='a';c <='z';c++){
        			
        			if(a[i]!=c) a[i] = c;
        			
        			String w = new String(a);
        			if(wordList.contains(w)){
        				wordList.remove(w);
        				queue.add(new WordNode(w,top.step+1));//��push�ĳ�add
        			}

        		}
    			//��ԭԭ���ĵ�����ĸ
        		a[i] =temp;
           		

        	}
        }
		return 0;
    }

}
