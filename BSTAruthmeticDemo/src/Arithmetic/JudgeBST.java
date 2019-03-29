package Arithmetic;

import org.junit.Test;

import java.util.ArrayList;

public class JudgeBST {
    public static void main(String[] args) {

    }


    /**
     * 判断一个树是否为二叉排序树
     *      方法一：中序遍历，判断遍历序列是否为有序序列  时间复杂度O(logn)
     *      方法二：递归，每次拿左子树的最大值与右子树相比较  时间复杂度O(logn)
     *
     */


    /**
     * 方法1
     * @param root
     * @return
     */
    public boolean isBTS(TreeNode root){
        ArrayList<Integer> arr = returnVal(root);
        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i) > arr.get(i+1)) {
                return false;
            }
        }
        return true;
    }

    private ArrayList<Integer> returnVal(TreeNode root){
        if (root == null) {
            return null;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        if (root.left != null) {
            arr.addAll(returnVal(root.left));
        }
        arr.add(root.value);
        if (root.right != null) {
            arr.addAll(returnVal(root.right));
        }
        return arr;
    }








    @Test
    public void test(){
        TreeNode root = new TreeNode(5);
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(7);
        TreeNode root3 = new TreeNode(6);
        TreeNode root4 = new TreeNode(8);

        root.left = root1;
        root.right = root2;
        root2.left = root3;
        root2.right = root4;

        boolean bts = isBTS(root);
        System.out.println(bts);
    }
}
