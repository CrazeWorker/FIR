package test1;

public class MinCoin {
	public static int minCoin(int money){
		int [] coin = new int[]{1,3,5};
		int [] dp = new int [money+1];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = i;
		}
		int min = 0;
		for (int i = 3; i < money+1; i++) {
			for (int j = 0; j < coin.length; j++) {
				if(i >= coin[j]&&dp[i-coin[j]] < dp[i]){
					dp[i] = dp[i-coin[j]] + 1;
				}
			}
		}
		return dp[money];
	}
	public static void main(String[] args) {
		System.out.println(minCoin(21));
	}
}
