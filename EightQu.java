package Day_1;

import org.junit.Test;

public class EightQu {
	public void eightQu(int[] state,int cur) {
		// 递归结束条件
		if(cur == 8) {
			for (int i : state) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
		
		// 判断当前层皇后能否放到当前的列
		for (int pos = 0; pos < 8; pos++) {
			state[cur] = pos;
			boolean flag = true;
			// 判断是否是合法位置
			for (int col = 0; col < cur; col++) {
				// 判断是否同列
				boolean sameCol = state[col] == pos;
				// 判断是否在同一对角线
				boolean sameDiagonal = Math.abs(pos - state[col]) == Math.abs(col - cur);
				if(sameCol||sameDiagonal) {
					flag = false;
					break;
				}
			}
			if(flag) {
				eightQu(state,cur + 1);
			}
		}
	}
	
	@Test
	public void test() {
		int[] state = new int[8];
		eightQu(state,0);
	}
}
