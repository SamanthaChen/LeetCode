
import java.util.HashSet;
import java.util.Set;

import DataStructual.MinStack;
import DataStructual.NumArray;
import Solutions.*;
/**
 * 用于测试各种算法,测试不一样的就import不一样的
 * **/


public class Main {

//	public static void main(String[] args) {
//		
////		int[] nums = {1,2,3,4,5};
////		NumArray numArray = new NumArray(nums);
////		System.out.println(numArray.sumRange(0, 1));
////		System.out.println(numArray.sumRange(1, 2));
//		
//		
//		MinStack minStack = new MinStack();
//		minStack.push(-1);
//		minStack.getMin();
//		minStack.push(0);
//		minStack.getMin();
//		minStack.push(-2);
//		minStack.getMin();
//		minStack.push(-3);
//		minStack.getMin();
//		minStack.push(2);
//		minStack.getMin();
//		minStack.push(3);
//		minStack.getMin();   
//		minStack.pop();
//		minStack.top();
//		minStack.pop();
//		minStack.pop();
//		minStack.push(-4);
//		minStack.pop();
//		minStack.getMin();   
//		
//	}
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
