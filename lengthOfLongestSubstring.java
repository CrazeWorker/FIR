package Question;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

/*
����һ���ַ������ҳ��������ظ��ַ�����Ӵ��ĳ��ȡ�

ʾ�� 1:

����: "abcabcbb"
���: 3 
����: ���ظ��ַ�����Ӵ��� "abc"���䳤��Ϊ 3��
ʾ�� 2:

����: "bbbbb"
���: 1
����: ���ظ��ַ�����Ӵ��� "b"���䳤��Ϊ 1��
ʾ�� 3:

����: "pwwkew"
���: 3
����: ���ظ��ַ�����Ӵ��� "wke"���䳤��Ϊ 3��
     ��ע�⣬�𰸱�����һ���Ӵ���"pwke" ��һ�������� �������Ӵ���
*/

public class lengthOfLongestSubstring {
	public int lengthOfLongestSubstring(String s) {
        ArrayList<Integer> length = new ArrayList<>();
        ArrayList<Character> c = new ArrayList<>();
        char cs;
        if(s.equals(null)||s==""||s.length()==0) {
        	return 0;
        }
        for (int i = 0; i < s.length(); i++) {
			cs = s.charAt(i);
			if(c.contains(cs)) {
				length.add(c.size());
				int m = 0;
				while(m <= c.indexOf(cs)) {
					c.remove(m);
				}
				c.add(cs);
			}else {
				c.add(cs);
			}
		}
        length.add(c.size());
        int n = Collections.max(length);
        return n;
    }
	
	
	@Test
	public void test() {
		String s = "bvbe";
		System.out.println(lengthOfLongestSubstring(s));
	}
}
