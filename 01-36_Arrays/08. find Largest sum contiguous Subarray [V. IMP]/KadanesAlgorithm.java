public class KadanesAlgorithm {
    public static int maxSubArraySum(int[] arr) {
        // Initialize maxSum and currentSum with the first element of the array
        int maxSum = arr[0];
        int currentSum = arr[0];

        // Loop through the array starting from the second element
        for (int i = 1; i < arr.length; i++) {
            // Update currentSum to be either the current element itself
            // or currentSum + arr[i], whichever is greater
            currentSum = Math.max(arr[i], currentSum + arr[i]);

            // Update maxSum if currentSum is greater than maxSum
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println("Maximum subarray sum is " + maxSubArraySum(arr));
    }
}
