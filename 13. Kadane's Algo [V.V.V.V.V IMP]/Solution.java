public class Solution {
    // Function to find the maximum sum of a contiguous subarray
    public static int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int currentMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Update currentMax to be either the current element or currentMax + current
            // element
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            // Update maxSoFar to be the maximum of itself and currentMax
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int result = maxSubArray(nums);
        System.out.println("The maximum sum of a contiguous subarray is: " + result);
    }
}
