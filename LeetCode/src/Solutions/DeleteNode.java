package Solutions;
/*ע��java�ĸ�ֵ����������*/
import DataStructual.ListNode;

public class DeleteNode {
    public void deleteNode(ListNode node) {
        ListNode temp = node.next;
        node.val = temp.val;
        node.next = temp.next;
    }
}
