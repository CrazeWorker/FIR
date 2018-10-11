package Question;

import org.junit.Test;

public class MyAtoi {
	public int myAtoi(String str) {
        str = str.trim();
        String res = "";
        int n=0;
        if(str.equals("")) {
        	return 0;
        }
        if ((str.charAt(0) >= 48&&str.charAt(0) <= 57) || str.charAt(0) =='-'||str.charAt(0)=='+') {
        	res += str.charAt(0);
        	int i = 1;
        	if(i == str.length()) {
        		if(res.equals("+")||res.equals("-")) {
            		return 0;
            	}
				return Integer.parseInt(res);
			}
			while(str.charAt(i) >= 48&&str.charAt(i) <= 57) {
				res += str.charAt(i);
				i++;
				if(i == str.length()) {
					break;
				}
			}
		}else {
			return 0;
		}
        try {
        	if(res.equals("+")||res.equals("-")) {
        		return 0;
        	}
        	n = Integer.parseInt(res);
        }catch (Exception e) {
        	if(res.charAt(0)=='-') {
        		return -2147483648;
        	}else {
        		return 2147483647;
        	}
        	
		}
        return n;  
    }
	
	
	@Test
	public void test() {
		System.out.println(myAtoi("2147483647"));
	}
}
