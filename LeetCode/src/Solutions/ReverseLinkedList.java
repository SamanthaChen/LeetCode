package Solutions;

import DataStructual.ListNode;

public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
    	//迭代版本(从第二个指针开始考虑的，代码不够简洁)
        if(head == null) return head;
        ListNode cur = head.next;//保存head的后面一个数
        if(cur == null) return head;
        head.next = null;//保存完了将第一个数后面指针指向空
        ListNode post = cur.next;//保存head的后面第二个数

        while(post!=null){
            cur.next = head;//将指针转变方向
            head = cur;
            cur = post;//指针后移
            post = cur.next;//指针后移
            
        }
        cur.next = head;
        head = cur;
        return head;
    }
    public ListNode reverseList2(ListNode head){
    	//递归版本,递归的将指针转向再后移
        return reverse(head,null);

    }
    public ListNode reverse(ListNode head,ListNode newhead){
        //这个方法返回转置后的链表的最后一个数
        if(head == null) return newhead;
        ListNode next = head.next; 
        head.next = newhead;//指针转向
        return reverse(next,head);//向后移动
    }
    public ListNode reverseList3(ListNode head){
         //迭代版本(从第1个指针开始考虑的！)
         if(head == null || head.next == null) return head;
         ListNode newhead = null;
         while(head!=null){
             ListNode next = head.next;
             head.next = newhead;//改变指针方向
             newhead = head;//指针后移
             head = next;
         }
         return newhead;
    }
    
    ///2016.7.21新增一个我可以理解的递归的方法
	//递归转置链表
	//递归的方法
	public static ListNode reverseListNew(ListNode head){
		if(head==null || head.next == null) return head;
		ListNode newtail = head.next;
		ListNode newhead = reverseList (head.next);
		
		head.next =null;
		newtail.next = head;
		return newhead;
		
	}
   }
