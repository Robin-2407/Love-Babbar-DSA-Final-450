// Given three arrays sorted in non-decreasing order, print all common elements in these arrays.

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Integer> bruteForce(List<Integer> arr1, List<Integer> arr2, List<Integer> arr3) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr1.size(); i++) {
            for (int j = 0; j < arr2.size(); j++) {
                for (int k = 0; k < arr3.size(); k++) {
                    if (arr1.get(i) == arr2.get(j) && arr2.get(j) == arr3.get(k)) {
                        result.add(arr1.get(i));
                    }
                }
            }
        }
        return result;
    }

    public static List<Integer> optimized(List<Integer> arr1, List<Integer> arr2, List<Integer> arr3) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        while (i < arr1.size() && j < arr2.size() && k < arr3.size()) {
            if (arr1.get(i) == arr2.get(j) && arr2.get(j) == arr3.get(k)) {
                if (result.size() > 0 && result.get(result.size() - 1) == arr1.get(i)) {
                    result.add(arr1.get(i));
                }
                i++;
                j++;
                k++;
            } else if (arr1.get(i) < arr2.get(j)) {
                i++;
            } else if (arr2.get(j) < arr3.get(k)) {
                j++;
            } else {
                k++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> arr1 = List.of(1, 5, 10, 20, 40, 80);
        List<Integer> arr2 = List.of(6, 7, 20, 80, 100);
        List<Integer> arr3 = List.of(3, 4, 15, 20, 30, 70, 80, 120);

        System.out.println(bruteForce(arr1, arr2, arr3));
        System.out.println(optimized(arr1, arr2, arr3));
    }
}

// brute force:
// Time complexity O(n^3)
// Space Complexity O(1)

// optimized:
// Time complexity O(n)
// Space Complexity O(1)