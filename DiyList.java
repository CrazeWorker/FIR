package ����;

import static org.junit.Assume.assumeNoException;

import java.awt.List;
import java.util.Comparator;
import java.util.Stack;

import org.junit.Test;

public class DiyList<T> {
	private ListNode<T> head = new ListNode<>(null,null);
	// ����Comparator�ȽϽӿ�
	public Comparator<T> comp;
	public int compare(T a,T b) {
		if(comp != null) {
			return comp.compare(a,b);
		}
		else {
			Comparable<T> c = (Comparable<T>) a;
			return c.compareTo(b);
		}
	}
	
	// ����������ķ���
	public void arrayToList(T[] array) {
		ListNode<T> p = head;
		for (T t : array) {
			ListNode<T> node = new ListNode<>(t,null);
			p.next = node;
			p = node;
		}
	}
	
	// ��ӡ����ĺ���
	public void printList() {
		ListNode<T> p = head.next;
		while(p != null) {
			System.out.print(p.value+" ");
			p = p.next;
		}
	}
	
	// �������в���ڵ�
	public void insert(T value,int index) {
		int i = 0;
		ListNode<T> p = head.next;
		while(i < index) {
			p = p.next;
			i++;
		}
		ListNode<T> node = new ListNode<>(value,p.next);
		p.next = node;
	}
	
	//ɾ�������еĽڵ�
	public void remove(int index) {
		int i = 0;
		ListNode<T> p = head.next;
		while(i < index - 1) {
			p = p.next;
			i++;
		}
		p.next = p.next.next;
		p.next.next = null;	
	}
	
	//��ѯ
	public T get(int index) {
		ListNode<T> p = head;
		int i = 0;
		while(i <= index) {
			p = p.next;
			i++;
		}
		return p.value;
	}
	
	// �޸�
	public void set(int index,T value) {
		ListNode<T> p = head;
		int i = 0;
		while(i <= index) {
			p = p.next;
			i++;
		}
		p.value = value;
	}
	
	// �����ӡ����(�ǵݹ��㷨)
	public void reservePrint() {
		Stack<T> s = new Stack();
		ListNode<T> p = head.next;
		while(p != null) {
			s.push(p.value);
			p = p.next;
		}
		while(s.size() != 0) {
			System.out.print(s.pop()+" ");
		}
	}
	
	// �����ӡ����(�ݹ��㷨)
	public void reservePrint2(ListNode<T> p) {
		if(p != null) {
			reservePrint2(p.next);
			System.out.print(p.value+" "); 
		}	
	}
	public void recursive() {
		if(head.next == null) {
			return;
		}
		reservePrint2(head.next);
	}
	
	// �������е����ֵ
	public T getMax() {
		if(head.next == null) {
			return null;
		}
		ListNode<T> p = head.next;
		T max = p.value;
		
		while(p != null) {
			p=p.next;
			if(compare(p.value,max) >= 0) {
				max = p.value;
			}
		}
		return max;
	}
	
	// ��ת����
	@SuppressWarnings("null")
	public ListNode<T> listReverse(){
		if(head.next == null) {
			return head;
		}
		ListNode<T> pre = head.next;
		ListNode<T> p = pre.next;
		ListNode<T> next;
		pre.next = null;
		while(p != null) {
			next = p.next;
			p.next = pre;
			pre = p;
			p = next;
		}
		head.next = null;
		return pre;
	}
	
	// ���ҵڵ�����N���ڵ�(��ͨ�㷨)
	public ListNode<T> seachNode(int index) {
		ListNode<T> p = head.next;
		int size = 0;
		while(p != null) {
			size += 1;
			p = p.next;
		}
		p = head.next;
		for (int i = 0; i < size - index; i++) {
			p = p.next;
		}
		return p;
	}
	
	// ���ҵڵ�����N���ڵ�(OnPass�㷨)
	public ListNode<T> searchNode(int index) {
		ListNode<T> p1 = head;
		ListNode<T> p2 = head;
		for (int i = 0; i < index; i++) {
			p2 = p2.next;
		}
		while(p2 != null) {
			p2 = p2.next;
			p1 = p1.next;
		}
		return p1;
	}
	
