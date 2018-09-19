package ջ�Ͷ���;

import java.util.Stack;

public class TwoStackMakeAQueue<T> {
	private int size;
	private Stack<T> s1 = new Stack<>();
	private Stack<T> s2 = new Stack<>();
	
	// �ж϶����Ƿ�Ϊ��
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		else {
			return false;
		}
	}
		
	// ���ض��еĴ�С
	public int size() {
		return size;
	}
	
	// ��Ӳ���
	public void push(T t) {
		s1.push(t);
		size++;
	}
	
	// ���Ӳ���
	public T pop() {
		if (!s2.isEmpty()) {
			size--;
			return s2.pop();
		}
		else if(!s1.isEmpty()){
			while(!s1.isEmpty()) {
				s2.push(s1.pop());
			}
			size--;
			return s2.pop();
		}
		else {
			return null;
		}
	}
	
	// �鿴����Ԫ��
	public T peek() {
		if (!s2.isEmpty()) {
			return s2.peek();
		}
		else if(!s1.isEmpty()){
			while(!s1.isEmpty()) {
				s2.push(s1.pop());
			}
			return s2.peek();
		}
		else {
			return null;
		}
	}
}
