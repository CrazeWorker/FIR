package question;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        if (n == 1) {
            System.out.println();
        }
        List<Integer> arr = new ArrayList<>();
        for (int i = 1; i < n+1; i++) {
            arr.add(i);
        }
        int i = 0;
        while (arr.size() > 1) {
            i = (i + m - 1) % arr.size();
            if (arr.size() != 2) {
                System.out.print(arr.get(i) + " ");
            } else {
                System.out.println(arr.get(i));
            }
            arr.remove(i);
        }
        System.out.println(arr.get(0));
    }
}
