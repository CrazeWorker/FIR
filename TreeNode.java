package ��;

public class TreeNode<T> {
	public T value;
	public TreeNode<T> leftChild;
	public TreeNode<T> rightChild;
	public TreeNode(T value) {
		super();
		this.value = value;
	}
	public TreeNode() {
		super();
	}
	
	//������ӽڵ�
	public void addLeftChild(T value) {
		TreeNode<T> node = new TreeNode<>(value);
		this.leftChild = node;
	}
	
	//����Һ��ӽڵ�
	public void addRightChild(T value) {
		TreeNode<T> node = new TreeNode<>(value);
		this.rightChild = node;
	}
}
