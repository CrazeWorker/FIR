package MyTree;


import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class MyTreeDemo {
    TreeNode root = null;

    public MyTreeDemo() {
    }

    public MyTreeDemo(TreeNode root) {
        this.root = root;
    }

    List<Integer> arr = new ArrayList<>();

    // 二叉搜索树的插入操作
    public boolean insertNode(TreeNode node) {
        // 如果根节点为null，那么此树为一棵空树，直接返回false
        if (root == null) {
            root = node;
            return true;
        }
        TreeNode temp = root;
        while (true) {
            // 如果要插入的结点的值比当前节点小，就去当前结点的左子树插入，如果左子树为空，直接插入，如果左子树不为空，继续进行此操作。
            if (node.key < temp.key) {
                if (temp.leftChild != null) {
                    // 左子树不为空，移动到左子树的根节点
                    temp = temp.leftChild;
                } else {
                    // 左子树为空，插入成功
                    temp.leftChild = node;
                    return true;
                }
                // 如果要插入的结点的值比当前节点大，就去当前结点的右子树插入，如果右子树为空，直接插入，如果右子树不为空，继续进行此操作。
            } else {
                if (temp.rightChild != null) {
                    // 右子树不为空，移动到右子树的根节点
                    temp = temp.rightChild;
                } else {
                    // 右子树为空，插入成功
                    temp.rightChild = node;
                    return true;
                }
            }
        }
    }


    // 二叉搜索树的查找操作
    public TreeNode search(int key) {
        // 如果为一颗空树，则没有查询到，直接返回空
        if (root == null) {
            return null;
        }
        TreeNode temp = root;
        // 遍历该二叉搜索树
        while (true) {
            // 如果查找的值小于当前指针位置的值，就移动到左子树
            if (key < (int) temp.key) {
                if (temp.leftChild != null) {
                    temp = temp.leftChild;
                    // 如果左子树为空，查找失败，返回null
                } else {
                    return null;
                }
            } else if (key > (int) temp.key) {
                if (temp.rightChild != null) {
                    temp = temp.rightChild;
                } else {
                    return null;
                }
            } else {
                return temp;
            }
        }
    }

    // 在一个搜索树中查找某个值是否存在
    public boolean contains(int value, TreeNode root) {
        // 循环直到root为空，则没找到，返回false
        while (root != null) {
            // 如果 要查找的值比当前结点的值大，去当前结点的右子树查找
            if (root.key < value) {
                root = root.rightChild;
            // 如果 要查找的值比当前节点的值小，去当前结点的左子树查找
            } else if (root.key > value) {
                root = root.leftChild;
            // 如果相等，就找到，返回true
           } else {
                return true;
            }
        }
        return false;
    }

    // 查找树中值最大的结点
    public TreeNode getMax(TreeNode root){
        // 思路：一直往右找，直到右孩子为空，返回当前结点
        while (root.rightChild != null) {
            root = root.rightChild;
        }
        return root;
    }

    // 查找树中值最小的结点
    private TreeNode getMin(TreeNode root){
        // 思路：一直往左找，直到左孩子为空，返回当前结点
        while (root.leftChild != null) {
            root = root.leftChild;
        }
        return root;
    }

    public void removeMin(){
        root = removeMin(root);
    }

    // 删除查找树中最小的结点
     public TreeNode removeMin(TreeNode root) {
        // 如果左子树为空，则此结点为最小值，记下它的右子树，并把它的右子树置为null，删除，返回他的右子树
        if (root.leftChild == null) {
            TreeNode rightChild = root.rightChild;
            root.rightChild = null;
            return rightChild;
        }
        // 如果左子树不为空，递归查找root的左子树是否为最小值
        root.leftChild = removeMin(root.leftChild);
        return  root;
    }

    public void removeMax(){
        root = removeMax(root);
    }

    // 删除查找树中最大的结点
    private TreeNode removeMax(TreeNode root) {
        // 如果左子树为空，则此结点为最小值，记下它的右子树，并把它的右子树置为null，删除，返回他的右子树
        if (root.rightChild == null) {
            TreeNode leftChild = root.leftChild;
            root.leftChild = null;
            return leftChild;
        }
        // 如果左子树不为空，递归查找root的左子树是否为最小值
        root.rightChild = removeMin(root.rightChild);
        return  root;
    }

    // 删除查找树中任意值为value的结点
    private TreeNode remove(TreeNode root, Integer value) {
        // 如果是空树，直接返回null
        if (root == null) {
            return null;
        }
        // 如果要查找的value值比root的key值小，那么去左子树递归删除
        if (value < root.key) {
            root.leftChild = remove(root.leftChild,value);
            return root;
        // 如果查找的value值比root的key值大，那么去右子树递归删除
        } else if (value > root.key) {
            root.leftChild = remove(root.rightChild, value);
            return root;
        // 如果刚好相等，即找到了结点。
        } else {
            // 如果该节点的左子树为空，右子树不为空，则记下右子树，删除该节点，并返回右子树的根节点
            if (root.leftChild == null && root.rightChild != null) {
                // 记下右子树的根节点
                TreeNode rightChild = root.rightChild;
                // 删除此节点
                root.rightChild = null;
                // 返回右子树的根节点
                return rightChild;
            }
            // 如果该节点的右子树为空，左子树不为空，则记下左子树，删除该结点，并返回左子树的根节点
            if (root.rightChild == null && root.leftChild != null) {
                // 记下左子树的根节点
                TreeNode leftChild = root.leftChild;
                // 删除此节点
                root.leftChild = null;
                // 返回左子树的根节点
                return leftChild;
            }
            // 如果此结点既有左子树，又有右子树，那么要从右子树中查找出一个最小值，替换当前节点作为当前自述的根节点

            // 记下当前节点的右子树的最小值结点作为新的根节点
            TreeNode rightMin = getMin(root.rightChild);
            // 从右子树中删除该节点，并将右子树新的根节点与新根节点连接
            rightMin.rightChild = removeMin(root.rightChild);
            // 新的根节点与左子树连接
            rightMin.leftChild = root.leftChild;
            // 删除旧的根节点
            root.leftChild = root.rightChild = null;
            // 返回新的根节点
            return rightMin;
        }
    }

    public void remove(Integer value) {
        root = remove(root,value);
    }
}
