class Solution {
    public static int[][] sortedMatrix(int N, int[][] Mat) {
        // Step 1: Extract all elements from the matrix into a single array
        int[] elements = new int[N * N];
        int index = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                elements[index++] = Mat[i][j];
            }
        }

        // Step 2: Sort the array using Merge Sort
        mergeSort(elements, 0, elements.length - 1); // Correctly call mergeSort without static

        // Step 3: Place sorted elements back into the matrix
        index = 0; // Reset index to fill the matrix
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Mat[i][j] = elements[index++];
            }
        }

        return Mat; // Return the sorted matrix
    }

    // Merge Sort function
    private static void mergeSort(int[] arr, int left, int right) { // Made this static
        if (left < right) {
            int mid = left + (right - left) / 2; // Find the mid index

            // Recursively sort first and second halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    // Function to merge two halves
    private static void merge(int[] arr, int left, int mid, int right) { // Made this static
        // Sizes of the two subarrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        // Merge the temporary arrays back into arr[left..right]
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k++] = L[i++];
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k++] = R[j++];
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] matrix = {
                { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 27, 29, 37, 48 },
                { 32, 33, 39, 50 }
        };

        int[][] sortedMatrix = sol.sortedMatrix(4, matrix);
        for (int[] row : sortedMatrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// Time Complexity:𝑂(𝑁^2log𝑁);
// Space Complexity O(N^2 logN)