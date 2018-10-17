package Question;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
    	String res = "";
    	ArrayList<Integer> al = new ArrayList<>();
    	if(strs.length == 0) {
    		return "";
    	}
    	for (int j = 0; j < strs.length; j++) {
			al.add(strs[j].length());
		}
    	int n = Collections.min(al);
    	int m = al.indexOf(n);
        for (int j = 0; j < n; j++) {
        	boolean flag = false;
			char c = strs[m].charAt(j);
			for (int k = 0; k < strs.length; k++) {
				if(k == m) {
					continue;
				}
				if(strs[k].charAt(j)!=c) {
					flag = true;
					break;
				}
			}
			if(!flag) {
				res += c;
			}else {
				break;
			}
		}
        return res;
    }
    
    @Test
    public void test() {
    	String[] s = {"aca","cba"};
    	System.out.println(longestCommonPrefix(s));
    }
}
