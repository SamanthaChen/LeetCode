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
	 * ˼·���������һ�����ѵķ�����
	 * 1.ÿ���ڵ㸴��һ���µĽڵ㣬���Ҳ��뵽���ƵĽڵ����
	 * 2.����random ָ��
	 * 3.�������ظ����������˺��
	 * **/
	public static RandomListNode copyRandomList(RandomListNode head){
		if(head==null) return null;
//		if(head.next==null) return new RandomListNode(head.label);
		//���ȸ���ÿ���ڵ㲢�Ҳ���
		RandomListNode p = head;
		while(p!=null){
			RandomListNode nxt = p.next;//���һλ
			RandomListNode p1 = new RandomListNode(p.label); //���ƽڵ�
			p1.next = nxt; //����
			p.next = p1;  //����
			p = nxt;
		}
		//Ȼ����randomָ��
		p = head;
		while(p!=null){
			//���ÿ���һ��random��Ϊ�յ����
			if(p.random!=null)
				p.next.random = p.random.next;
			p = p.next.next;
		}
		//�������ظ����������˺��
		//ע�����ԭ���������һλ��ָ��յ�
		p = head;
		RandomListNode newhead = p.next;
		while(p!=null){
			RandomListNode p1 = p.next;
			p.next = p1.next;
			if(p1.next!=null)//��Ϊ�վ͸�ֵ���յĻ��ͼ�����
				p1.next = p1.next.next;
			p = p.next;
			
		}
		return newhead;
	}
	/**
	 * ˼·2����һ��map����¼�¸��ƵĽڵ��ԭ���ڵ�Ķ�Ӧ��ϵ
	 * */
	public static RandomListNode copyRandomList2(RandomListNode head){
		if(head == null) return null;
		RandomListNode  p = head;
		//���ȸ���һ��
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
		//����map ����һ��random��ϵ
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
