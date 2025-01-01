
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Integer> bruteForce(int n) {
        List<Integer> result = new ArrayList<>();
        long factorial = 1;

        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }

        String factorialString = Long.toString(factorial);
        for (char c : factorialString.toCharArray()) {
            result.add(c - '0');
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(bruteForce(n));
    }
}

// brute force approach
// Time complexity O(n)
// Space Complexity O(n)
// The above approach may not work for large values of n as the factorial of a
// number can be very large and can exceed the range of integer or long
// datatype.

