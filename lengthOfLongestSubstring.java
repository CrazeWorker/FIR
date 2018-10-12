package Question;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

/*
给定一个字符串，找出不含有重复字符的最长子串的长度。

示例 1:

输入: "abcabcbb"
输出: 3 
解释: 无重复字符的最长子串是 "abc"，其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 无重复字符的最长子串是 "b"，其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 无重复字符的最长子串是 "wke"，其长度为 3。
     请注意，答案必须是一个子串，"pwke" 是一个子序列 而不是子串。
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
