import java.util.HashSet;

public class UnionOfArrays {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5 };
        int[] b = { 4, 5, 6, 7, 8 };
        int count = getUnionCount(a, b);
        System.out.println("Count of unique elements in union: " + count);
    }

    public static int getUnionCount(int[] array1, int[] array2) {
        HashSet<Integer> unionSet = new HashSet<>();
        for (int num : array1) {
            unionSet.add(num);
        }

        for (int num : array2) {
            unionSet.add(num);
        }
        return unionSet.size();
    }
}

// Time Complexity: O(n + m)
// Space Complexity: O(n + m)
