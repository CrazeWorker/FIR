package com.test;

import java.io.IOException;

public class MyDataSourceTest {
    public static void main(String[] args) throws IOException {
        int a = 2436;
        for (int i = 1; i < 2436; i++) {
            if (a % i == 1) {

                    System.out.println(i);
                

            }
        }
    }

    public String encrypt(String str) {
        String code = "";

        int len = str.length();
        int group_len = ((len % 5) == 0) ? len / 5 : len / 5 + 1;
        char groups[][] = new char[100][100];
        char[] c = str.toCharArray();
        int cc = c.length / 5;
        int cr = c.length % 5;
        if (cr != 0) {
            for (int i = 0; i < 5 - cr; i++) {
                c[c.length + i] = 0;
            }
        }

        for (int i = 0; i < group_len; i++) {
            for (int j = 0; j < 5; j++) {
                groups[i][j] = c[i * 5 + j];
//				System.out.print(groups[i][j]);
            }
        }

        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < group_len; i++) {
                code += groups[i][j];
            }
        }

        return code;
    }
}