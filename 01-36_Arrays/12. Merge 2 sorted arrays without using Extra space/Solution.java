import java.util.Arrays;

public class Solution {
    public static void BruteForce(int arr[], int arr2[]) {
        int n = arr.length;
        int m = arr2.length;
        int arr3[] = new int[n + m];

        System.arraycopy(arr, 0, arr3, 0, n);
        System.arraycopy(arr2, 0, arr3, n, m);

        Arrays.sort(arr3);

        for (int i = 0; i < n; i++) {
            arr[i] = arr3[i];
        }

        for (int i = 0; i < m; i++) {
            arr2[i] = arr3[n + i];
        }
        printArray(arr);
        printArray(arr2);
    }

    public static void optimalApproach1(int arr[], int arr2[]) {
        int n = arr.length;
        int m = arr2.length;

        int i = n - 1;
        int j = 0;

        while (i >= 0 && j < m) {
            if (arr[i] > arr2[j]) {
                int temp = arr[i];
                arr[i] = arr2[j];
                arr2[j] = temp;
            }
            i--;
            j++;
        }

        Arrays.sort(arr);
        Arrays.sort(arr2);

    }

    public static void optimalApproach2(int arr[], int arr2[], int n, int m) {
        int len = n + m;
        int gap = (len / 2) + (len % 2);

        while (gap > 0) {
            int left = 0;
            int right = left + gap;

            while (right < len) {
                if (left < n && right >= n) {
                    // left in arr1, right in arr2
                    if (arr[left] > arr2[right - n]) {
                        // Swap arr[left] and arr2[right - n]
                        int temp = arr[left];
                        arr[left] = arr2[right - n];
                        arr2[right - n] = temp;
                    }
                } else if (left >= n) {
                    // Both in arr2
                    if (arr2[left - n] > arr2[right - n]) {
                        // Swap arr2[left - n] and arr2[right - n]
                        int temp = arr2[left - n];
                        arr2[left - n] = arr2[right - n];
                        arr2[right - n] = temp;
                    }
                } else {
                    // Both in arr1
                    if (arr[left] > arr[right]) {
                        // Swap arr[left] and arr[right]
                        int temp = arr[left];
                        arr[left] = arr[right];
                        arr[right] = temp;
                    }
                }

                left++;
                right++;
            }

            // Update the gap
            if (gap == 1) {
                gap = 0;
            } else {
                gap = (gap / 2) + (gap % 2);
            }
        }
    }

    public static void swap(int arr[], int arr2[], int idx1, int idx2) {
        if (arr[idx1] > arr2[idx2]) {
            int temp = arr[idx1];
            arr[idx1] = arr[idx2];
            arr[idx2] = temp;
        }
    }

    public static void printArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 5, 7 };
        int arr2[] = { 0, 2, 6, 8, 9 };

        // BruteForce(arr, arr2);
        // optimalApproach1(arr, arr2);
        optimalApproach2(arr, arr2, arr.length, arr2.length);

        printArray(arr);
        printArray(arr2);
    }
}

// BruteForce
// Time Complexity: O((n + m) * log(n + m)) [Due to sorting]
// Space Complexity: O(n + m) [For combined array]

// Optimal Approach 1
// Time Complexity: O(min(n, m)) + O(n log n) + O(m log m)
// Space Complexity: O(1)

// Optimal Approach 2
// Time Complexity: O((n + m) * log(n + m))
// Space Complexity: O(1)