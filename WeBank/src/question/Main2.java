package question;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int m = sc.nextInt();
        if (m > n) {
            System.out.println(k);
        } else if (n * k % m == 0) {
            System.out.println(n * k / m);
        } else {
            System.out.println(n * k / m + 1);
        }

    }
}
