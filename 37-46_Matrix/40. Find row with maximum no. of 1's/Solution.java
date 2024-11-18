class Solution {
    public int rowWithMax1s(int[][] matrix) {
        int n = matrix.length; // Number of rows
        int m = matrix[0].length; // Number of columns
        int maxRowIndex = -1; // To keep track of the row index with max 1s
        int j = m - 1; // Start from the last column
        int i = 0; // Start from the first row

        // Use a single while loop to traverse the matrix
        while (i < n && j >= 0) {
            if (matrix[i][j] == 1) {
                maxRowIndex = i; // Update the index of the row with max 1s
                j--; // Move left
            } else {
                i++; // Move down
            }
        }

        return maxRowIndex; // Return the row index with the maximum number of 1s
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 0, 1, 1, 1 },
                { 0, 0, 1, 1 },
                { 1, 1, 1, 1 },
                { 0, 0, 0, 0 }
        };

        int result = sol.rowWithMax1s(matrix);
        System.out.println("The row with the maximum number of 1s is: " + result); // Expected output: 2
    }
}

// Time Complexity: 𝑂(𝑛+𝑚);
// Space Complexity O(1);
