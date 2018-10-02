package test1;


public class StringDecode {
	public static int decode(String s){
		int dp[] = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			if(i == 0){
				dp[i] = i+1;
			}
			else if(i == 1){
				if(Integer.parseInt(s.substring(i-1, i+1))<27){
					dp[i] = 2;
				}
				else{
					dp[i] = dp[i-1];
				}
			}
			else{
				dp[i] = dp[i-1];
				if(Integer.parseInt(s.substring(i-1, i+1))<27){
					dp[i] += dp[i-2];
				}
			}
		}
		return dp[s.length()-1];
	}
	
	public static void main(String[] args) {
		String s = "1231725";
		System.out.println(decode(s));
	}
}
