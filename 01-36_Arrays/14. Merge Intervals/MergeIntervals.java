/* 
Brute Force Approach:
Compare every interval with every other interval.
If two intervals overlap, merge them into a single interval.
Repeat this process until no intervals overlap.
This approach is inefficient as it involves multiple passes and comparisons for overlapping intervals.

Optimized Approach:
Sort the Intervals: Sort the array of intervals based on the starting times.
Iterate and Merge: Traverse the sorted intervals:
If the current interval overlaps with the previous interval, merge them by updating the end of the previous interval.
Otherwise, add the current interval to the result.
Return the Result: Output the merged intervals. 
*/

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        // Step 1: Sort the intervals based on their start time
        // This ensures that intervals are arranged in increasing order of start times.
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Create a list to store the merged intervals
        // This list will hold the final merged intervals dynamically.
        ArrayList<int[]> merged = new ArrayList<>();

        // Step 3: Iterate through each interval
        for (int[] interval : intervals) {
            // If the merged list is empty, or if the current interval does NOT overlap
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                // Add the current interval as is, since there’s no overlap.
                merged.add(interval);
            } else {
                // If there’s overlap, merge the intervals:
                // Update the end time of the last interval in the merged list
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }

        // Step 4: Convert the list to an array and return it
        return merged.toArray(new int[merged.size()][]);
        // Convert the dynamic list into a 2D array as required by the problem.
    }

    public static void main(String[] args) {
        // Example input: List of intervals
        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };

        // Call the merge method and get the result
        int[][] mergedIntervals = merge(intervals);

        // Print the merged intervals
        for (int[] interval : mergedIntervals) {
            System.out.println(Arrays.toString(interval));
        }
    }
}

// Time Complexity: O(n log n)
// Explanation: Sorting takes O(n log n) time, and traversing the intervals
// takes O(n).

// Space Complexity: O(n)
// Explanation: Space is used for the merged list.
