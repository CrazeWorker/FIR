package ’ª∫Õ∂”¡–;

import java.util.Stack;

import org.junit.Test;

public class BracketsMatching {
	public boolean matching(String cs) {
		if(cs.length() == 0||cs.equals("")) {
			return false;
		}
		else if(cs.length() % 2 != 0) {
			return false;
		}
		else {
			Stack<Character> s = new Stack<>();
			for (int i = 0; i < cs.length(); i++) {
				char c = cs.charAt(i);
				switch(c) {
					case '(':
					case '{':
					case '[':
						s.push(c);
						break;
					case ')':
						if(s.isEmpty()||s.peek() != '(') {
							return false;
						}
						else {
							s.pop();
						}
						break;
					case '}':
						if(s.isEmpty()||s.peek() != '{') {
							return false;
						}
						else {
							s.pop();
						}
						break;
					case ']':
						if(s.isEmpty()||s.peek() != '[') {
							return false;
						}
						else {
							s.pop();
						}
						break;
				}
			}
			return true;
		}
	}
	
	@Test
	public void test() {
		String s1 = "{([]})";
		String s2 = "{([])}(){[[";
		String s3 = "{()}[]";
		System.out.println(matching(s1)+" "+matching(s2)+" "+matching(s3)+" ");
	}
}
