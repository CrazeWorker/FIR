import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] chars = s.toCharArray();
        s = "";
        int i = 0, j;
        while (i < chars.length) {
            s += chars[i];
            if (i == chars.length - 1) {
                break;
            }
            j = i + 1;
            if (chars[i] != chars[j]) {
                i = j;
            } else {
                s = s + chars[j];
                if (j == chars.length - 1) {
                    break;
                }
                j++;
                // 不相等，判断下一个是否与当前字符相等
                if (chars[i] != chars[j]) {
                    s = s + chars[j];
                    if (j == chars.length - 1) {
                        break;
                    }
                    if (chars[j] != chars[j + 1]) {
                        i = j + 1;
                    } else {
                        if (j + 2 >= chars.length) {
                            break;
                        }
                        i = j + 2;
                    }
                    // 多个相连
                } else {
                    while (j <= chars.length - 1 && chars[j] == chars[i]) {
                        j++;
                    }
                    int m = j;
                    while (j <= chars.length - 1 && chars[m] == chars[i]) {
                        j++;
                    }
                    i = j;
                }
            }
        }
        System.out.println(s);
    }
}