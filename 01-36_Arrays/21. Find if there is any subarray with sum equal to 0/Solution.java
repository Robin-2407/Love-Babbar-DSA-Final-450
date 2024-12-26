
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static boolean bruteForce(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int sum = arr[i];
            for (int j = i + 1; j < n; j++) {
                sum += arr[j];
                if (sum == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean optimized(int[] arr) {
        int n = arr.length;
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (arr[i] == 0 || sum == 0 || set.contains(sum)) {
                return true;
            }
            set.add(sum);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 2, -3, 1, 6 };
        // System.out.println(bruteForce(arr));
        System.out.println(optimized(arr));
    }
}
