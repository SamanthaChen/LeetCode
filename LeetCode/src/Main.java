import DataStructual.*;
import Solutions.*;
/**
 * ���ڲ��Ը����㷨,���Բ�һ���ľ�import��һ����
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
