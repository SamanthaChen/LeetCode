import DataStructual.*;
import Solutions.*;
/**
 * 用于测试各种算法,测试不一样的就import不一样的
 * **/

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node0 = new ListNode(0);
		ListNode node1 = new ListNode(1);
		node0.next = node1;
		Solution237DeleteNode solution = new Solution237DeleteNode();
		solution.deleteNode(node0);
	}

}
