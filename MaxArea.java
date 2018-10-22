package Question;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class MaxArea {
    public int maxArea(int[] height) {
    	int area = 0;
        for (int i = 0; i < height.length; i++) {
			for (int j = i; j < height.length; j++) {
				int len = Math.min(height[i], height[j]);
				int wid = j-i;
				area = Math.max(area, wid*len);
			}
		}
        return area;
    }
    
    @Test
    public void test() {
    	int[] a = {1,8,6,2,5,4,8,3,7};
    	System.out.println(maxArea(a));
    }
}
