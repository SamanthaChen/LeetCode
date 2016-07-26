package DataStructual;
/*
 * 这个单链表里面的给出的额外的random poiner会随机指向链表里面的节点或者null
 * **/
public class RandomListNode {
	 public int label;
	 public RandomListNode next;
	 public RandomListNode random;
	 public RandomListNode(int x){
		 this.label = x;
	 }
	 
		public void print(){
			RandomListNode head =this;
			RandomListNode n = head;
			System.out.println("next关系：");
			 while(n!=null){
				  System.out.print(n.label+"->");
				  n=n.next;
			  }
			  System.out.println("");
			  System.out.println("random关系：");
			  n = head;
			  while(n!=null){
			  		String s = "";
			  		if(n.random!=null) s = Integer.toString(n.random.label);
			  		else s = "null";
					System.out.print(s+"->");
					 n=n.next;
			 }
			  System.out.println("");
			  
		}
}
