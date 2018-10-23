package Question;

import org.junit.Test;
/*
����һ���ַ��� s���ҵ� s ����Ļ����Ӵ�������Լ��� s ����󳤶�Ϊ1000��

ʾ�� 1��

����: "babad"
���: "bab"
ע��: "aba"Ҳ��һ����Ч�𰸡�
ʾ�� 2��

����: "cbbd"
���: "bb"
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if(s.equals("")||s.length()==0) {
        	return "";
        }
        int start = 0,end = 0;
        for (int i = 0; i < s.length(); i++) {
			int len1 = judge(s,i,i);
			int len2 = judge(s,i,i+1);
			int len = Math.max(len1, len2);
			if(len>end-start) {
				start = i -(len-1)/2;
				end = i + len/2;
			}
		}
        return s.substring(start, end+1);
    }
    
    public int judge(String s,int left,int right) {
    	int r = right;
    	int l = left;
    	while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)) {
    		r++;
    		l--;
    	}
    	return r-l-1;
    }
    
    @Test
    public void test() {
    	String s = "babad";
    	System.out.println(longestPalindrome(s));
    }
}
