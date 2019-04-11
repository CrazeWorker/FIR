package question;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] num = new int[t];
        for (int i = 0; i < t; i++) {
            num[i] = sc.nextInt();
        }
        for (int i = 0; i < num.length; i++) {
            if (num[i] == 1) {
                System.out.println(0);
            } else { 
                int count = 0;
                while (num[i] != 1) {
                    if (num[i] % 2 != 0) {
                        num[i] = num[i] * 3 + 1;
                    } else {
                        num[i] = num[i] / 2;
                    }
                    count ++;
                }
                System.out.println(count);
            }
        }
    }
}
