package ��;

import java.util.Scanner;

import org.junit.Test;

public class TreeTool {
	// �������Ľڵ����
	public static <T> int getTreeNodeNum(TreeNode<T> root) {
		if(root == null) {
			return 0;
		}
		return getTreeNodeNum(root.leftChild) + getTreeNodeNum(root.rightChild) + 1;
	}
	
	// �����������
	public static <T> int getTreeDepth(TreeNode<T> root) {
		if(root == null) {
			return 0;
		}
		int leftDepth = getTreeDepth(root.leftChild) + 1;
		int rightDepth = getTreeDepth(root.rightChild) + 1;
		return Math.max(leftDepth, rightDepth);
	}
	
	// ����ǰ�����(������)
	public static <T> void preOrderTravel(TreeNode<T> root) {
		if (root == null) {
			return;
		}
		System.out.print(root.value+" ");
		preOrderTravel(root.leftChild);
		preOrderTravel(root.rightChild);
	}
	
	// �����������(�����)
	public static <T> void midOrderTravel(TreeNode<T> root) {
		if (root == null) {
			return;
		}
		midOrderTravel(root.leftChild);
		System.out.print(root.value+" ");
		midOrderTravel(root.rightChild);
	}
	
	// ���ĺ������(���Ҹ�)
	public static <T> void backOrderTravel(TreeNode<T> root) {
		if (root == null) {
			return;
		}
		backOrderTravel(root.leftChild);
		backOrderTravel(root.rightChild);
		System.out.print(root.value+" ");
	}
	
	// ��������ָ���ڵ�
	public static <T> void visitTreeNode(TreeNode<T> node) {
		System.out.println(node.value);
	}
	
	// ������������������д���һ�ö�����
	public static <T> TreeNode<Character> createTreeByPreOder(TreeNode<Character> root) {
		Scanner sc = new Scanner(System.in);
		char value = sc.next().charAt(0);
		if(value =='#') {
			return null;
		}
		else {
			TreeNode<Character> node = new TreeNode<>(value); 
			root = node;
			root.leftChild = createTreeByPreOder(root.leftChild);
			root.rightChild = createTreeByPreOder(root.rightChild);
		}
		return root;
	}
	
	// ������������������д���һ�ö�����
	public static <T> TreeNode<Character> createTreeByMidOder(TreeNode<Character> root) {
		Scanner sc = new Scanner(System.in);
		char value = sc.next().charAt(0);
		if(value =='#') {
			return null;
		}
		else {
			root.leftChild = createTreeByPreOder(root.leftChild);
			TreeNode<Character> node = new TreeNode<>(value); 
			root = node;
			root.rightChild = createTreeByPreOder(root.rightChild);
		}
		return root;
	}
	
	// �������ĺ���������д���һ�ö�����
		public static <T> TreeNode<Character> createTreeByBackOder(TreeNode<Character> root) {
			Scanner sc = new Scanner(System.in);
			char value = sc.next().charAt(0);
			if(value =='#') {
				return null;
			}
			else {
				root.leftChild = createTreeByPreOder(root.leftChild);
				root.rightChild = createTreeByPreOder(root.rightChild);
				TreeNode<Character> node = new TreeNode<>(value); 
				root = node;
			}
			return root;
		}
	
	@Test
	public void test2() {
		TreeNode<Character> root = new TreeNode<>();
		root.addLeftChild('1');
		root.addRightChild('2');
		root.leftChild.addLeftChild('3');
		root.rightChild.addRightChild('5');
		root.leftChild.addRightChild('4');
		root = createTreeByPreOder(root);
		System.out.print("�����������Ϊ��");
		midOrderTravel(root);
	}
	
	
	
	
	
	@Test
	public void test() {
		TreeNode<Integer> root = new TreeNode<>(0);
		root.addLeftChild(1);
		root.addRightChild(2);
		root.leftChild.addLeftChild(3);
		root.rightChild.addRightChild(5);
		root.leftChild.addRightChild(4);
		
		System.out.println("�������Ϊ��"+getTreeDepth(root));
		System.out.println("���Ľڵ���Ϊ��"+getTreeNodeNum(root));
		System.out.print("����ǰ���������Ϊ��");
		preOrderTravel(root);
		System.out.println();
		System.out.print("���������������Ϊ��");
		midOrderTravel(root);
		System.out.println();
		System.out.print("���ĺ����������Ϊ��");
		backOrderTravel(root);
	}
}
