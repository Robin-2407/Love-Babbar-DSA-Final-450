// Brute Force Approach to count inversions
// Time Complexity: O(n^2)
// Space Complexity: O(1)

public class InversionCount {
    public static int countInversionsBruteForce(int[] arr) {
        int n = arr.length;
        int count = 0;

        // Check each pair (i, j) where i < j
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    count++; // Increment count if arr[i] > arr[j]
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2 };
        System.out.println("Brute Force Inversion Count: " +
                countInversionsBruteForce(arr));
    }
}

// Optimized Approach using Merge Sort
// Time Complexity: O(n log n)
// Space Complexity: O(n)

public class InversionCount {
    public static int countInversionsMergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        return mergeSortAndCount(arr, temp, 0, arr.length - 1);
    }

    // Recursive merge sort function
    private static int mergeSortAndCount(int[] arr, int[] temp, int left, int right) {
        int mid, invCount = 0;
        if (left < right) {
            mid = (left + right) / 2;

            // Count inversions in left and right subarrays
            invCount += mergeSortAndCount(arr, temp, left, mid);
            invCount += mergeSortAndCount(arr, temp, mid + 1, right);

            // Count inversions during the merge process
            invCount += mergeAndCount(arr, temp, left, mid, right);
        }
        return invCount;
    }

    // Merge two sorted halves and count inversions
    private static int mergeAndCount(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left; // Index for left subarray
        int j = mid + 1; // Index for right subarray
        int k = left; // Index for resultant merged subarray
        int invCount = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                invCount += (mid + 1 - i); // Count inversions
            }
        }

        // Copy remaining elements from left subarray
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy remaining elements from right subarray
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // Copy the sorted subarray back into the original array
        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

        return invCount;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2 };
        System.out.println("Optimized Merge Sort Inversion Count: " + countInversionsMergeSort(arr));
    }
}
