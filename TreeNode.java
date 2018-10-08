package 树;

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
	
	//添加左孩子节点
	public void addLeftChild(T value) {
		TreeNode<T> node = new TreeNode<>(value);
		this.leftChild = node;
	}
	
	//添加右孩子节点
	public void addRightChild(T value) {
		TreeNode<T> node = new TreeNode<>(value);
		this.rightChild = node;
	}
}
