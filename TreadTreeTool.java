package ��;

public class TreadTreeTool<T> {
	// ����ȫ�ֱ���preָ��ÿһ�ε�ǰ���ڵ�
	TreadTreeNode<T> pre = null;
	
	
	// ������������������
	public static <T> void InTreading(TreadTreeNode<T> root) {
		if(root == null) {
			return;
		}
		InTreading(root.leftChild);
		if(root.leftChild == null) {
			root.hasLchild = false;
			root.leftChild = pre;
		}
	}
}
