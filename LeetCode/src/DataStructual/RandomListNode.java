package DataStructual;
/*
 * �������������ĸ����Ķ����random poiner�����ָ����������Ľڵ����null
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
			System.out.println("next��ϵ��");
			 while(n!=null){
				  System.out.print(n.label+"->");
				  n=n.next;
			  }
			  System.out.println("");
			  System.out.println("random��ϵ��");
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
