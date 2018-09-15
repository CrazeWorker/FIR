package ’ª∫Õ∂”¡–;

import java.util.Collections;
import java.util.Stack;

import org.junit.Test;

public class SimplifyPath {
	public String simplifyPath(String s) {
		String[] array = s.split("/");
		Stack<String> stack = new Stack<>();
		for (String string : array) {
			if(string.equals("")||string.equals(".")) {
				continue;
			}
			else if(string.equals("..")) {
				if (stack.isEmpty()) {
					stack.push(string);
				}
				else {
					stack.pop();	
				}	
			}
			else {
				stack.push(string);
			}
		}
		if(stack.isEmpty()) {
			return "/";
		}
		else {
			StringBuilder sb = new StringBuilder();
			Collections.reverse(stack);
			while(!stack.isEmpty()) {
					sb.append("/").append(stack.pop());
			}
			return sb.toString();
		}
		
	}
	
	@Test
	public void test() {
		System.out.println(simplifyPath("/../.."));
		System.out.println(simplifyPath("/home//foo//"));
		System.out.println(simplifyPath("a/./b/../../c/d/"));
	}
}
