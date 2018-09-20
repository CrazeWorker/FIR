package 栈和队列;

public class DiyStack<T> {
	private int size;
	private Object[] obj = new Object[4];
	
	// 判断栈是否为空
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// 返回栈的大小
	public int size() {
		return size;
	}
	
	// 扩充栈
	public void expandStack() {
		Object[] newObj = new Object[size*2];
		System.arraycopy(obj, 0, newObj, 0, size);
		obj = newObj;
	}
	
	// 压栈
	public void push(T t) {
		obj[size] = t;
		size++;
		if (size == obj.length) {
			expandStack();
		}
	}
	
	// 查看栈顶元素（不弹出）
	@SuppressWarnings("unchecked")
	public T peek() {
		if(isEmpty()) {
			return null;
		}else {
			return (T) obj[size-1];
		}
	}
	
	// 弹栈
	public T pop() {
		if(isEmpty()) {
			return null;
		}
		else {
			T t = peek();
			obj[size-1] = null;
			size--;
			return t;
		}
	}
}
