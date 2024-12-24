import java.lang.reflect.Array;
import java.util.*;

public class Solution {

    public static List<List<Integer>> BruteForce(int[] arr) {
        Set<List<Integer>> uniquePairs = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == 0) {
                    List<Integer> pair = Arrays.asList(arr[i], arr[j]);
                    Collections.sort(pair); // Ensure the pair is sorted
                    uniquePairs.add(pair);
                }
            }
        }

        // Convert set to sorted list
        List<List<Integer>> result = new ArrayList<>(uniquePairs);
        result.sort((a, b) -> {
            if (!a.get(0).equals(b.get(0)))
                return a.get(0) - b.get(0);
            return a.get(1) - b.get(1);
        });

        return result;
    }

    public static List<List<Integer>> optimized(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == 0) {
                result.add(Arrays.asList(arr[left], arr[right]));
                left++;
                right--;

                // skip duplicates
                while (left < right && arr[left] == arr[left - 1]) {
                    left++;
                }
                while (left < right && arr[right] == arr[right + 1]) {
                    right--;
                }

            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { -1, 0, 1, 2, -1, -4 };
        int[] arr2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        // System.out.println(BruteForce(arr)); // Output: [[-1, 1]]
        System.out.println(optimized(arr2)); // Output: [[-1, 1], [-1, 2], [0, 0]]
    }
}
