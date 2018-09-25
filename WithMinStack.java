package 栈和队列;

import java.util.Stack;

import org.junit.Test;

public class WithMinStack {
	private Stack<Integer> s1 = new Stack<>();
	private Stack<Integer> min1 = new Stack<>();
	//入栈操作
	public void push(int i) {
		if (s1.isEmpty()) {
			s1.push(i);
			min1.push(i);
		}
		else {
			s1.push(i);
			int min = min1.peek();
			min1.push(Math.min(i, min));
		}
	}
	
	// 出栈操作
	public int pop() {
		min1.pop();
		return s1.pop();	
	}
	
	//判空操作
	public boolean isEmpty() {
		return s1.isEmpty();
	}
	
	// 取得最小值
	public int getMin() {
		return min1.peek();
	}
	
	// 查看栈顶元素
	public int peek() {
		return s1.peek();
	}
	
	@Test
	public void test() {
		WithMinStack ms = new WithMinStack();
		ms.push(5);
		ms.push(6);
		ms.push(7);
		ms.push(4);
		ms.push(9);
		System.out.println(ms.getMin());
		System.out.println(ms.peek());
		ms.pop();
		ms.pop();
		System.out.println(ms.getMin());
		System.out.println(ms.peek());
		ms.pop();
	}
}
