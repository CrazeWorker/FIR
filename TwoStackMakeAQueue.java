package 栈和队列;

import java.util.Stack;

public class TwoStackMakeAQueue<T> {
	private int size;
	private Stack<T> s1 = new Stack<>();
	private Stack<T> s2 = new Stack<>();
	
	// 判断队列是否为空
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		else {
			return false;
		}
	}
		
	// 返回队列的大小
	public int size() {
		return size;
	}
	
	// 入队操作
	public void push(T t) {
		s1.push(t);
		size++;
	}
	
	// 出队操作
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
	
	// 查看队首元素
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
