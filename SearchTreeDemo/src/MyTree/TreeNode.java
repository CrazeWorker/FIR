package MyTree;

public class TreeNode {
    Integer key;
    TreeNode leftChild;
    TreeNode rightChild;

    public TreeNode(Integer key, TreeNode leftChild, TreeNode rightChild) {
        this.key = key;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public TreeNode() {
    }
}
