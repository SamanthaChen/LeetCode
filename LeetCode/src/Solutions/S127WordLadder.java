package Solutions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
//import DataStructual.WordNode;//�Լ���������ݽṹ
public class S127WordLadder {
	
	 
	//˼·1���������ֵ佨��һ������Ȼ����й�ȱ��� �����������ʱ������
	//��һ����Ҫע��ĵط����Ѿ������ü����˾��ǲ����ȵ���set��Ȼ���ִ��м�ɾ��set�е�Ԫ�أ�

	class WordNode{
	    String word;
	    int numStep;//��¼����
	    
	    public WordNode(String word, int numStep){
	        this.word = word;
	        this.numStep = numStep;
	    }
	}


	    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
	    	wordList.add(endWord);//�����һ������Ҳ�����ȥ
	        //�ö���ʵ����ȱ���
	        LinkedList<WordNode> queue = new LinkedList<WordNode>();
	
	        queue.add(new WordNode(beginWord,1));
	        //������Ϊ�˱���wordList��Ƶ�
            Set<String> copyDict = new HashSet<String>();
            copyDict.addAll(wordList);
            boolean[] visited = new boolean[wordList.size()];
            
	        while(!queue.isEmpty()){
	            WordNode top = queue.pop();
	            String word = top.word;
	            
	            if(word.equals(endWord)) return top.numStep;//ƥ�䵽���һ���ʣ��򷵻ز���
	            //��ֻ��һ����ĸ�ĵ��ʼ��뵽��������

	            int k = 0;
	            for(String w : copyDict){
	                int samechar = 0;
	                for(int i=0; i<word.length(); i++){
	                    if(w.charAt(i)==word.charAt(i)) samechar++;
	                }
	                if(samechar==word.length()-1  && !visited[k]) {
	                	queue.add(new WordNode(w,top.numStep +1));//�����ֻ��һ����ĸ�Ĵʼ�����к��ֵ�������Ҫɾ��
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
