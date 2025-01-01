import java.util.ArrayList;

class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    public static ArrayList<Integer> spirallyTraverse(int arr[][]) {
        ArrayList<Integer> spiral = new ArrayList<>();

        int startRow = 0;
        int startCol = 0;
        int endRow = arr.length - 1;
        int endCol = arr[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            // Traverse the top row from left to right
            for (int j = startCol; j <= endCol; j++) {
                spiral.add(arr[startRow][j]);
            }
            startRow++; // Move to the next row

            // Traverse the right column from top to bottom
            for (int i = startRow; i <= endRow; i++) {
                spiral.add(arr[i][endCol]);
            }
            endCol--; // Move to the previous column

            // Traverse the bottom row from right to left (if still within bounds)
            if (startRow <= endRow) {
                for (int j = endCol; j >= startCol; j--) {
                    spiral.add(arr[endRow][j]);
                }
                endRow--; // Move to the previous row
            }

            // Traverse the left column from bottom to top (if still within bounds)
            if (startCol <= endCol) {
                for (int i = endRow; i >= startRow; i--) {
                    spiral.add(arr[i][startCol]);
                }
                startCol++; // Move to the next column
            }
        }

        return spiral;
    }

    public static void main(String[] args) {
        int[][] arr = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };
        System.out.println(spirallyTraverse(arr));
    }
}

// optimized approach
// Time Complexity is O(m*n)
// Spaace Complexity is O(1) excluding the arraylist for output

