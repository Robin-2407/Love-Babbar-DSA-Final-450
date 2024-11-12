import java.util.Arrays;
public class Sort012 {
    public static void sortColors(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                // Swap arr[low] and arr[mid]
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                // Move to the next element
                mid++;
            } else if (arr[mid] == 2) {
                // Swap arr[mid] and arr[high]
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 0, 1, 2, 1, 0, 2, 1, 0, 2, 1, 0 };
        sortColors(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}


// Time Complexity: 𝑂(𝑛)
// Space Complexity: 𝑂(1)