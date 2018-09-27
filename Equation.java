package 栈和队列;

import java.util.Stack;

import org.junit.Test;

public class Equation {
/*需求:
	 给定算术表达式，计算其最终结果，严格按照四则运算规则进行
*/
	
	// 计算
	public static int equation(String s) {
		char[] eq = s.toCharArray();
		Stack<Integer> number = new Stack<>();
		Stack<Character> symbol = new Stack<>();
		int n = 0;
		String str;
		for (int i = 0; i < eq.length; i++) {
			int sum = 0;
			if(eq[i] >= 48&&eq[i] <= 57) {
				str = "";
				while(eq[i] >= 48&&eq[i] <= 57) {
					str += eq[i];
					i++;
					if(i == eq.length) {
						break;
					}
				}
				i = i - 1;
				number.push(Integer.parseInt(str));
			}
			else if(eq[i] == '+'||eq[i] == '-'||eq[i] == '*'||eq[i] == '/'||eq[i] == '('||eq[i] == ')') {
				if(symbol.size() == 0||eq[i] == '(') {
					symbol.push(eq[i]);
				}
				else {
					if(compare(eq[i]) <= compare(symbol.peek())||eq[i] == ')') {
						if(eq[i] != ')') {
							int temp = caculate(number.pop(),number.pop(),symbol.pop());
							number.push(temp);
							symbol.push(eq[i]);
						}
						else {			
							while(symbol.peek() != '(') {
								int number1 = number.pop();
								int number2 = number.pop();
								int temp = caculate(number1,number2,symbol.pop());
								number.push(temp);
							}
							symbol.pop();
						}
					}
					else {
						symbol.push(eq[i]);
					}
				}
			}
		}
		if(!symbol.isEmpty()) {
			while(!symbol.isEmpty()) {
				int number1 = number.pop();
				int number2 = number.pop();
				int temp = caculate(number1,number2,symbol.pop());
				number.push(temp);
			}
			return number.peek();
		}
		else
			return number.peek();
	}
	@Test
	public void testNum() {
		String s = "(31+23)/2";
		System.out.println(equation(s));
	}
	// 符号优先级
	public static int compare(char c2) {
		switch(c2) {
		case '+':
		case '-': return 1;
		case '*':
		case '/': return 2;
		default:  return -1;
		}
	}
	
	// 计算
	public static int caculate(int number2,int number1,char c2) {
		switch(c2) {
			case '+': return number1+number2;
			case '-': return number1-number2;
			case '*': return number1*number2;
			case '/': return number1/number2;
			default:  return -1;
		}
	}
}
