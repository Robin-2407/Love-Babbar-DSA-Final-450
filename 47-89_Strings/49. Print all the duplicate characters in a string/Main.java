public class Main {
    public static void main(String[] args) {
        String input = "robinsukhdeverobin";
        printDuplicateCharacters(input);
    }

    public static void printDuplicateCharacters(String s) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        System.out.println("Duplicate characters with their occurrences:");
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 1) {
                System.out.println((char) (i + 'a') + ", count = " + freq[i]);
            }
        }
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
