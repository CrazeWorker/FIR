package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        if (A.length == 0) {
            return null;
        }
        int length = A.length;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (A[i] % 2 == 0) {
                list1.add(A[i]);
            } else {
                list2.add(A[i]);
            }
        }
        for (int i = 0; i < length; i++) {
            A[i] = i % 2 == 0 ? list1.remove(0) : list2.remove(0);
        }
        return A;
    }

    public int[] sortArrayByParityII2(int[] A) {
        int i = 0, j = 1;
        int length = A.length;
        int[] arr = new int[length];
        for (int k = 0; k < length; k++) {
            if (A[k] % 2 == 0) {
                arr[i] = A[k];
                i += 2;
            } else {
                arr[j] = A[k];
                j += 2;
            }
        }
        return arr;
    }

    @Test
    public void test(){
        int[] a = {4, 2, 5, 7};
        System.out.println(Arrays.toString(sortArrayByParityII(a)));
    }
}
