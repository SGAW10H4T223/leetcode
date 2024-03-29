package stock;

/*
* 309. 最佳买卖股票时机含冷冻期
* */
public class MaxProfit5 {
    public int maxProfit(int[] prices) {
        if(prices.length < 2)
            return 0;
        int[][] dp = new int[prices.length+1][2];

        dp[0][0] = 0;
        dp[0][1] = -Integer.MIN_VALUE;
        for (int i=1;i<=prices.length;i++){
            if (i == 1){
                dp[i][0] = 0;
                dp[i][1] = -prices[i-1];
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i-1]);

            dp[i][1] = Math.max(dp[i-1][1],dp[i-2][0]-prices[i-1]);

        }
        return dp[prices.length][0];
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        new MaxProfit5().maxProfit(prices);
    }
}
