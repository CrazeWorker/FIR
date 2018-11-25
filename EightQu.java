package Day_1;

import org.junit.Test;

public class EightQu {
	public void eightQu(int[] state,int cur) {
		// �ݹ��������
		if(cur == 8) {
			for (int i : state) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
		
		// �жϵ�ǰ��ʺ��ܷ�ŵ���ǰ����
		for (int pos = 0; pos < 8; pos++) {
			state[cur] = pos;
			boolean flag = true;
			// �ж��Ƿ��ǺϷ�λ��
			for (int col = 0; col < cur; col++) {
				// �ж��Ƿ�ͬ��
				boolean sameCol = state[col] == pos;
				// �ж��Ƿ���ͬһ�Խ���
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
