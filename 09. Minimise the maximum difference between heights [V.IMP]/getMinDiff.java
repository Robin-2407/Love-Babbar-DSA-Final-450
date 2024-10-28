import java.util.Arrays;

class Solution {
    public static int getMinDiff(int[] arr, int k) {
        int n = arr.length;
        if (n == 1) {
            return 0;  // Only one tower, so the difference is zero.
        }

        // Sort the array to get towers in ascending order of heights.
        Arrays.sort(arr);

        // Initial difference between the highest and lowest towers.
        int result = arr[n - 1] - arr[0];

        // The smallest and largest values after potential changes.
        int smallest = arr[0] + k;
        int largest = arr[n - 1] - k;

        for (int i = 0; i < n - 1; i++) {
            // We need to skip cases where heights go negative
            if (arr[i + 1] - k < 0) {
                continue;
            }
            
            int minHeight = Math.min(smallest, arr[i + 1] - k);
            int maxHeight = Math.max(largest, arr[i] + k);
            
            result = Math.min(result, maxHeight - minHeight);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 5, 8, 10};
        int k1 = 2;
        System.out.println("Minimum difference: " + getMinDiff(arr1, k1)); // Output: 5

        int[] arr2 = {3, 9, 12, 16, 20};
        int k2 = 3;
        System.out.println("Minimum difference: " + getMinDiff(arr2, k2)); // Output: 11
    }
}
