class Solution {
    int MOD = 1000000007;
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[m + 1][n + 1];
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 0; i < puddles.length; i++)
            map[puddles[i][0]][puddles[i][1]] = 1;
        
        dp[1][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) continue;
                
                int sub1 = 0, sub2 = 0;
                if (i - 1 > 0 && map[i - 1][j] == 0) sub1 = dp[i - 1][j];
                if (j - 1 > 0 && map[i][j - 1] == 0) sub2 = dp[i][j - 1];
                dp[i][j] = (sub1 + sub2) % MOD;
            }
        }
        
        return dp[m][n];
    }
}