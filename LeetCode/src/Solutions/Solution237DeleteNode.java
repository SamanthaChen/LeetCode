package Solutions;
/*注意java的赋值符号是引用*/
import DataStructual.ListNode;

public class Solution237DeleteNode {
    public void deleteNode(ListNode node) {
        ListNode temp = node.next;
        node.val = temp.val;
        node.next = temp.next;
    }
}
