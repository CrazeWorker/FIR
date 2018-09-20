package ջ�Ͷ���;

public class DiyStack<T> {
	private int size;
	private Object[] obj = new Object[4];
	
	// �ж�ջ�Ƿ�Ϊ��
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// ����ջ�Ĵ�С
	public int size() {
		return size;
	}
	
	// ����ջ
	public void expandStack() {
		Object[] newObj = new Object[size*2];
		System.arraycopy(obj, 0, newObj, 0, size);
		obj = newObj;
	}
	
	// ѹջ
	public void push(T t) {
		obj[size] = t;
		size++;
		if (size == obj.length) {
			expandStack();
		}
	}
	
	// �鿴ջ��Ԫ�أ���������
	@SuppressWarnings("unchecked")
	public T peek() {
		if(isEmpty()) {
			return null;
		}else {
			return (T) obj[size-1];
		}
	}
	
	// ��ջ
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
