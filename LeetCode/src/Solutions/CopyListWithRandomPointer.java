package Solutions;

import java.util.HashMap;

import DataStructual.ListNode;
import DataStructual.RandomListNode;

public class CopyListWithRandomPointer {

	public static void main(String[] args) {
		RandomListNode n1 = new RandomListNode(1);
		RandomListNode n2 = new RandomListNode(2);
		RandomListNode n3 = new RandomListNode(3);
		RandomListNode n4 = new RandomListNode(4);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n1.random=n3;
		n2.random=n4;
		n1.print();
		RandomListNode copy = copyRandomList2(n1);
		copy.print();

	}
	/*
	 * 思路：别人提的一个绝佳的方法：
	 * 1.每个节点复制一个新的节点，并且插入到复制的节点后面
	 * 2.分配random 指针
	 * 3.将两个重复的链表进行撕裂
	 * **/
	public static RandomListNode copyRandomList(RandomListNode head){
		if(head==null) return null;
//		if(head.next==null) return new RandomListNode(head.label);
		//首先复制每个节点并且插入
		RandomListNode p = head;
		while(p!=null){
			RandomListNode nxt = p.next;//存后一位
			RandomListNode p1 = new RandomListNode(p.label); //复制节点
			p1.next = nxt; //插入
			p.next = p1;  //插入
			p = nxt;
		}
		//然后复制random指针
		p = head;
		while(p!=null){
			//还得考虑一下random不为空的情况
			if(p.random!=null)
				p.next.random = p.random.next;
			p = p.next.next;
		}
		//将两个重复的链表进行撕裂
		//注意这里，原来链表最后一位是指向空的
		p = head;
		RandomListNode newhead = p.next;
		while(p!=null){
			RandomListNode p1 = p.next;
			p.next = p1.next;
			if(p1.next!=null)//不为空就赋值，空的话就继续空
				p1.next = p1.next.next;
			p = p.next;
			
		}
		return newhead;
	}
	/**
	 * 思路2：用一个map来记录新复制的节点和原来节点的对应关系
	 * */
	public static RandomListNode copyRandomList2(RandomListNode head){
		if(head == null) return null;
		RandomListNode  p = head;
		//首先复制一下
		RandomListNode  newhead = new RandomListNode(p.label);
		RandomListNode  p1 = newhead;
		HashMap<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
		map.put(p, p1);
		p = p.next;
		while(p!=null){
			RandomListNode tmp = new RandomListNode(p.label);
			map.put(p, tmp);
			p1.next = tmp;
			p1 = tmp;
			p = p.next;
		}
		//根据map 复制一下random关系
		p = head;
		p1 = newhead;
		while(p!=null){
			if(p.random!=null){
				p1.random = map.get(p.random);
			}
			p = p.next;
			p1=p1.next;
		}
		return newhead;
			
	}

}
