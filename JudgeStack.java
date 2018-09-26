package ’ª∫Õ∂”¡–;

import java.util.Stack;

import org.junit.Test;

public class JudgeStack {
	public boolean judge(Integer[] pushS,Integer[] popS) {
		Stack<Integer> s = new Stack<>();
		int i = 0;
		for (Integer integer : popS) {
			if(!s.isEmpty()&&s.peek().equals(integer)) {
				s.pop();
			}
			else {
				while(true) {
					if(i >= popS.length) {
						return false;
					}
					else if(pushS[i].equals(integer)) {
						i++;
						break;
					}
					else {
						s.push(pushS[i]);
						i++;
					}
				}
			}
		}
		return true;
	}
	
	@Test
	public void test() {
		Integer[] pushS = {1,2,3,4,5};
		Integer[] pop1 = {4,5,3,2,1};
		Integer[] pop2 = {4,3,5,1,2};
		Integer[] pop3 = {3,5,4,2,1};
		boolean flag1 = judge(pushS,pop1);
		boolean flag2 = judge(pushS,pop2);
		boolean flag3 = judge(pushS,pop3);
		System.out.println(flag1+" "+flag2+" "+flag3);
		
	}
}
	
