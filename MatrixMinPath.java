package test1;

public class MatrixMinPath {
	public static int minPath(int[][] a){
		int[][] dp = new int[a.length][a[1].length];
		dp[0][0] = a[0][0];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				if(i != 0||j != 0){
					if(i == 0){
						dp[i][j] = dp[i][j-1] + a[i][j];
					}
					else if(j == 0){
						dp[i][j] = dp[i-1][j] + a[i][j];
					}
					else{
						int temp = Math.min(dp[i-1][j], dp[i][j-1]);
						dp[i][j] = temp + a[i][j];
					}
				}
			}
		}
		return dp[a.length-1][a[1].length-1];
	}
	
	public static void main(String[] args) {
		int[][] a = new int [][]{{2,4,3,7},{5,3,2,1},{4,8,6,2}};
		System.out.println(minPath(a));
	}
}
