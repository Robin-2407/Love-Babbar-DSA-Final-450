public class Solution {

    // public static int bruteForce(int[] prices) {
    // int maxProfit = 0;
    // for (int i = 0; i < prices.length; i++) {
    // for (int j = i + 1; j < prices.length; j++) {
    // int profit = prices[j] - prices[i];
    // maxProfit = Math.max(maxProfit, profit);
    // }
    // }
    // return maxProfit;
    // }

    public static int optimized(int prices[]) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        // System.out.println(bruteForce(prices));
        System.out.println(optimized(prices));
    }
}

// bruteForce
// TC: O(n^2) -> nested loops iterating over the prices array
// SC: O(1) -> only using a constant amount of space

// optimized
// TC: O(n) -> iterating over the prices array once
// SC: O(1) -> only using a constant amount of space
