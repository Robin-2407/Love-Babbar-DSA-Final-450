import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

public class IntersectionOptimized {

    public static List<Integer> findIntersection(int[] arr1, int[] arr2) {
        // Use a HashSet for faster lookups
        Set<Integer> set = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();

        // Add elements of the smaller array to the HashSet
        for (int num : arr1) {
            set.add(num);
        }

        // Check for common elements in the second array
        for (int num : arr2) {
            if (set.contains(num)) {
                resultSet.add(num); // Avoid duplicates
            }
        }

        // Convert result set to a list
        return new ArrayList<>(resultSet);
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 5, 6};
        int[] arr2 = {2, 3, 5, 7};

        List<Integer> intersection = findIntersection(arr1, arr2);
        System.out.println("Intersection: " + intersection);
    }
}
