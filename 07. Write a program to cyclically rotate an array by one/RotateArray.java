import java.util.Arrays; // Import Arrays for easy array operations

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };

        System.out.println("Original Array: " + Arrays.toString(arr));
        rotateArrayByOne(arr);
        System.out.println("Rotated Array: " + Arrays.toString(arr));
    }

    public static void rotateArrayByOne(int[] arr) {
        if (arr.length == 0)
            return;

        int last = arr[arr.length - 1];
        int i = arr.length - 2;

        while (i >= 0) {
            arr[i + 1] = arr[i];
            i--;
        }

        arr[0] = last;
    }
}
