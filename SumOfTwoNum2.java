package Question;

import java.util.ArrayList;

import org.junit.Test;

public class SumOfTwoNum2 {
	 public int[] twoSum(int[] nums, int target) {
		 ArrayList<Integer> list = new ArrayList<>();
		 int[] sumIndex = new int[2];
		 for (int i = 0; i < nums.length; i++) {
			int n  = target - nums[i];
			if(list.contains(n)) {
				return new int[] {list.indexOf(n),i};
			}
			list.add(nums[i]);
		}
		 return sumIndex;
	 }
	 
	 
	 @Test
		public void test() {
		 	int[] a = {3,2,4};
		 	int[] b = twoSum(a, 6);
			System.out.println("["+b[0]+","+b[1]+"]");
		}
}
