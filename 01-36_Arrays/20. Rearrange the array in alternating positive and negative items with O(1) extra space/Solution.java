import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    static void rightRotate(int[] arr, int start, int end) {
        int temp = arr[end];
        for (int i = end; i > start; i--) {
            arr[i] = arr[i - 1];
        }
        arr[start] = temp;
    }

    public static void bruteForce(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0 && i % 2 == 1) {
                for (int j = i + 1; j < n; j++) {
                    if (arr[j] < 0) {
                        rightRotate(arr, i, j);
                        break;
                    }
                }
            } else if (arr[i] < 0 && i % 2 == 0) {
                for (int j = i + 1; j < n; j++) {
                    if (arr[j] >= 0) {
                        rightRotate(arr, i, j);
                        break;
                    }
                }
            }
        }
    }

    public static void optimized(int[] arr) {
        int n = arr.length;
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0) {
                pos.add(arr[i]);
            } else {
                neg.add(arr[i]);
            }
        }

        int i = 0, j = 0, k = 0;
        while (i < pos.size() && j < neg.size()) {
            arr[k++] = pos.get(i++);
            arr[k++] = neg.get(j++);
        }

        while (i < pos.size()) {
            arr[k++] = pos.get(i++);
        }

        while (j < neg.size()) {
            arr[k++] = neg.get(j++);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, -4, -1, 4 };
        // bruteForce(arr);
        optimized(arr);
        System.out.println(Arrays.toString(arr));
    }
}


// brute force
// tc: O(n^2)
// sc: O(1)

// optimized
// tc: O(n)
// sc: O(n)