package ’ª∫Õ∂”¡–;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class UglyNumberII {
	public int isUgly(int n) {
		Queue<Integer> q2 = new LinkedList<>();
		Queue<Integer> q3 = new LinkedList<>();
		Queue<Integer> q5 = new LinkedList<>();

		int i = 1,count = 1;
		while(count<n) {
			q2.offer(i*2);
			q3.offer(i*3);
			q5.offer(i*5);
			int min2 = q2.peek();
			int min3 = q3.peek();
			int min5 = q5.peek();
			int min = Math.min(Math.min(min2, min3), min5);
			if(min2 == min) {
				q2.poll();
			}
			if(min3 == min) {
				q3.poll();
			}
			if(min5 == min) {
				q5.poll();
			}
			i = min;
			count++;
		}
		return i;
	}
	
	@Test
	public void test() {
		System.out.println(isUgly(20));
		System.out.println(isUgly(1352));
	}
	
}
