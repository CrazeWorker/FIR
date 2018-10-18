package Question;

import org.junit.Test;

public class IntToRoman {
    public String intToRoman(int num) {
        String[][] roman = {{"","I","II","III","IV","V","VI","VII","VIII","IX"},
        					{"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
        					{"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
        					{"","M","MM","MMM"}};
        int count = 1;
        String s = "";
        String res = "";
        	while(num != 0) {
        		int temp = num % 10;
        		s = roman[count-1][temp];
        		num = num / 10;
        		res = s + res;
        		count++;
        	}
        	return res;
        }
    
    
    @Test
    public void test() {
    	System.out.println(intToRoman(114));
    }
}
