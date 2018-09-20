package ջ�Ͷ���;

import java.util.LinkedList;
import java.util.Queue;
import org.junit.Test;




public class TwoQueueMakeAStack<T> {
	private Queue<T> q1 = new LinkedList<>();
	private Queue<T> q2 = new LinkedList<>();
	private int size;
	
	// ѹջ����
	public void push(T t) {
		if (isEmpty()||!q1.isEmpty()) {
			q1.offer(t);
		}
		else {
			q2.offer(t);
		}
		size++;
	}
	
	// ��ջ����
	public T pop() {
		if (!q1.isEmpty()) {
			while (q1.size()>1) {
				q2.offer(q1.poll());
			}
			size--;
			return q1.poll();	
		}
		else {
			while (q2.size()>1) {
				q1.offer(q2.poll());
			}
			size--;
			return q2.poll();
		}
	}
	
	// �鿴ջ��Ԫ��
	public T peek() {
		if (!q1.isEmpty()) {
			while (q1.size()>1) {
				q2.offer(q1.poll());
			}
			T tt = q1.peek();
			q2.offer(q1.poll());
			return tt;
		}
		else {
			while (q2.size()>1) {
				q1.offer(q2.poll());
			}
			T tt = q2.peek();
			q1.offer(q2.poll());
			return tt;
		}
	}
	
	// �пղ���
	private boolean isEmpty() {
		return size==0?true:false;
	}
	
	// ����
	
	@Test
	public void test() {
		TwoQueueMakeAStack<Integer> tq = new TwoQueueMakeAStack<>();
		tq.push(1);
		tq.push(2);
		tq.push(3);
		tq.push(4);
		System.out.println(tq.peek());
		tq.push(5);
		tq.pop();
		tq.push(6);
		System.out.println(tq.peek());
		
	}
}
