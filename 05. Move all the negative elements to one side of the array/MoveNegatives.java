import java.util.Arrays;

public class MoveNegatives {
    public static void moveNegativesToStart(int[] arr) {
        int left = 0; // Pointer starting from the beginning
        int right = arr.length - 1; // Pointer starting from the end

        while (left <= right) {
            if (arr[left] >= 0 && arr[right] < 0) {
                // Swap arr[left] and arr[right]
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }

            if (arr[left] < 0) {
                left++; // Move left pointer if negative
            }
            if (arr[right] >= 0) {
                right--; // Move right pointer if positive
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { -1, 2, -3, 4, -5, 6, -7 };
        moveNegativesToStart(arr);
        System.out.println("Array after moving negatives: " + Arrays.toString(arr));
    }
}