	// ��ѯ�ڵ㲢ɾ��
	public void deleteValue(T value) {
		ListNode<T> p = head.next;
		ListNode<T> pre = head;
		while(p != null) {
			if(p.value.equals(value)) {
				pre.next = p.next;
				p.next = null;
				p = pre.next;
			}else {
				pre = p;
				p = p.next;
			}
		}
	}
	
	// ɾ���ظ��ڵ�
	public void deleteDuplicates() {
		ListNode<T> pre = head.next;
		ListNode<T> p = pre.next;
		if(head == null||head.next == null) {
			return;
		}
		while(p != null) {
			if(pre.value == p.value) {
				while(p.next != null||pre.value == p.value) {
					p = p.next;
				}
				if(p != null) {
					pre.next = p;
				}
				else
					break;
				
			}
			else {
				pre = p;
				p = p.next;
		}
		}
	
	}
	// ��ת�����ָ������ 
	public ListNode<T> reverseBetween(ListNode<T> head,int begin,int end) {
		ListNode<T> newHead = new ListNode<>();
		if(head == null||head.next == null) {
			return head;
		}
		else if(begin == end){
			return head;
		}
		else {
			int k = 1;
			newHead.next = head;
			ListNode<T> first = newHead.next;
			while(k < begin) {
				first = first.next;
				k++;
			}
			final ListNode<T> s = first.next;
			ListNode<T> pre = first.next;
			ListNode<T> p = pre.next;
			ListNode<T> next = null;
			pre.next = null;
			while(k < end) {
				next = p.next;
				p.next = pre;
				pre = p;
				p = next;
				k++;
			}
			first.next = pre;
			if(p != null) {
				s.next = p;
			}
		}
		return newHead.next;
	}
	public void useReverse(int begin,int end) {
		reverseBetween(head,begin,end);
	}
	
	// ��ת����
	public void spinList(int index) {
		ListNode<T> pre = head;
		for (int i = 0; i < index; i++) {
			pre = pre.next;
		}
		ListNode<T> p = pre;
		while(p.next != null) {
			p = p.next;
		}
		p.next = head.next;
		head.next = pre.next;
		pre.next = null;
	}
	
	// ����������
	public int size() {
		ListNode<T> p = head.next;
		int size = 0;
		while(p != null) {
			p = p.next;
			size++;
		}
		return size;
	}
	
	// �ж��Ƿ�Ϊ��������
	public boolean isPalindromeList(DiyList<T> d) {
		if(head == null||head.next == null) {
			return true;
		}
		else {
			int n = d.size();
			int half = n / 2;
			ListNode<T> leftend = head.next;
			for (int i = 0; i < half - 1; i++) {
				leftend = leftend.next;
			}
			ListNode<T> rightstart;
			if(n % 2 == 1) {
				d.reverseBetween(head, half+2, d.size());
				rightstart = leftend.next.next;
			}
			else {
				d.reverseBetween(head, half+1, d.size());
				rightstart = leftend.next;
			}
			ListNode<T> leftstart = head.next;
			for (int i = 0; i < half; i++) {
				if(leftstart.value != rightstart.value) {
					return false;
				}
				leftstart = leftstart.next;
				rightstart = rightstart.next;
			}
			return true;
		}
	}
	
	// ��ת���ڵ������ڵ�
	public void reverseBorderOnListNode() {
		if(head == null||head.next == null) {
			return;
		}
		else {
			ListNode<T> zero = head;
			ListNode<T> pre = head.next;
			ListNode<T> p = pre.next;
			ListNode<T> next = null;
			while(pre != null&&p != null) {
				next = p.next;
				p.next = pre;
				pre.next = next;
				zero.next = p;
				if(next == null) {
					break;
				}else {
					zero = pre;
					pre = next;
					p = pre.next;
				}
			}
		}
	}
}
