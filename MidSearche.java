package SortAndSearch;

import org.junit.Test;


// ’€∞Î≤È’“
public class MidSearche {
	public static int midSearch(int[] nums,int target) {
		int left=0,right=nums.length -1;
		int mid;
		while(left <= right) {
			mid = (left + right)/2;
			if(nums[mid] == target) {
				return mid;
			}else if(nums[mid] > target) {
				right = mid - 1;
			}else {
				left = mid + 1;
			}
		}
		return -1;
	}
	
	@Test
	public void test() {
		int[] nums = {1,2,5,6,9,11,13,23,25};
		System.out.println(midSearch(nums,9));
		
	}
}
