public class solution {
    public static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        String test1 = "madam";
        String test2 = "hello";

        System.out.println(test1 + " is palindrome: " + isPalindrome(test1)); // Expected: true
        System.out.println(test2 + " is palindrome: " + isPalindrome(test2)); // Expected: false
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
