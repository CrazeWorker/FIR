package MyTree;

import org.junit.Test;

import java.util.Scanner;

public class ArrayToSearchTree {
    // 有序数组转化为二叉搜索树
    private TreeNode arrayToSearchTree(int[] array,int begin,int end){
        if (begin > end) {
            return null;
        }
        int mid = (begin + end) / 2;
        TreeNode root = new TreeNode();
        root.key = array[mid];
        root.leftChild = arrayToSearchTree(array, begin, mid - 1);
        root.rightChild = arrayToSearchTree(array, mid + 1, end);
        return root;
    }

    public TreeNode createATree(int[] array){
        if (array.length == 0) {
            return null;
        }
        return arrayToSearchTree(array, 0, array.length - 1);
    }

    @Test
    public void test(){
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode aTree = createATree(a);
        System.out.println(aTree.key+" "+aTree.leftChild.key+" "+aTree.rightChild.key);
        MyTreeDemo myTreeDemo = new MyTreeDemo();
        System.out.println(myTreeDemo.contains(0, aTree));
        System.out.println(myTreeDemo.getMax(aTree).key);
//        System.out.println(myTreeDemo.getMin(aTree).key);

    }


    @Test
    public void test02(){
                Scanner sc = new Scanner(System.in);
                int m = sc.nextInt();
                int max = 0;
                String s = "";
                for(int i = 0;i < m;i++){
                    int n = sc.nextInt();
                    int k = sc.nextInt();
                    int d1 = sc.nextInt();
                    int d2 = sc.nextInt();
                    max = d1>d2?d1:d2;
                    max = max>(d1+d2)?max:(d1+d2);
                    if((max + d1) == (n-k)|| (max + d2) == (n - k) ){
                        if(i == m - 1){
                            s = s+"yes";
                        }else{
                            s = s +"yes\n";
                        }

                    }else{
                        if(i == m - 1){
                            s = s+"no";
                        }else{
                            s = s +"no\n";
                        }
                    }
                }
                System.out.println(s);
            }
}
