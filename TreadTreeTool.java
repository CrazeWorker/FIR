package 树;

public class TreadTreeTool<T> {
	// 定义全局变量pre指向每一次的前驱节点
	TreadTreeNode<T> pre = null;
	
	
	// 二叉树的中序线索化
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
