package Ê÷;

public class TreadTreeNode<T> {
	public T value;
	public boolean hasLchild;
	public boolean hasRchild;
	public TreadTreeNode<T> leftChild;
	public TreadTreeNode<T> rightChild;
	
	public TreadTreeNode(T value) {
		super();
		this.value = value;
	}
	public TreadTreeNode() {
		super();
	}
}
